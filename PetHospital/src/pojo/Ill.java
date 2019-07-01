package pojo;

public class Ill {
    private String petName;

    private String petKind;

    private String clientName;

    private String vetName;

    private String vetMajor;

    private String illness;

    private String tim;

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName == null ? null : petName.trim();
    }

    public String getPetKind() {
        return petKind;
    }

    public void setPetKind(String petKind) {
        this.petKind = petKind;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName == null ? null : clientName.trim();
    }

    public String getVetName() {
        return vetName;
    }

    public void setVetName(String vetName) {
        this.vetName = vetName == null ? null : vetName.trim();
    }

    public String getVetMajor() {
        return vetMajor;
    }

    public void setVetMajor(String vetMajor) {
        this.vetMajor = vetMajor == null ? null : vetMajor.trim();
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness == null ? null : illness.trim();
    }

    public String getTim() {
        return tim;
    }

    public void setTim(String tim) {
        this.tim = tim == null ? null : tim.trim();
    }
}