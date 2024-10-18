package org.example.springwork.config;

import org.example.springwork.pojo.IframeBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "org.example.springwork")
@EnableWebMvc
public class SpringJavaConfig {
    @Bean
    public IframeBean getIframeBean() {
        return new IframeBean();
    }
}
