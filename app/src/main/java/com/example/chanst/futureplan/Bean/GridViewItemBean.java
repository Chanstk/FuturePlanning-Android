package com.example.chanst.futureplan.Bean;

import android.graphics.drawable.Drawable;

/**
 * Created by chanst on 16-3-15.
 */
public class GridViewItemBean {
    public String days, title, applications, award1, award2;
    public Drawable photo;

    public GridViewItemBean(Drawable photo, String days, String title,String applications, String award1, String award2) {
        this.days = days;
        this.title = title;
        this.applications = applications;
        this.award1 = award1;
        this.award2 = award2;
        this.photo = photo;
    }
}
