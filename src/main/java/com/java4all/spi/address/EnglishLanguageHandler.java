package com.java4all.spi.address;

import com.java4all.spi.LanguageHandler;

/**
 * description:
 * 英语处理器
 * @author IT云清
 * @date 2019/1/28 10:41
 */
public class EnglishLanguageHandler implements LanguageHandler {

  private String language;

  @Override
  public String getAddress(String address) {
    return "I come from China";
  }

  @Override
  public String getLanguage() {
    return "english";
  }

  @Override
  public void setLanguage(String language) {
    this.language = language;
  }
}