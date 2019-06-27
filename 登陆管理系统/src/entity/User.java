package entity;

public class User extends ValueObject{

    private String account;
    private String password;
    private String username;
    private String email;
    private String phone;
    //外键
    private int id_card_fk;

    //外键引用
    private IDCard idCard;

    public User(){}
    public User(String account, String password, String username,
                String email, String phone){
        this.account = account;
        this.password = password;
        this.username = username;
        this.email = email;
        this.phone = phone;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId_card_fk() {
        return id_card_fk;
    }

    public void setId_card_fk(int id_card_fk) {
        this.id_card_fk = id_card_fk;
    }

    public IDCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IDCard idCard) {
        this.idCard = idCard;
    }
}
