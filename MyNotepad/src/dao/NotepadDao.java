package dao;

import domain.Article;
import domain.User;
import domain.Zhuanzai;

import java.sql.SQLException;
import java.util.AbstractQueue;
import java.util.List;

public interface NotepadDao {

    /**
     * 验证登录
     * @param name
     * @param pwd
     * @return 验证通过返回用户信息
     * @throws SQLException
     */
    User login(String name,String pwd) throws SQLException;

    /**
     * 根据用户id查询用户信息
     * @param userid
     * @return 用户信息
     * @throws SQLException
     */
    User findUserById(int userid) throws SQLException;

    /**
     * 注册时添加新用户
     * @param user
     * @throws SQLException
     */
    void insterUser(User user) throws SQLException;

    /**
     * 更新用户信息
     * @param user 需要更新的用户数据
     * @throws SQLException
     */
    void update(User user) throws SQLException;

    /**
     * 更新用户头像
     * @param userid
     * @param touxiang
     * @throws SQLException
     */
    void changeTouxiang(int userid,String touxiang) throws SQLException;

    /**
     * 将文章写入到数据库
     * @param article
     * @throws SQLException
     */
    void writeArticle(Article article) throws SQLException;

    /**
     * 根据作者id查询文章数量
     * @param user_id
     * @return 文章数量
     * @throws SQLException
     */
    int findArticleCount(int user_id,String tableName) throws SQLException;

    /**
     * 查询所有文章并按时间排序
     * @return 文章列表List
     * @throws SQLException
     */
    List<Article> findAllArticle() throws SQLException;

    /**
     * 按文章id查询
     * @param article_id
     * @return 文章数据
     * @throws SQLException
     */
    Article findArticleById(int article_id) throws SQLException;

    /**
     * 按作者id查询
     * @param user_id
     * @return 文章列表List
     * @throws SQLException
     */
    List<Article> findArticleByUserId(int user_id) throws SQLException;

    /**
     * 根据作者id查出相应标签的文章，由于用户分类管理
     * @param user_id
     * @param lable
     * @return 文章列表List
     * @throws SQLException
     */
    List<Article> UserLableArticle(int user_id,String lable) throws SQLException;

    /**
     * 按文章名称查询
     * @param article_name
     * @return 文章列表List
     * @throws SQLException
     */
    Article findArticleByName(String article_name) throws SQLException;

    /**
     * 在主页根据输入的关键字查询文章，模糊查询
     * @param str
     * @return
     * @throws SQLException
     */
    List<Article> findArticleLikeName(String str) throws SQLException;

    /**
     * 按文章标签查询
     * @param lable
     * @return 文章列表List
     * @throws SQLException
     */
    List<Article> findArticleByLable(String lable) throws SQLException;

    /**
     * 根据文章id删除文章
     * @param article_id
     * @throws SQLException
     */
    void deleteArticleById(int article_id) throws SQLException;

    /**
     * 当作者删除其文章时，其他用户的转载记录也将被删除
     * @param article_id
     * @throws SQLException
     */
    void deleteZhuanzaiById(int article_id) throws SQLException;

    /**
     * 用户转载文章
     * @param article_id
     * @param user_id
     * @return
     * @throws SQLException
     */
    void ZhuanZai(int user_id, int article_id ) throws SQLException;

    /**
     * 查询用户转载的文章，返回用户id和文章id
     * @param user_id
     * @return
     * @throws SQLException
     */
    List<Zhuanzai> ZhuanZaiArticle(int user_id) throws SQLException;

    /**
     * 删除用户转载的文章
     * @param user_id
     * @param article_id
     * @throws SQLException
     */
    void deleteZhuanzai(int user_id,int article_id) throws SQLException;

    /**
     * 用户收藏文章
     * @param article_id
     * @param user_id
     * @return
     * @throws SQLException
     */
    void ShouCangArticle(int user_id, int article_id ) throws SQLException;


}
