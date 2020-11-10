package com.ghostkang.mail_template_server.bean.login;

/**
 * @Author: GhostKang
 * @Date: 2020/11/6 13:43
 * @Description:
 * @Version: 1.0
 */
public class Request {
    private String username;
    private String password;
    private int type;//1-账密，2-短信

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
