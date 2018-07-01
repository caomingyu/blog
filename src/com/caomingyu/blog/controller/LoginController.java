package com.caomingyu.blog.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.apache.shiro.subject.Subject;

@Controller
@RequestMapping("")
public class LoginController {

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(Model model, String name, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        try {
            subject.login(token);
            Session session = subject.getSession();
            session.setAttribute("subject",subject);
            return "index";
        }catch (AuthenticationException e){
            String s = "验证失败!用户不存在或密码错误";
            model.addAttribute("message", s);
            return "login";
        }
    }
}
