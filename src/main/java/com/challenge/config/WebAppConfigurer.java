package com.challenge.config;

import com.challenge.common.HeaderCons;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {

    /**
     * 实现跨域配置
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")//这里填写你允许进行跨域的主机ip
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")//允许的访问方法
                .allowedHeaders(HeaderCons.ACCESS_TOKEN, HeaderCons.MOBILE,"content-type")//允许Header的参数
                .maxAge(3600);//Access-Control-Max-Age 用于 CORS 相关配置的缓存
    }

}
