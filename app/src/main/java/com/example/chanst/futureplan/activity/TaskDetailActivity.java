package com.example.chanst.futureplan.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chanst.futureplan.R;

public class TaskDetailActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tag1,tag2,tag3, title, background, result, standard;
    private ImageView img;
    private Context mContext;
    private Intent intent;
    private int n = 0;
    private boolean fav = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);
        mContext = this;
        intent = getIntent();
        n = intent.getIntExtra("product", 3);
        Log.i("hehe",""+n);
        initEvents();
    }

    private void initEvents() {
        tag1 = (TextView) findViewById(R.id.task_detail_tag1);
        tag1.setOnClickListener(this);
        tag2 = (TextView) findViewById(R.id.task_detail_tag2);
        tag2.setOnClickListener(this);
        tag3 = (TextView) findViewById(R.id.task_detail_tag3);
        tag3.setOnClickListener(this);
        title = (TextView) findViewById(R.id.task_detail_title);
        background= (TextView) findViewById(R.id.task_detail_background);
        result = (TextView) findViewById(R.id.task_detail_result);
        standard = (TextView) findViewById(R.id.task_detail_standard);
        img = (ImageView) findViewById(R.id.task_detail_photo);
        if(n == 1){
            tag1.setText("用户需求");
            tag2.setText("二手交易");
            tag3.setText("统计学");
            title.setText("如果你是产品体验分析师");
            background.setText("貳货是一家专属于大学生的闲置物品交易平台，通过貳货你可以发现身边许多有用的闲置物品。貳货只服务于你，但是，貳货目前的竞争状况有些激烈哦。线上有闲鱼、私货，目前闲鱼占据市场优势地位，依靠淘宝的流量和资金能力在全国铺开；除此之外，潜在的竞争者还有同样针对高校的众多 O2O 项目，因此我作为一个新手，希望同学们快来深度体验一下貳货，为貳货的改进指点一二吧。");
            result.setText("1.开始任务，前往貳货玩耍，什么，你不知道怎么去？那就戳这里。\n" +
                    "2.深度体验貳货的过程中，请回答下列问题，形成一份体验报告，模板在这里：\n" +
                    "1） 貳货里面的信息对你的购物有什么帮助？\n" +
                    "2） 你觉得相比其它（如闲鱼），貳货有什么吸引你的地方？\n" +
                    "3） 对于此款软件你有哪些意见（请从界面设计、功能使用等角度去说明）\n" +
                    "3.把你在貳货上的个人信息+体验报告发至后台。");
            standard.setText("1. 要求思考细致，能够尽可能体现学生闲置物品交易的需求特征");
            img.setImageDrawable(getResources().getDrawable(R.drawable.b22));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            default:
                Intent intent = new Intent();
                intent.setClass(this, RelativeJob.class);
                startActivityForResult(intent, 1);
        }
    }
    public void joinIn(View v){
        Toast.makeText(this,"参与成功！",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK)
            finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        CreateMenu(menu);
        return true;
    }
    private void CreateMenu(Menu menu)
    {
        final MenuItem mnu1 = menu.add(0, 0, 0, "Item 1");
        {
            mnu1.setIcon(R.drawable.task_detail_heart);
            mnu1.setShowAsAction(
                    MenuItem.SHOW_AS_ACTION_IF_ROOM);
            mnu1.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    fav = !fav;
                    if(fav)
                        mnu1.setIcon(R.drawable.task_detail_heart_red);
                    else
                        mnu1.setIcon(R.drawable.task_detail_heart);
                    return false;
                }
            });
        }
        MenuItem mnu2 = menu.add(0, 1, 1, "Item 2");
        {
            mnu2.setIcon(R.drawable.task_detail_share);
            mnu2.setShowAsAction(
                    MenuItem.SHOW_AS_ACTION_IF_ROOM);
        }

    }
}
