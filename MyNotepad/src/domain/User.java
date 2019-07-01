package domain;

public class User {
    private int id;
    private String username;
    private String password;
    private String sex;
    private String age;
    private String time;
    private String touxiang;

    //�ղι��췽��
    public User(){ }

    //���ڷ�װ��id�û��෽��
    public User(int id,String username,String password,String sex,String age,String time,String touxiang){
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.time = time;
        this.touxiang = touxiang;
    }
    //���ڷ�װ����id�û��෽��,ע�����û�ʱʹ��
    public User(String username,String password,String sex,String age,String time,String touxiang){
        super();
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.time = time;
        this.touxiang = touxiang;
    }

    //�����޸ĸ�����Ϣʱ��װ
    public User(int id, String username, String password, String sex, String age) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTouxiang() {
        return touxiang;
    }

    public void setTouxiang(String touxiang) {
        this.touxiang = touxiang;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", time='" + time + '\'' +
                ", touxiang='" + touxiang + '\'' +
                '}';
    }
}
