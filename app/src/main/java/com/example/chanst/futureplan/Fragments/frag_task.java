package com.example.chanst.futureplan.Fragments;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.chanst.futureplan.Bean.GridViewItemBean;
import com.example.chanst.futureplan.R;
import com.example.chanst.futureplan.activity.TaskDetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chanst on 16-3-15.
 */
public class frag_task extends Fragment implements View.OnClickListener {
    private View view;
    private GridView gridView;
    private Drawable photo;
    private List<GridViewItemBean> dataList1,dataList2,dataList3,dataList4;
    private listAdapter adapter;
    private LinearLayout l1,l2,l3,l4;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_task, container, false);
        initEvents();
        return view;
    }

    private void initEvents() {
        gridView = (GridView) view.findViewById(R.id.gridview);
        LoadData();

        adapter = new listAdapter(dataList1);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                if(position == 3) {
                    Log.i("hehe",""+position);
                    intent.putExtra("product", 1);
                }
                else
                    intent.putExtra("product", 0);
                intent.setClass(getActivity(), TaskDetailActivity.class);
                startActivityForResult(intent,1);
            }
        });
        l1 = (LinearLayout) view.findViewById(R.id.xiao);
        l1.setOnClickListener(this);
        l2 = (LinearLayout) view.findViewById(R.id.chuang);
        l2.setOnClickListener(this);
        l3 = (LinearLayout) view.findViewById(R.id.shi);
        l3.setOnClickListener(this);
        l4 = (LinearLayout) view.findViewById(R.id.chu);
        l4.setOnClickListener(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void LoadData() {
        dataList1 = new ArrayList<GridViewItemBean>();
        dataList1.add(new GridViewItemBean(getResources().getDrawable(R.drawable.p11),"20\n剩余天数", "你是键盘侠嘛？打字速度技能必备","200","1000学币\n每天","5学分\n每天" ));
        dataList1.add(new GridViewItemBean(getResources().getDrawable(R.drawable.p12),"15\n剩余天数", "成为破冰app优秀玩家，免费赢钻石","150","3学分\n每天","奖励\n游戏钻石" ));
        dataList1.add(new GridViewItemBean(getResources().getDrawable(R.drawable.p21),"13\n剩余天数", "趁这个机会好好练习你的excel技术吧！","56","1100学币\n每天","5学分\n每天"));
        dataList1.add(new GridViewItemBean(getResources().getDrawable(R.drawable.p22),"12\n剩余天数", "你以为只是信息采集？","73","900学币\n每天","5学分\n每天"));
        dataList1.add(new GridViewItemBean(getResources().getDrawable(R.drawable.p31),"9\n剩余天数", "你的打字速度不能再慢了！","89","1500学币\n每天","4学分\n每天"));
        dataList1.add(new GridViewItemBean(getResources().getDrawable(R.drawable.p32),"13\n剩余天数", "虽然你过了六级，但是你仍旧需要这份差事","73","880学币\n每天","5学分\n每天"));
        dataList2 = new ArrayList<GridViewItemBean>();
        dataList2.add(new GridViewItemBean(getResources().getDrawable(R.drawable.b11),"15\n剩余天数", "定义你理想中的虚拟银行","256"," 350学币×4\n优胜奖","4学分"));
        dataList2.add(new GridViewItemBean(getResources().getDrawable(R.drawable.b12),"23\n剩余天数", "如何在城市中试用你的虚拟汽车钥匙","59","500学币×3\n优胜奖","5学分"));
        dataList2.add(new GridViewItemBean(getResources().getDrawable(R.drawable.b21),"23\n剩余天数", "如何让H5在app上得到最好的利用","199","500学币×10\n鼓励奖","700学币×3\n优胜奖"));
        dataList2.add(new GridViewItemBean(getResources().getDrawable(R.drawable.b22),"23\n剩余天数", "如果你是产品体验分析师","169","20学币\n参与即可","8学分"));
        dataList2.add(new GridViewItemBean(getResources().getDrawable(R.drawable.b31),"50\n剩余天数", "你笔下的校服，山区孩子的梦","145","20学币\n参与即可","350学币\n优胜奖"));
        dataList2.add(new GridViewItemBean(getResources().getDrawable(R.drawable.b32),"10\n剩余天数", "你会写广告语吗？小心才气侧漏","98","100学币\n优胜奖","8学分"));
        dataList2.add(new GridViewItemBean(getResources().getDrawable(R.drawable.b41),"14\n剩余天数", "让我的美食APP吸引更多的美食爱好者","401","22学币\n鼓励奖","66学币\n优胜奖"));
        dataList2.add(new GridViewItemBean(getResources().getDrawable(R.drawable.b42),"25\n剩余天数", "打造你的天气工具，可以引导至最热门地点","354","78学币\n鼓励奖","100学币\n优胜奖"));
        dataList3 = new ArrayList<GridViewItemBean>();
        dataList3.add(new GridViewItemBean(getResources().getDrawable(R.drawable.c11),"2\n剩余天数", "你的学习能力强吗？销售顾问可不简单哦！","86","2000学币\n每天","16学分\n每天"));
        dataList3.add(new GridViewItemBean(getResources().getDrawable(R.drawable.c12),"20\n剩余天数", "万人之上的宅米店长都需要什么技能？","96","2000学币\n每月","19学分\n每天"));
        dataList3.add(new GridViewItemBean(getResources().getDrawable(R.drawable.c22),"12\n剩余天数", "市场推广有妙招，产品运营只差一步","40","2000学币\n每天","19学分\n每天"));
        dataList4 = new ArrayList<GridViewItemBean>();
        dataList4.add(new GridViewItemBean(getResources().getDrawable(R.drawable.d11),"15\n剩余天数", "我们公司有交流障碍，靠你了","115","321学币×10\n鼓励奖","2\n实习名额"));
        dataList4.add(new GridViewItemBean(getResources().getDrawable(R.drawable.d12),"26\n剩余天数", "提出一个可以改善人们之间日渐疏远的沟通的产品","98","321学币×7\n鼓励奖","30\n学分"));
        dataList4.add(new GridViewItemBean(getResources().getDrawable(R.drawable.d21),"12\n剩余天数", "数据程序员，挑战等你来","74","10000学币\n每月","29学分"));
        dataList4.add(new GridViewItemBean(getResources().getDrawable(R.drawable.d22),"10\n剩余天数", "数据分析专员，了解信息收集","81","2000学币\n每天","19学分\n每天"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.xiao:
                Log.i("hehe", "hehe");
                changeList(1);
                break;
            case R.id.chuang:
                changeList(2);
                break;
            case R.id.shi:
                changeList(3);
                break;
            case R.id.chu:
                changeList(4);
                break;
        }
    }

    private void changeList(int order){
        switch (order){
            case 1:
                adapter = new listAdapter(dataList1);
                Log.i("hehe", "hehe");
                break;
            case 2:
                adapter = new listAdapter(dataList2);
                break;
            case 3:
                adapter = new listAdapter(dataList3);
                break;
            case 4:
                adapter = new listAdapter(dataList4);
                break;
        }
        adapter.notifyDataSetChanged();
        gridView.setAdapter(adapter);
    }
    protected class listAdapter extends BaseAdapter {
        private List<GridViewItemBean> list;
        public listAdapter(List<GridViewItemBean> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            ViewHolder holder;
            if (view == null) {
                view = getActivity().getLayoutInflater().inflate(R.layout.gridview_item, null);
                holder = new ViewHolder();
                holder.title = (TextView) view.findViewById(R.id.gridview_item_tile);
                holder.days = (TextView) view.findViewById(R.id.gridview_item_daysLeft);
                holder.applications = (TextView) view.findViewById(R.id.gridview_item_applications);
                holder.award1 = (TextView) view.findViewById(R.id.gridview_item_award1);
                holder.award2 = (TextView) view.findViewById(R.id.gridview_item_award2);
                holder.photo = (ImageView) view.findViewById(R.id.gridview_item_photo);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            GridViewItemBean bean = list.get(position);
            if (bean != null) {
                holder.title.setText(bean.title);
                holder.days.setText(bean.days);
                holder.award1.setText(bean.award1);
                holder.award2.setText(bean.award2);
                holder.applications.setText(bean.applications+"参与战斗");
                holder.photo.setImageDrawable(bean.photo);
            }
            return view;
        }
    }
    static class ViewHolder {
        TextView title, award1, days, award2, applications;
        ImageView photo;
    }
}
