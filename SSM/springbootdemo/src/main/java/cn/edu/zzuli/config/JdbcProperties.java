package cn.edu.zzuli.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

//@ConfigurationProperties注解该类作为配置属性类,会去找默认的appplication.properties文件，所以文件名一定要是这个
//注解2 因为在配置文件中，属性都是以“jdbc”开头的，所以使用prefix加个属性前缀
//@ConfigurationProperties(prefix = "jdbc")
//@Data注解是编译时生成set、get、toString等方法
@Data
public class JdbcProperties {

    String url;
    String driverClassName;
    String username;
    String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "JdbcProperties3{" +
                "url='" + url + '\'' +
                ", driverClassName='" + driverClassName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
