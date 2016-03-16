package com.example.chanst.futureplan.Fragments;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chanst.futureplan.Bean.GridViewItemBean;
import com.example.chanst.futureplan.R;
import com.example.chanst.futureplan.activity.TaskDetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chanst on 16-3-15.
 */
public class frag_task extends Fragment {
    private View view;
    private GridView gridView;
    private Drawable photo;
    private List<GridViewItemBean> dataList;
    private listAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_task, container, false);
        initEvents();
        return view;
    }

    private void initEvents() {
        gridView = (GridView) view.findViewById(R.id.gridview);
        photo = getResources().getDrawable(R.drawable.course);
        GridViewItemBean bean = new GridViewItemBean(photo,"23","如何在城市中使用你的虚拟汽车钥匙","大众集团","150RMB","500RMB");
        dataList = new ArrayList<GridViewItemBean>();
        dataList.add(bean);
        dataList.add(bean);
        dataList.add(bean);
        dataList.add(bean);
        dataList.add(bean);
        dataList.add(bean);
        dataList.add(bean);
        adapter = new listAdapter(dataList);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), TaskDetailActivity.class);
                startActivity(intent);
            }
        });
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
                holder.days = (TextView) view.findViewById(R.id.gridview_item_days);
                holder.company = (TextView) view.findViewById(R.id.gridview_item_company);
                holder.sec = (TextView) view.findViewById(R.id.gridview_item_sec);
                holder.top = (TextView) view.findViewById(R.id.gridview_item_top);
                holder.photo = (ImageView) view.findViewById(R.id.gridview_item_photo);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            GridViewItemBean bean = list.get(position);
            if (bean != null) {
                holder.title.setText(bean.title);
                holder.days.setText(bean.days);
                holder.company.setText(bean.company);
                holder.sec.setText(bean.sec);
                holder.top.setText(bean.top);
                holder.photo.setImageDrawable(bean.photo);
            }
            return view;
        }
    }
    static class ViewHolder {
        TextView title, company, days, sec, top;
        ImageView photo;
    }
}
