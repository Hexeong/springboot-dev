package com.ohgiraffers.demoelasticbeanstalk.menu.repository;

import com.ohgiraffers.demoelasticbeanstalk.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
