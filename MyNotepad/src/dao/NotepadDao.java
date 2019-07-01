package dao;

import domain.Article;
import domain.User;
import domain.Zhuanzai;

import java.sql.SQLException;
import java.util.AbstractQueue;
import java.util.List;

public interface NotepadDao {

    /**
     * ��֤��¼
     * @param name
     * @param pwd
     * @return ��֤ͨ�������û���Ϣ
     * @throws SQLException
     */
    User login(String name,String pwd) throws SQLException;

    /**
     * �����û�id��ѯ�û���Ϣ
     * @param userid
     * @return �û���Ϣ
     * @throws SQLException
     */
    User findUserById(int userid) throws SQLException;

    /**
     * ע��ʱ������û�
     * @param user
     * @throws SQLException
     */
    void insterUser(User user) throws SQLException;

    /**
     * �����û���Ϣ
     * @param user ��Ҫ���µ��û�����
     * @throws SQLException
     */
    void update(User user) throws SQLException;

    /**
     * �����û�ͷ��
     * @param userid
     * @param touxiang
     * @throws SQLException
     */
    void changeTouxiang(int userid,String touxiang) throws SQLException;

    /**
     * ������д�뵽���ݿ�
     * @param article
     * @throws SQLException
     */
    void writeArticle(Article article) throws SQLException;

    /**
     * ��������id��ѯ��������
     * @param user_id
     * @return ��������
     * @throws SQLException
     */
    int findArticleCount(int user_id,String tableName) throws SQLException;

    /**
     * ��ѯ�������²���ʱ������
     * @return �����б�List
     * @throws SQLException
     */
    List<Article> findAllArticle() throws SQLException;

    /**
     * ������id��ѯ
     * @param article_id
     * @return ��������
     * @throws SQLException
     */
    Article findArticleById(int article_id) throws SQLException;

    /**
     * ������id��ѯ
     * @param user_id
     * @return �����б�List
     * @throws SQLException
     */
    List<Article> findArticleByUserId(int user_id) throws SQLException;

    /**
     * ��������id�����Ӧ��ǩ�����£������û��������
     * @param user_id
     * @param lable
     * @return �����б�List
     * @throws SQLException
     */
    List<Article> UserLableArticle(int user_id,String lable) throws SQLException;

    /**
     * ���������Ʋ�ѯ
     * @param article_name
     * @return �����б�List
     * @throws SQLException
     */
    Article findArticleByName(String article_name) throws SQLException;

    /**
     * ����ҳ��������Ĺؼ��ֲ�ѯ���£�ģ����ѯ
     * @param str
     * @return
     * @throws SQLException
     */
    List<Article> findArticleLikeName(String str) throws SQLException;

    /**
     * �����±�ǩ��ѯ
     * @param lable
     * @return �����б�List
     * @throws SQLException
     */
    List<Article> findArticleByLable(String lable) throws SQLException;

    /**
     * ��������idɾ������
     * @param article_id
     * @throws SQLException
     */
    void deleteArticleById(int article_id) throws SQLException;

    /**
     * ������ɾ��������ʱ�������û���ת�ؼ�¼Ҳ����ɾ��
     * @param article_id
     * @throws SQLException
     */
    void deleteZhuanzaiById(int article_id) throws SQLException;

    /**
     * �û�ת������
     * @param article_id
     * @param user_id
     * @return
     * @throws SQLException
     */
    void ZhuanZai(int user_id, int article_id ) throws SQLException;

    /**
     * ��ѯ�û�ת�ص����£������û�id������id
     * @param user_id
     * @return
     * @throws SQLException
     */
    List<Zhuanzai> ZhuanZaiArticle(int user_id) throws SQLException;

    /**
     * ɾ���û�ת�ص�����
     * @param user_id
     * @param article_id
     * @throws SQLException
     */
    void deleteZhuanzai(int user_id,int article_id) throws SQLException;

    /**
     * �û��ղ�����
     * @param article_id
     * @param user_id
     * @return
     * @throws SQLException
     */
    void ShouCangArticle(int user_id, int article_id ) throws SQLException;


}
