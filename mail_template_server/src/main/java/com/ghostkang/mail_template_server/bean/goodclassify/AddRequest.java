package com.ghostkang.mail_template_server.bean.goodclassify;

/**
 * @Author: GhostKang
 * @Date: 2020/11/9 13:48
 * @Description:
 * @Version: 1.0
 */
public class AddRequest {
    private String name;
    private Integer pid;
    private String icon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
