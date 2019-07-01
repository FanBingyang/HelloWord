package pojo;

public class Vet {
    private Integer vetId;

    private String vetName;

    private String vetSex;

    private String vetAge;

    private String vetTel;

    private String vetMajor;

    public Integer getVetId() {
        return vetId;
    }

    public void setVetId(Integer vetId) {
        this.vetId = vetId;
    }

    public String getVetName() {
        return vetName;
    }

    public void setVetName(String vetName) {
        this.vetName = vetName == null ? null : vetName.trim();
    }

    public String getVetSex() {
        return vetSex;
    }

    public void setVetSex(String vetSex) {
        this.vetSex = vetSex == null ? null : vetSex.trim();
    }

    public String getVetAge() {
        return vetAge;
    }

    public void setVetAge(String vetAge) {
        this.vetAge = vetAge == null ? null : vetAge.trim();
    }

    public String getVetTel() {
        return vetTel;
    }

    public void setVetTel(String vetTel) {
        this.vetTel = vetTel == null ? null : vetTel.trim();
    }

    public String getVetMajor() {
        return vetMajor;
    }

    public void setVetMajor(String vetMajor) {
        this.vetMajor = vetMajor == null ? null : vetMajor.trim();
    }
}