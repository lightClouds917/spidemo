package com.java4all.spi.language;

import com.java4all.spi.LanguageHandler;

/**
 * description:
 * 韩语处理器
 * @author IT云清
 * @date 2019/2/2 22:22
 */
public class KoreanLanguageHandler implements LanguageHandler {

  private String language;

  @Override
  public String getAddress(String address) {
    return "저는 중국에서 왔습니다.";
  }

  @Override
  public String getLanguage() {
    return "korean";
  }

  @Override
  public void setLanguage(String language) {
    this.language = language;
  }
}
