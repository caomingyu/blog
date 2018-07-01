package com.caomingyu.blog.pojo;

import java.util.Date;

public class Reply {
    private Integer id;

    private Integer review_id;

    private Integer uid;

    private Date createdate;

    private String context_;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReview_id() {
        return review_id;
    }

    public void setReview_id(Integer review_id) {
        this.review_id = review_id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getContext_() {
        return context_;
    }

    public void setContext_(String context_) {
        this.context_ = context_ == null ? null : context_.trim();
    }
}