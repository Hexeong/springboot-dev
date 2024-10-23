package com.ohgiraffers.demoelasticbeanstalk.menu.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MenuDto {
    private Integer menuCode;
    private String menuName;
    private Integer menuPrice;
    private Integer categoryCode;
    private String orderableStatus;
}
