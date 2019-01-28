package com.java4all.controller;

import com.java4all.spi.LanguageHandler;
import com.java4all.util.SpringBeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 *
 * @author IT云清
 * @date 2019/1/28 10:40
 */
@RestController
public class UserController {

  private LanguageHandler languageHandler;

  @GetMapping("hello")
  public String hello(String arg){
    languageHandler = SpringBeanUtils.getInstance().getBean(LanguageHandler.class);
    String address = languageHandler.getAddress(arg);
    return address;
  }

}
