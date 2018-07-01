package com.caomingyu.blog.pojo;

import java.util.Date;
import java.util.List;

public class Review {
    private Integer id;

    private Integer uid;

    private Integer article_id;

    private Date createdate;

    private String context_;
    private List<Reply> replies;

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

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

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
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