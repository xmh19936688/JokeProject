package com.xmh.jokebuffet.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mengh on 2016/6/6 006.
 */
public class JokeResultBody implements Serializable{

    private int allNum;
    private int allPages;
    private int currentPage;
    private int maxResult;
    private List<JokeBean> contentlist;

    //region get & set
    public int getAllNum() {
        return allNum;
    }

    public void setAllNum(int allNum) {
        this.allNum = allNum;
    }

    public int getAllPages() {
        return allPages;
    }

    public void setAllPages(int allPages) {
        this.allPages = allPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getMaxResult() {
        return maxResult;
    }

    public void setMaxResult(int maxResult) {
        this.maxResult = maxResult;
    }

    public List<JokeBean> getContentlist() {
        return contentlist;
    }

    public void setContentlist(List<JokeBean> contentlist) {
        this.contentlist = contentlist;
    }
    //endregion
}
