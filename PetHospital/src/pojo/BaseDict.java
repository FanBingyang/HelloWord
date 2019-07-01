package pojo;

public class BaseDict {

    //医生的专业
    private String vetMajor;

    //动物的种类
    private String petKind;

    private User user;

    public String getVetMajor() {
        return vetMajor;
    }

    public void setVetMajor(String vetMajor) {
        this.vetMajor = vetMajor;
    }

    public String getPetKind() {
        return petKind;
    }

    public void setPetKind(String petKind) {
        this.petKind = petKind;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
