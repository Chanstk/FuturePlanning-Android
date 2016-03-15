package com.example.chanst.futureplan.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.chanst.futureplan.DIYWidge.changeColorIconWithText;
import com.example.chanst.futureplan.DIYWidge.fragmentPagerAdapter;
import com.example.chanst.futureplan.R;
import com.example.chanst.futureplan.Fragments.frag_chanllenge;
import com.example.chanst.futureplan.Fragments.frag_intro;
import com.example.chanst.futureplan.Fragments.frag_main;
import com.example.chanst.futureplan.Fragments.frag_me;
import com.example.chanst.futureplan.Fragments.frag_show;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private ViewPager viewPager;
    private List<Fragment> fragList = new ArrayList<Fragment>();
    private List<String> titleList = new ArrayList<String>();
    private FragmentPagerAdapter adapter;
    private frag_main fragMain;
    private frag_chanllenge fragChanllenge;
    private frag_show fragShow;
    private frag_intro fragIntro;
    private frag_me fragMe;
    private List<changeColorIconWithText> tabIndicators = new ArrayList<changeColorIconWithText>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initEnvents();
    }

    private void initEnvents() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        fragMain = new frag_main();
        fragChanllenge = new frag_chanllenge();
        fragShow = new frag_show();
        fragIntro = new frag_intro();
        fragMe = new frag_me();
        fragList.add(fragMain);
        fragList.add(fragChanllenge);
        fragList.add(fragShow);
        fragList.add(fragIntro);
        fragList.add(fragMe);

        titleList.add("1");
        titleList.add("2");
        titleList.add("3");
        titleList.add("4");
        titleList.add("5");

        adapter = new fragmentPagerAdapter(getSupportFragmentManager(), fragList, titleList);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(this);
        changeColorIconWithText one = (changeColorIconWithText) findViewById(R.id.bot_main);
        one.setOnClickListener(this);
        tabIndicators.add(one);
        changeColorIconWithText two = (changeColorIconWithText) findViewById(R.id.bot_chanllenge);
        two.setOnClickListener(this);
        tabIndicators.add(two);
        changeColorIconWithText three = (changeColorIconWithText) findViewById(R.id.bot_show);
        three.setOnClickListener(this);
        tabIndicators.add(three);
        changeColorIconWithText four = (changeColorIconWithText) findViewById(R.id.bot_intro);
        four.setOnClickListener(this);
        tabIndicators.add(four);
        changeColorIconWithText five = (changeColorIconWithText) findViewById(R.id.bot_me);
        five.setOnClickListener(this);
        tabIndicators.add(five);
        one.setIconAlpha(1.0f);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if(positionOffset>0){
            tabIndicators.get(position).setIconAlpha(1-positionOffset);
            tabIndicators.get(position+1).setIconAlpha(positionOffset);
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        resetOtherTabs();
        switch(v.getId()){
            case R.id.bot_main:
                tabIndicators.get(0).setIconAlpha(1.0f);
                viewPager.setCurrentItem(0,false);
                break;
            case R.id.bot_chanllenge:
                tabIndicators.get(1).setIconAlpha(1.0f);
                viewPager.setCurrentItem(1,false);
                break;
            case R.id.bot_show:
                tabIndicators.get(2).setIconAlpha(1.0f);
                viewPager.setCurrentItem(2,false);
                break;
            case R.id.bot_intro:
                tabIndicators.get(3).setIconAlpha(1.0f);
                viewPager.setCurrentItem(3,false);
                break;
            case R.id.bot_me:
                tabIndicators.get(4).setIconAlpha(1.0f);
                viewPager.setCurrentItem(4,false);
                break;
        }
    }
    private void resetOtherTabs() {
        // TODO Auto-generated method stub
        for(int i =0 ; i <tabIndicators.size();i++){
            tabIndicators.get(i).setIconAlpha(0);
        }
    }
}
