package com.ohgiraffers.demoelasticbeanstalk.menu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "TBL_MENU")
@Entity(name = "Menu")
@Getter
@Setter
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MENU_CODE")
    private Integer menuCode;

    @Column(name = "MENU_NAME")
    private String menuName;

    @Column(name = "MENU_PRICE")
    private Integer price;

    @Column(name = "CATEGORY_CODE")
    private Integer categoryCode;

    @Column(name = "ORDERABLE_STATUS")
    private String orderableStatus;

    public Menu() {
    }

    public Menu(String menuName, int price, int categoryCode, String orderableStatus) {
        this.menuName = menuName;
        this.price = price;
        this.categoryCode = categoryCode;
        this.orderableStatus = orderableStatus;
    }
}
