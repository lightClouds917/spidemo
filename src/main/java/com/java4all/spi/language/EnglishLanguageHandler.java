package com.java4all.spi.language;

import com.java4all.spi.LanguageHandler;

/**
 * description:
 * 英语处理器
 * @author IT云清
 * @date 2019/2/2 22:22
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
