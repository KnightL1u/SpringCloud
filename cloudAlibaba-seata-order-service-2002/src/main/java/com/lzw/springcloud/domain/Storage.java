package com.lzw.springcloud.domain;//@date :2022/7/11 0:03


import lombok.Data;

@Data
public class Storage {

    private Long id;

    // 产品id
    private Long productId;

    //总库存
    private Integer total;


    //已用库存
    private Integer used;


    //剩余库存
    private Integer residue;
}

