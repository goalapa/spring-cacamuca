package com.goalapa.cacamuca.foodDomain.query.domain.aggregate.dto;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CheckFoodDTO {

    private int foodNo;
    private String foodName;
    private double foodRate;
    private int foodPrice;
    private String country;
    private String foodType;
}
