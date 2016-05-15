package com.example.chanst.futureplan.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chanst.futureplan.Bean.GridViewItemBean;
import com.example.chanst.futureplan.R;

import java.util.ArrayList;
import java.util.List;

public class SkillRequired extends AppCompatActivity {

    private GridView gridView;

    private List<GridViewItemBean> dataList;
    private listAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_required);
        getIntent();
        initEvents();
    }
    public void toMain(View v){
        setResult(RESULT_OK);
        finish();
    }
    private void initEvents() {
        gridView = (GridView) findViewById(R.id.gridview_sub);
        dataList = new ArrayList<GridViewItemBean>();
        dataList.add(new GridViewItemBean(getResources().getDrawable(R.drawable.b41),"14\n剩余天数", "让我的美食APP吸引更多的美食爱好者","401","22学币\n鼓励奖","66学币\n优胜奖"));
        dataList.add(new GridViewItemBean(getResources().getDrawable(R.drawable.d11),"15\n剩余天数", "我们公司有交流障碍，靠你了","115","321学币×10\n鼓励奖","2\n实习名额"));
        adapter = new listAdapter(dataList);
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
                view = getLayoutInflater().inflate(R.layout.gridview_item, null);
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        CreateMenu(menu);
        return true;
    }
    private void CreateMenu(Menu menu)
    {
        MenuItem mnu1 = menu.add(0, 0, 0, "Item 1");
        {
            mnu1.setIcon(R.drawable.relative_heart);
            mnu1.setShowAsAction(
                    MenuItem.SHOW_AS_ACTION_IF_ROOM);
        }

    }
}
