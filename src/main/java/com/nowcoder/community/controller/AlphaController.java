package com.nowcoder.community.controller;

import com.nowcoder.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/alpha")
public class AlphaController {
    @Autowired
    private AlphaService alphaService;
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "Hello xue xue Spring Boot.";
    }
    @RequestMapping("/data")
    @ResponseBody
    public String getData(){
        return alphaService.find();
    }
    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response){
        //获取请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String>enumeration = request.getHeaderNames();
        while(enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + ": "+value);
        }
        System.out.println(request.getParameter("code"));//?code=123

        //返回相应数据
        response.setContentType("text/html;charset=utf-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.write("<h1>牛客网<h1>");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    //两种传参方式1问号2是路径
    //GET请求,默认发送的请求
    //查询所有学生的 students?current=1&limit=20 当前第几页，最多一页多少数据
    @RequestMapping(path="/students",method= RequestMethod.GET)
    @ResponseBody
    public String get_students(//以name为准
            @RequestParam(name="current",required=false,defaultValue="1")int current,
            @RequestParam(name = "limit",required = false,defaultValue = "10")int limit) {
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }
    //根据学生的编号查询一个学生
    //student/123
    @RequestMapping(path="student/{id}",method=RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id")int id){
        return "a student"+id;
    }

    //POST请求
    //Get请求传参在明面上传，并且数据量有限长度有限
    @RequestMapping(path="/student",method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name,String age){//名称和html中的明对对应即可
        System.out.println(name);
        System.out.println(age);
        return "success";
    }
    //响应html数据
    @RequestMapping(path="/teacher",method=RequestMethod.GET)
    public ModelAndView getTeacher(){//返回的是model和view
        ModelAndView mav = new ModelAndView();
        mav.addObject("name","张三");
        mav.addObject("age",30);
        mav.setViewName("/demo/view");
        return mav;

    }
    @RequestMapping(path="/school",method=RequestMethod.GET)
    public String getSchool(Model model){//自动实例化model对象
        model.addAttribute("name","被关进大学");
        model.addAttribute("age",80);
        return "/demo/view";//返回view的路径
    }
    //响应json数据（一般在异步请求中 比如判断昵称是否重名
    //Java对象 jS对象 JSON实现两者兼容
    //JAVA->JSON->JS
    @RequestMapping(path = "/emp", method = RequestMethod.GET)
    @ResponseBody //不加认为返回值是html
    public Map<String,Object> getEmp(){
        Map<String,Object>emp = new HashMap<>();
        emp.put("name","张三");
        emp.put("age",23);
        emp.put("salary",8000.0);
        return emp;
    }
    @RequestMapping(path = "/emps", method = RequestMethod.GET)
    @ResponseBody //不加认为返回值是html
    public List<Map<String,Object>> getEmps(){
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object>emp = new HashMap<>();
        emp.put("name","张三");
        emp.put("age",23);
        emp.put("salary",8000.0);
        list.add(emp);
        emp.put("name","李四");
        emp.put("age",24);
        emp.put("salary",9000.0);
        list.add(emp);
        emp.put("name","王五");
        emp.put("age",25);
        emp.put("salary",10000.0);
        list.add(emp);
        return list;
    }


}
