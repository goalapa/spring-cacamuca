package com.goalapa.cacamuca.foodDomain.query.application.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class QueryFoodDTO {

    private int foodNo;
    private String foodName;
    private double foodRate;
    private int foodPrice;
    private String country;
    private String foodType;
}
