package com.ghostkang.mail_template_server.bean.good;

import java.util.Date;

/**
 * @Author: GhostKang
 * @Date: 2020/11/10 14:54
 * @Description:
 * @Version: 1.0
 */
public class ListRequest {
    private String name;
    private Integer status;
    private Date beginDate;
    private Date endDate;
    private Integer page;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
