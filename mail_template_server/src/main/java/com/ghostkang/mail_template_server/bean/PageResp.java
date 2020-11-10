package com.ghostkang.mail_template_server.bean;

/**
 * @Author: GhostKang
 * @Date: 2020/11/10 14:57
 * @Description:
 * @Version: 1.0
 */
public class PageResp {
    private Integer total;//总条目数
    private Integer page;//当前页，从1开始

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
