package com.example.chanst.futureplan.Fragments;

import android.content.Context;
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
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.example.chanst.futureplan.Bean.ListViewItemBean;
import com.example.chanst.futureplan.R;
import com.example.chanst.futureplan.activity.ConsultActivity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chanst on 16-3-15.
 */
public class frag_main extends Fragment {
    private ScrollView scrollView;
    private View view;
    private ListView listView;
    private List<ListViewItemBean> dataList ;
    private listAdapter adapter;
    private ConvenientBanner convenientBanner;
    private ArrayList<Integer> localImages = new ArrayList<Integer>();
    Drawable photo;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_main, container, false);
        initEnvents();
        return view;
    }

    private void initEnvents() {
        View header = getActivity().getLayoutInflater().inflate(R.layout.frag_main_header, null);
        convenientBanner = (ConvenientBanner) header.findViewById(R.id.convenientBanner);
        loadImageDatas();
        convenientBanner.setPages(
                new CBViewHolderCreator<LocalImageHolderView>() {
                    @Override
                    public LocalImageHolderView createHolder() {
                        return new LocalImageHolderView();
                    }
                }, localImages);

        listView = (ListView) view.findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), ConsultActivity.class);
                startActivity(intent);
            }
        });
        photo = getResources().getDrawable(R.drawable.course);
        dataList = new ArrayList<ListViewItemBean>();
        dataList.add(new ListViewItemBean(photo,"Shabby", "CTO", "百度", "机器学习"));
        dataList.add(new ListViewItemBean(photo,"Nina", "产品经理", "UBER", "互联网"));
        dataList.add(new ListViewItemBean(photo,"Raja", "程序员", "小米", "互联网"));
        adapter = new listAdapter(dataList);
        listView.setAdapter(adapter);
        listView.addHeaderView(header);
    }

    private void loadImageDatas() {
        //本地图片集合
        for (int position = 0; position < 3; position++)
            localImages.add(getResId("ic_test_" + position, R.drawable.class));
    }

    /**
     * 通过文件名获取资源id 例子：getResId("icon", R.drawable.class);
     *
     * @param variableName
     * @param c
     * @return
     */
    public static int getResId(String variableName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(variableName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        //开始自动翻页
        convenientBanner.startTurning(5000);
    }

    // 停止自动翻页
    @Override
    public void onPause() {
        super.onPause();
        //停止翻页
        convenientBanner.stopTurning();
    }
    protected class listAdapter extends BaseAdapter {
        private List<ListViewItemBean> list;
        public listAdapter(List<ListViewItemBean> list) {
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
                view = getActivity().getLayoutInflater().inflate(R.layout.listview_item, null);
                holder = new ViewHolder();
                holder.name = (TextView) view.findViewById(R.id.item_name);
                holder.position = (TextView) view.findViewById(R.id.item_position);
                holder.tag1 = (TextView) view.findViewById(R.id.item_tag1);
                holder.tag2 = (TextView) view.findViewById(R.id.item_tag2);
                holder.photo = (ImageView) view.findViewById(R.id.item_poster);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            ListViewItemBean bean = list.get(position);
            if (bean != null) {
                holder.name.setText(bean.name);
                holder.position.setText(bean.postion);
                holder.tag1.setText(bean.tag1);
                holder.tag2.setText(bean.tag2);
                holder.photo.setImageDrawable(bean.photo);
            }
            return view;
        }
    }

    static class ViewHolder {
        TextView name, position, tag1, tag2;
        ImageView photo;
    }
    public class LocalImageHolderView implements Holder<Integer> {
        private ImageView imageView;
        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, final int position, Integer data) {
            imageView.setImageResource(data);
        }
    }
    /**
     * 动态设置ListView的高度
     * @param listView
     */
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        if(listView == null) return;
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

}
