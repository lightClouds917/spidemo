package com.java4all.spi.language;

import com.java4all.spi.LanguageHandler;

/**
 * description:
 * 汉语处理器
 * @author IT云清
 * @date 2019/2/2 22:22
 */
public class ChineseLanguageHandler implements LanguageHandler {

  private String language;

  @Override
  public String getAddress(String address) {
    return "我来自中国";
  }

  @Override
  public String getLanguage() {
    return "chinese";
  }

  @Override
  public void setLanguage(String language) {
    this.language = language;
  }
}
