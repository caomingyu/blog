package com.caomingyu.blog.service;

import com.caomingyu.blog.pojo.Reply;

import java.util.List;

public interface ReplyService {
    void add(Reply reply);

    void delete(int id);

    void update(Reply reply);

    List<Reply> list(int rid);

    Reply get(int id);
}
