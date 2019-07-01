package cn.edu.zzuli.config;

import cn.edu.zzuli.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //         添加拦截器                         配置路径
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
    }
}
