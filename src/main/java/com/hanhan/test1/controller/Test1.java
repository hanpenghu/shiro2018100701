package com.hanhan.test1.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanhan.test1.dao.mapperJava1.UserMapper;
import com.hanhan.test1.dto.User;
import com.hanhan.test1.hanhan.p;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hanhan on 2017-07-17.
 * @RestController无法return一个路径,但是: @Controller可以返回一个路径
 * 可以返回结果,证明没有get方法和set方法的时候实体也能够被jackson序列化
 * fastJson在field是public的时候同样也不需要实体的get和set方法
 */
@RestController
@RequestMapping("test1")
public class Test1 {
    @RequestMapping(value="f",method = RequestMethod.GET,produces = {"text/html;charset=UTF-8"})
    public ModelAndView  f(){
//        ModelAndView mv = new ModelAndView("/other/index1.html");//默认为forward模式//转发//但是作为静态资源会被拦截
//      ModelAndView mv = new ModelAndView("redirect:/other/index1.html");//redirect模式//重定向
//        ModelAndView mv = new ModelAndView("/other/index1.html");//该资源在controller内部不会被拦截
//        ModelAndView mv = new ModelAndView("/WEB-INF/a/aa.html");//WEB-INF下不能被直接访问,但是可以被controller内部forward
        ModelAndView mv = new ModelAndView("/jsp1.jsp");
        return mv;
    }


    @RequestMapping(value="s",method = RequestMethod.POST,produces = {"text/html;charset=UTF-8"})
    public ModelAndView  s(){
//        ModelAndView mv = new ModelAndView("/other/index1.html");//默认为forward模式//转发//但是作为静态资源会被拦截
//      ModelAndView mv = new ModelAndView("redirect:/other/index1.html");//redirect模式//重定向
//        ModelAndView mv = new ModelAndView("/other/index1.html");//该资源在controller内部不会被拦截
//        ModelAndView mv = new ModelAndView("/WEB-INF/a/aa.html");//WEB-INF下不能被直接访问,但是可以被controller内部forward
        ModelAndView mv = new ModelAndView("/jsps.jsp");
        return mv;
    }



    /**
     *
     * */
    @RequestMapping(value="f1",method = RequestMethod.GET)
    public @ResponseBody Object  test(){

        TestEntity testEntity=new TestEntity();
        testEntity.k="我曹";

        String s = JSON.toJSONString(testEntity);
        p.p("-------------------------------------------------------");
        p.p(s);
        p.p("-------------------------------------------------------");
        return testEntity;
    }


    //注意没有charset=utf-8会产生乱码
    @RequestMapping(value="f2",method = RequestMethod.POST,produces ={"text/plain;charset=utf-8"} )
    public @ResponseBody String  test2() throws JsonProcessingException {

        TestEntity testEntity=new TestEntity();
//        testEntity.k="我曹";

        //使用jackSon的包将null替换成""//因为 fastJson会将类里面是null的直接不显示
        String s1 = new ObjectMapper().writeValueAsString(testEntity);


        p.p("-------------------------------------------------------");
        p.p(s1);
        p.p("-------------------------------------------------------");
        return s1.replace("null","\"\"");
    }


}
