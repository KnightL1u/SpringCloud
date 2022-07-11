package com.lzw.springcloud.dao;//@date :2022/7/11 0:12


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface AccountDao {

 /**
  * 扣减账户余额
  */
 void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}

