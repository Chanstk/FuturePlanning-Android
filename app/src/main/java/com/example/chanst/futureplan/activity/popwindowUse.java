package com.example.chanst.futureplan.activity;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.chanst.futureplan.R;

public class popwindowUse extends AppCompatActivity implements View.OnClickListener {
    private TextView tag1,tag2,tag3;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);
        mContext = this;
        getIntent();
        initEvents();
    }

    private void initEvents() {
        tag1 = (TextView) findViewById(R.id.task_detail_tag1);
        tag1.setOnClickListener(this);
        tag2 = (TextView) findViewById(R.id.task_detail_tag2);
        tag2.setOnClickListener(this);
        tag3 = (TextView) findViewById(R.id.task_detail_tag3);
        tag3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.task_detail_tag1:
                showPopUpView(v);
                break;
            case R.id.task_detail_tag2:
                showPopUpView(v);
                break;
            case R.id.task_detail_tag3:
                showPopUpView(v);
                break;
        }
    }
    private void showPopUpView(View v) {
        // 一个自定义的布局，作为显示的内容
        View contentView = LayoutInflater.from(mContext).inflate(
                R.layout.pop_taskdetail_window, null);
        final PopupWindow popupWindow = new PopupWindow(contentView,
                AbsListView.LayoutParams.WRAP_CONTENT, AbsListView.LayoutParams.WRAP_CONTENT, true);

        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                    popupWindow.dismiss();
                    return true;
                }
                return false;
            }
        });
        popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);
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
}
