package com.xmh.jokebuffet.model;

import java.io.Serializable;

/**
 * Created by mengh on 2016/6/6 006.
 */
public class JokeResult implements Serializable{

    private int showapi_res_code;
    private String showapi_res_error;
    private JokeResultBody showapi_res_body;

    //region get & set
    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public JokeResultBody getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(JokeResultBody showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }
    //endregion
}
