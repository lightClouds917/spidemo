package com.java4all.spi;

/**
 * description:
 * 语言处理器
 * @author IT云清
 * @date 2019/1/28 10:40
 */
public interface LanguageHandler {

  String getAddress(String address);

  String getLanguage();

  void setLanguage(String language);
}
