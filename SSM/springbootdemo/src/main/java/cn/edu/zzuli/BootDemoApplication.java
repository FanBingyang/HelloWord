package cn.edu.zzuli;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//使用@MapperScan扫描mapper接口
@MapperScan("cn.edu.zzuli.mapper")
public class BootDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootDemoApplication.class,args);
    }
}
