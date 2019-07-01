package dao;

import domain.Article;
import domain.User;
import domain.Zhuanzai;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.C3P0Util;

import java.sql.SQLException;
import java.util.List;

public class NotepadDaoImpl implements NotepadDao {
    /**
     * 验证登录
     * @param name
     * @param pwd
     * @return 验证通过返回用户信息
     * @throws SQLException
     */
    @Override
    public User login(String name, String pwd) {
        try {
            QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
            return qr.query("select * from user where username=? and password=?",new BeanHandler<User>(User.class), name, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据用户id查询用户信息
     * @param userid
     * @return 用户信息
     * @throws SQLException
     */
    @Override
    public User findUserById(int userid) throws SQLException {
        try {
            QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
            return qr.query("select * from user where id=?",new BeanHandler<User>(User.class), userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 注册时添加新用户
     * @param user
     * @throws SQLException
     */
    @Override
    public void insterUser(User user){
        try {
            QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
            qr.update("insert into user values(null,?,?,?,?,?,?)",user.getUsername(),user.getPassword(),user.getSex(),user.getAge(),user.getTime(),user.getTouxiang());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新用户信息
     * @param user 需要更新的用户数据
     * @throws SQLException
     */
    @Override
    public void update(User user) throws SQLException {
        try {
            QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
            qr.update("update user set username=?,password=?,sex=?,age=? where id=?",user.getUsername(),user.getPassword(),user.getSex(),user.getAge(),user.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新用户头像
     * @param userid
     * @param touxiang
     * @throws SQLException
     */
    @Override
    public void changeTouxiang(int userid, String touxiang) throws SQLException {
        try {
            QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
            qr.update("update user set touxiang=? where id=?",touxiang,userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将文章写入到数据库
     * @param article
     * @throws SQLException
     */
    @Override
    public void writeArticle(Article article) throws SQLException {
        try {
            QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
            qr.update("insert into article values(null,?,?,?,?,?)",article.getArticle_name(),article.getContent(),article.getUser_id(),article.getArticle_time(),article.getLable());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 根据用户id查询文章数量
     * @param user_id
     * @param tableName
     * @return 文章数量
     * @throws SQLException
     */
    @Override
    public int findArticleCount(int user_id,String tableName) {
        try {
            QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
            Long result = (Long)qr.query("select count(*) from "+tableName+" where user_id=?",new ScalarHandler(),user_id);
            return result.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 查询所有文章并按时间排序
     * @return 文章列表List
     * @throws SQLException
     */
    @Override
    public List<Article> findAllArticle() throws SQLException {
        try {
            QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
            //desc是降序,asc升序
            return qr.query("select * from article order by article_time desc", new BeanListHandler<Article>(Article.class));
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 按文章id查询
     * @param article_id
     * @return 文章列表List
     * @throws SQLException
     */
    @Override
    public Article findArticleById(int article_id) throws SQLException {
        try {
            QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
            return qr.query("select * from article where article_id = ?", new BeanHandler<Article>(Article.class),article_id);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 按用户id查询
     * @param user_id
     * @return 文章列表List
     * @throws SQLException
     */
    @Override
    public List<Article> findArticleByUserId(int user_id) throws SQLException {
        try {
            QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
            return qr.query("select * from article where user_id = ? order by article_time desc", new BeanListHandler<Article>(Article.class),user_id);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据作者id查出相应标签的文章，由于用户分类管理
     * @param user_id
     * @param lable
     * @return 文章列表List
     * @throws SQLException
     */
    @Override
    public List<Article> UserLableArticle(int user_id, String lable) throws SQLException {
        try {
            QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
            return qr.query("select * from article where user_id = ? and lable = ? order by article_time desc", new BeanListHandler<Article>(Article.class),user_id,lable);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 按文章名称查询
     * @param article_name
     * @return 文章列表List
     * @throws SQLException
     */
    @Override
    public Article findArticleByName(String article_name) throws SQLException {
        try {
            QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
            return qr.query("select * from article where article_name = ?", new BeanHandler<Article>(Article.class),article_name);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 在主页根据输入的关键字查询文章，模糊查询
     * @param str
     * @return
     * @throws SQLException
     */
    @Override
    public List<Article> findArticleLikeName(String str) throws SQLException{
        try {
            QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
            return qr.query("select * from article where article_name like ? ", new BeanListHandler<Article>(Article.class),"%"+str+"%");
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 按文章标签查询
     * @param lable
     * @return 文章列表List
     * @throws SQLException
     */
    @Override
    public List<Article> findArticleByLable(String lable) throws SQLException {
        try {
            QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
            return qr.query("select * from article where lable = ?", new BeanListHandler<Article>(Article.class),lable);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据文章id删除文章
     * @param article_id
     * @throws SQLException
     */
    @Override
    public void deleteArticleById(int article_id) throws SQLException {
        try {
            QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
            qr.update("delete from article where article_id=?",article_id);
            //当作者删除其文章时，其他用户的转载记录也将被删除
            deleteZhuanzaiById(article_id);
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 根据文章id删除转载过该文章的转载记录
     * @param article_id
     * @throws SQLException
     */
    @Override
    public void deleteZhuanzaiById(int article_id) throws SQLException {
        try {
            QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
            qr.update("delete from zhuanzai where article_id=?",article_id);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 用户转载文章
     * @param article_id
     * @param user_id
     * @return
     * @throws SQLException
     */
    @Override
    public void ZhuanZai(int user_id, int article_id ) throws SQLException {
        try {
            QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
            qr.update("insert into zhuanzai values(?,?)",user_id,article_id);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除用户转载的文章
     * @param user_id
     * @param article_id
     * @throws SQLException
     */
    @Override
    public void deleteZhuanzai(int user_id, int article_id) throws SQLException {
        try {
            QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
            qr.update("delete from zhuanzai where user_id=? and article_id=?",user_id,article_id);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询出用户所有转载过的文章
     * @param user_id
     * @return
     * @throws SQLException
     */
    @Override
    public List<Zhuanzai> ZhuanZaiArticle(int user_id) throws SQLException {
        try {
            QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
            return qr.query("select * from zhuanzai where user_id = ?", new BeanListHandler<Zhuanzai>(Zhuanzai.class),user_id);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 用户收藏文章
     * @param article_id
     * @param user_id
     * @return
     * @throws SQLException
     */
    @Override
    public void ShouCangArticle(int user_id, int article_id ) throws SQLException {
        try {
            QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
            qr.update("insert into shoucang values(?,?)",user_id,article_id);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
