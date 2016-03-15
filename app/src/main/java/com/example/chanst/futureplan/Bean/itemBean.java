package com.example.chanst.futureplan.Bean;

/**
 * Created by chanst on 16-3-15.
 */
public class itemBean {
    public String name, postion, tag1, tag2;

    public itemBean( String name, String postion, String tag2,String tag1) {
        this.tag2 = tag2;
        this.name = name;
        this.postion = postion;
        this.tag1 = tag1;
    }
}
