package com.see.web.sso.startclass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * Start Class.
 *
 * Created by chris on 17-2-25.
 */
@ComponentScan("com.see.web.sso")
@EnableAutoConfiguration
public class Application {
  public static void main(String[] args) throws Exception {
    SpringApplication.run(Application.class, args);
  }
}
