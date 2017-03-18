package com.wufan.repository;

import com.wufan.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Administrator on 2017/2/16.
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsernameAndPassword(@Param("mobilePhoneNumber") String mobilePhoneNumber, @Param("password") String password);
    User findByUsername(@Param("mobilePhoneNumber") String mobilePhoneNumber);
}
