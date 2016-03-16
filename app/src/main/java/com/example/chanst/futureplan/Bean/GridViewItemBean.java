package com.example.chanst.futureplan.Bean;

import android.graphics.drawable.Drawable;

/**
 * Created by chanst on 16-3-15.
 */
public class GridViewItemBean {
    public String days, title, company, top, sec;
    public Drawable photo;

    public GridViewItemBean(Drawable photo, String days, String title, String company, String top, String sec) {
        this.days = days;
        this.title = title;
        this.company = company;
        this.top = top;
        this.sec = sec;
        this.photo = photo;
    }
}
