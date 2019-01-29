package com.java4all;

import com.java4all.config.Configuration;
import com.java4all.spi.LanguageHandler;
import com.java4all.spi.language.ChineseLanguageHandler;
import com.java4all.util.SpringBeanUtils;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.stream.StreamSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * description:
 * 在项目启动时，加载语言处理器，放入容器中
 * 在启动类的run方法执行完后执行
 * order越小，越先执行
 *
 * CommandLineRunner:程序启动后，可以做一些自定义处理
 * ApplicationContextAware：spring容器初始化时，会调用setApplicationContext，注入上下文
 *
 * @author IT云清
 * @date 2019/2/2 22:22
 */
@Component
@Order(1)
public class ApplicationStartup implements CommandLineRunner,ApplicationContextAware {

  private final Logger LOGGER = LoggerFactory.getLogger(ApplicationStartup.class);
  
  /**加载语言处理器服务*/
  @Override
  public void run(String... strings) throws Exception {
    //spi，获取语言处理器服务列表
    ServiceLoader<LanguageHandler> languageHandlers = ServiceLoader.load(LanguageHandler.class);
    String environmentLanguage = Configuration.ENVIRONMENT_LANGUAGE;

    //根据配置文件，筛选出配置的语言处理器
    final LanguageHandler languageHandler2 = StreamSupport
        .stream(languageHandlers.spliterator(), false)
        .filter(handler -> Objects.equals(handler.getLanguage(), environmentLanguage))
        .findFirst().orElse(new ChineseLanguageHandler());

    languageHandler2.setLanguage(environmentLanguage);

    //语言处理器注册到容器中
    SpringBeanUtils.getInstance().registerBean(LanguageHandler.class.getName(),languageHandler2);
    LanguageHandler bean = SpringBeanUtils.getInstance().getBean(LanguageHandler.class);
    LOGGER.info("已注册语言处理器："+bean.getClass().getSimpleName()+"到容器中......");
  }

  /**设置上下文*/
  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    SpringBeanUtils.getInstance().setCfgContext((ConfigurableApplicationContext)applicationContext);
    LOGGER.info("设置上下文......");

  }
}
