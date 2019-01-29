package com.java4all.controller;

import com.java4all.spi.LanguageHandler;
import com.java4all.util.SpringBeanUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 *
 * @author IT云清
 * @date 2019/2/2 22:22
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
