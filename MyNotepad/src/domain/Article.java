package domain;

public class Article {
    private int article_id;
    private String article_name;
    private String content;
    private int user_id;
    private String article_time;
    private String lable;
    private User author;

    //空参构造方法
    public Article(){ }

    //用于封装信息的构造方法
    public Article(int article_id, String article_name, String content, int user_id, String article_time, String lable) {
        this.article_id = article_id;
        this.article_name = article_name;
        this.content = content;
        this.user_id = user_id;
        this.article_time = article_time;
        this.lable = lable;
    }

    //用于上传新的文章时进行封装
    public Article(String article_name, String content, int user_id, String article_time, String lable) {
        this.article_name = article_name;
        this.content = content;
        this.user_id = user_id;
        this.article_time = article_time;
        this.lable = lable;
    }

    public Article(int article_id, String article_name, String content, int user_id, String article_time, String lable, User author) {
        this.article_id = article_id;
        this.article_name = article_name;
        this.content = content;
        this.user_id = user_id;
        this.article_time = article_time;
        this.lable = lable;
        this.author = author;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public String getArticle_name() {
        return article_name;
    }

    public void setArticle_name(String article_name) {
        this.article_name = article_name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getArticle_time() {
        return article_time;
    }

    public void setArticle_time(String article_time) {
        this.article_time = article_time;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Article{" +
                "article_id=" + article_id +
                ", article_name='" + article_name + '\'' +
                ", content='" + content + '\'' +
                ", user_id=" + user_id +
                ", article_time='" + article_time + '\'' +
                ", lable='" + lable + '\'' +
                ", author=" + author +
                '}';
    }
}
