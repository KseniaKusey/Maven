package com.example.spring.demo.configs;

import com.example.spring.demo.model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;


@Configuration
@ComponentScan("com.example.spring.demo")
@EnableWebMvc
public class Config implements WebMvcConfigurer {
    private final ApplicationContext applicationContext;

    @Autowired
    public Config(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public FilterRegistrationBean hiddenHttpMethodFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new HiddenHttpMethodFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        return filterRegistrationBean;
    }


    @Bean("First Cat")
    public Cat firstCat() {
        return new Cat("First Cat", "Maine Coon", "very big", "1010-1111-2200", 76);
    }

    @Bean("Second Cat")
    public Cat secondCat() {
        return new Cat("Second Cat", "Bobtail", "no tail", "2010-55522-3300", 30);
    }


    @Bean("Third Cat")
    public Cat thirdCat() {
        return new Cat("Third Cat", "British", "small ears","5010-23454-5500", 40);
    }


}