package com.wufan.controller;

import com.wufan.bean.Site;
import com.wufan.bean.Strategy;
import com.wufan.repository.SiteRepository;
import com.wufan.repository.StrategyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2017/3/18.
 */
@RestController
public class StrategyManage {
    @Autowired
    private StrategyRepository repository;

    @RequestMapping(value = "/strategy", method = RequestMethod.GET)
    public List<Strategy> site() {

       return repository.findAll();
       /* User userInfo = repository.findByUsernameAndPassword(mobilePhoneNumber,password);
        if (userInfo != null) {
            return Constant.SUCCESS;
        }
        return Constant.FAIL;*/
    }
}
