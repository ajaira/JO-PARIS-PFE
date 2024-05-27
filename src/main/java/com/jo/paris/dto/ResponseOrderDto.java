package com.jo.paris.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseOrderDto {

    private float amount;

    private Date date;

    private String OrderDescription;

    private Long orderId;

}
