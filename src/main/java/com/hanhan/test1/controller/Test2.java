package com.hanhan.test1.controller;

import com.hanhan.test1.dao.mapperJava1.UserMapper;
import com.hanhan.test1.dto.User;
import com.hanhan.test1.services.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 韩寒 on 2017-07-17.
 * @RestController无法return一个路径,但是: @Controller可以返回一个路径
 */
@Controller
@RequestMapping("/test2")
public class Test2 {
    @RequestMapping(value="/f",method = RequestMethod.GET,produces = {"text/html;charset=UTF-8"})
    public String f(){
        System.out.println("-------fuck------");
        return "/jsp1.jsp";
    }

    @RequestMapping(value="/f1",method = RequestMethod.POST,produces = {"text/html;charset=UTF-8"})
    public String f1(){
        System.out.println("-------fuck------");
        return "/jsp1.jsp";
    }

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public ModelAndView Login(String username, String password) {
        System.out.println("======username="+username+"====password="+password+"==============");
        ModelAndView mav = new ModelAndView();
        User user = userService.findUserByUserName(username);
        System.out.println("======user="+user+"=============");
        if (user == null) {
            mav.setViewName("/test2/f1");
            mav.addObject("msg", "用户不存在");
            return mav;
        }
        if (!user.getPassword().equals(password)) {
            mav.setViewName("/test2/f1");
            mav.addObject("msg", "帐号密码错误");
            return mav;
        }
        SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());
        // 登录后存放进shiro token
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        System.out.println("=======login成功后跳转=========");
        // 登录成功后会跳转到successUrl配置的链接，不用管下面返回的链接。
        mav.setViewName("/test1/s");
        return mav;
    }




}
