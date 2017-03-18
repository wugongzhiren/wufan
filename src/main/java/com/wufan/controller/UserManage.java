package com.wufan.controller;

import com.wufan.Constant;
import com.wufan.bean.User;
import com.wufan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户首次登录验证
 * Created by Administrator on 2017/2/15.
 */
@RestController
public class UserManage {
    @Autowired
    private UserRepository repository;

    /**
     * 用户登录
     * @param mobilePhoneNumber 手机号码
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam("mobilePhoneNumber") String mobilePhoneNumber, @RequestParam("password") String password) {

       User userInfo = repository.findByUsernameAndPassword(mobilePhoneNumber,password);
        if (userInfo != null) {
            return Constant.SUCCESS;
        }
        return Constant.FAIL;
    }

    /**
     * 用户注册
     * @param mobilePhoneNumber
     * @param password
     * @return
     */
    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String reg(@RequestParam("mobilePhoneNumber") String mobilePhoneNumber, @RequestParam("password") String password) {
        if(checkUserExist(mobilePhoneNumber)){
            return Constant.USEREXIST;
        }
        User userInfo = new User();
        userInfo.setUsername(mobilePhoneNumber);
        userInfo.setPassword(password);
        repository.save(userInfo);
        return Constant.SUCCESS;
    }

    /**
     * 检查用户是否已经注册
     * @param phone
     * @return
     */
    private Boolean checkUserExist(String phone){
        User userInfo =repository.findByUsername(phone);
        if(userInfo!=null){
            //数据库已经存在
            return true;
        }
        return false;
    }
}
