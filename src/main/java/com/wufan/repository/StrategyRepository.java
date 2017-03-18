package com.wufan.repository;

import com.wufan.bean.Strategy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/3/18.
 */
public interface StrategyRepository extends JpaRepository<Strategy,Integer> {
    @Override
    List<Strategy> findAll();
}
