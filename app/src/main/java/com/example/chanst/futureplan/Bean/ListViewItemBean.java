package com.example.chanst.futureplan.Bean;

import android.graphics.drawable.Drawable;

/**
 * Created by chanst on 16-3-15.
 */
public class ListViewItemBean {
    public String name, postion, tag1, tag2, number,content;
    public Drawable photo,poster;

    public ListViewItemBean(String content,Drawable poster, String number,Drawable photo, String name, String postion, String tag2, String tag1) {
        this.tag2 = tag2;
        this.name = name;
        this.postion = postion;
        this.tag1 = tag1;
        this.photo = photo;
        this.number = number;
        this.poster = poster;
        this.content = content;
    }
}
