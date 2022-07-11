package com.lzw.springcloud.service;//@date :2022/7/11 0:13


import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;


public interface AccountService {

 /**
  * 扣减账户余额
  */
 void decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}


