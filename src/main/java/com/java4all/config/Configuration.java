package com.java4all.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * description:
 * 获取配置文件内容
 * @author IT云清
 * @date 2019/2/2 22:22
 */
@Component
public class Configuration implements InitializingBean{

  @Value("${environment.language}")
  private String environmentLanguage;

  public static String ENVIRONMENT_LANGUAGE;

  @Override
  public void afterPropertiesSet() throws Exception {
    ENVIRONMENT_LANGUAGE = environmentLanguage;
  }
}
