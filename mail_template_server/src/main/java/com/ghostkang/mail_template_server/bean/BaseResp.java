package com.ghostkang.mail_template_server.bean;

/**
 * @Author: GhostKang
 * @Date: 2020/11/5 17:48
 * @Description:
 * @Version: 1.0
 */
public class BaseResp {
    private int code = 200;
    private String msg = "成功";
    private Object data = null;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
