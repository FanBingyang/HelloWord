package pojo;

public class Pet {
    private Integer petId;

    private String petName;

    private String petKind;

    private String petBir;

    private Integer clientId;

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

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
        this.petKind = petKind == null ? null : petKind.trim();
    }

    public String getPetBir() {
        return petBir;
    }

    public void setPetBir(String petBir) {
        this.petBir = petBir == null ? null : petBir.trim();
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }
}