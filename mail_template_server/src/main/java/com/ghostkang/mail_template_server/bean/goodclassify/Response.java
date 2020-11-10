package com.ghostkang.mail_template_server.bean.goodclassify;

import java.util.List;

/**
 * @Author: GhostKang
 * @Date: 2020/11/6 17:31
 * @Description:
 * @Version: 1.0
 */
public class Response {
    private Integer id;
    private String name;
    private Integer pid;
    private Integer level;
    private String icon;

    private List<Response> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<Response> getChildren() {
        return children;
    }

    public void setChildren(List<Response> children) {
        this.children = children;
    }
}
