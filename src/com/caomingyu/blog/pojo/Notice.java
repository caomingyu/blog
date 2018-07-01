package com.caomingyu.blog.pojo;

public class Notice {
    private Integer id;

    private Integer uid;

    private String context_;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getContext_() {
        return context_;
    }

    public void setContext_(String context_) {
        this.context_ = context_ == null ? null : context_.trim();
    }
}