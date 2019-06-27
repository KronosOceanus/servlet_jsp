package entity;

public class IDCard extends ValueObject{

    private String id_card_number;
    private String name;
    private String birthday;
    private String address;

    public IDCard(){}
    public IDCard(String id_card_number, String name,
                  String birthday, String address){
        this.id_card_number = id_card_number;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
    }

    public String getId_card_number() {
        return id_card_number;
    }

    public void setId_card_number(String id_card_number) {
        this.id_card_number = id_card_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
