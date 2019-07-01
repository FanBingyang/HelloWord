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
     * ��֤��¼
     * @param name
     * @param pwd
     * @return ��֤ͨ�������û���Ϣ
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
     * �����û�id��ѯ�û���Ϣ
     * @param userid
     * @return �û���Ϣ
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
     * ע��ʱ������û�
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
     * �����û���Ϣ
     * @param user ��Ҫ���µ��û�����
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
     * �����û�ͷ��
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
     * ������д�뵽���ݿ�
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
     * �����û�id��ѯ��������
     * @param user_id
     * @param tableName
     * @return ��������
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
     * ��ѯ�������²���ʱ������
     * @return �����б�List
     * @throws SQLException
     */
    @Override
    public List<Article> findAllArticle() throws SQLException {
        try {
            QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
            //desc�ǽ���,asc����
            return qr.query("select * from article order by article_time desc", new BeanListHandler<Article>(Article.class));
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * ������id��ѯ
     * @param article_id
     * @return �����б�List
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
     * ���û�id��ѯ
     * @param user_id
     * @return �����б�List
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
     * ��������id�����Ӧ��ǩ�����£������û��������
     * @param user_id
     * @param lable
     * @return �����б�List
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
     * ���������Ʋ�ѯ
     * @param article_name
     * @return �����б�List
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
     * ����ҳ��������Ĺؼ��ֲ�ѯ���£�ģ����ѯ
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
     * �����±�ǩ��ѯ
     * @param lable
     * @return �����б�List
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
     * ��������idɾ������
     * @param article_id
     * @throws SQLException
     */
    @Override
    public void deleteArticleById(int article_id) throws SQLException {
        try {
            QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
            qr.update("delete from article where article_id=?",article_id);
            //������ɾ��������ʱ�������û���ת�ؼ�¼Ҳ����ɾ��
            deleteZhuanzaiById(article_id);
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * ��������idɾ��ת�ع������µ�ת�ؼ�¼
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
     * �û�ת������
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
     * ɾ���û�ת�ص�����
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
     * ��ѯ���û�����ת�ع�������
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
     * �û��ղ�����
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
