package cn.edu.zzuli.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

//使用@Configuration将该类作为配置类,
@Configuration
//注解1 使用@PropertySource读取自己写的配置文件
//@PropertySource("classpath:jdbc.properties")
//注解2 使用@EnableConfigurationProperties调用加载配置文件的配置类，启用配置属性
//@EnableConfigurationProperties(JdbcProperties.class)
public class JdbcConfig {

/*****************java配置*************************************************/
//需要导入以下包，别忘了再pom.xml中引入
//import com.alibaba.druid.pool.DruidDataSource;

//    使用@Value注解属性值
//    @Value("${jdbc.url}")
//    String url;
//    @Value("${jdbc.driverClassName}")
//    String driverClassName;
//    @Value("${jdbc.username}")
//    String username;
//    @Value("${jdbc.password}")
//    String password;
//
//    //使用Bean注解在方法上，创建数据源
//    @Bean
//    public DataSource dataSource(){
//        DruidDataSource dataSource =  new DruidDataSource();
//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//
//        return dataSource;
//    }


/********************springboot注解 1 ***********************************************/

/*
    @Autowired
    JdbcProperties prop;
    public JdbcConfig(JdbcProperties prop) {
        this.prop = prop;
    }
    */

//使用Bean注解在方法上，创建数据源
//@Bean
//public DataSource dataSource(JdbcProperties prop){
//    DruidDataSource dataSource =  new DruidDataSource();
//    dataSource.setDriverClassName(prop.getDriverClassName());
//    dataSource.setUrl(prop.getUrl());
//    dataSource.setUsername(prop.getUsername());
//    dataSource.setPassword(prop.getPassword());
//
//    return dataSource;
//}


/*********************springboot注解 2 ***************************************/

    //使用Bean注解在方法上，创建数据源
//    @Bean
//    @ConfigurationProperties(prefix = "jdbc")
//    public DataSource dataSource(){
//        return new DruidDataSource();
//    }

}
