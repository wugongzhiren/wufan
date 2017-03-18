package com.wufan.repository;

import com.wufan.bean.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Administrator on 2017/3/18.
 */
public interface SiteRepository extends JpaRepository<Site,Integer> {
    @Override
    List<Site> findAll();
    /* @Query(value = "from User u where u.name=:name",nativeQuery = true)
    Site findUser();*/
}
