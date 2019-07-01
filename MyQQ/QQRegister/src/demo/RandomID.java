package demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class RandomID {
    private String id;
    private Random create;
    private Statement stmt;
    private Connection conn;
    private ResultSet rs = null;


    public RandomID(Statement stmt){
        this.stmt = stmt;
    }

    //生成随机id
    public String getId(){
        id = "1024";
        create = new Random();
        for (int i=0;i<2;i++){
            id = id+create.nextInt(9);
        }
        return id;
    }

    //验证id是否存在
    public boolean check(String sql){
        boolean check_id = false;
        try {
            stmt.executeQuery(sql);
        } catch (SQLException e) {
           check_id = true;
        }
        return check_id;
    }

    //验证id可用性
    public String checkId(){
        while (check("select * from user where id='"+getId()+"'"))
            break;
        return id;
    }


}
