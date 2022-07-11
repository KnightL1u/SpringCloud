package com.lzw.springcloud.service;//@date :2022/7/11 0:06



public interface StorageService {

 // 扣减库存
 void decrease(Long productId, Integer count);
}



