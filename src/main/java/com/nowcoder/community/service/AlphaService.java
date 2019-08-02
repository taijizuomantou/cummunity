package com.nowcoder.community.service;

import com.nowcoder.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
//@Scope("prototype")//默认single
public class AlphaService {
    @Autowired
    private AlphaDao alphaDao;
    public AlphaService(){
        System.out.println("Construct");
    }
    @PostConstruct//在构造器后调用
    public void init(){
        System.out.println("init");
    }
    @PreDestroy//在销毁对象之前调用
    public void destory(){
        System.out.println("destory");
    }
    public String find(){
        return alphaDao.select();
    }
}
