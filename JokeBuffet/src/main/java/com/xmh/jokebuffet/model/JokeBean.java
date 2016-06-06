package com.xmh.jokebuffet.model;

import java.io.Serializable;

/**
 * Created by mengh on 2016/6/6 006.
 */
public class JokeBean implements Serializable{
    private String ct;
    private String text;
    private String title;
    private int type;

    //region get & set
    public String getCt() {
        return ct;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    //endregion
}
