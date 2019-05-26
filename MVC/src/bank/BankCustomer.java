package bank;

import java.util.HashMap;

public class BankCustomer {

    public static HashMap<String,BankCustomer> customers;

    private String id;
    private String firstName;
    private String lastName;
    private double balance;

    static {
        customers = new HashMap<>();
        customers.put("id001",new BankCustomer("id001","John",
                "Hacker",-3456.78));
        customers.put("id002",new BankCustomer("id002","Jane",
                "Hacker",1234.56));
        customers.put("id003",new BankCustomer("id003","Juan",
                "Hacker",987654.32));
    }

    public static BankCustomer getCustomer(String id){
        return customers.get(id);
    }






    public BankCustomer(String id,String firstName,String lastName,double balance){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    public double getBalanceNoSign(){
        return Math.abs(balance);
    }

    public void setBalance(){
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getBalance() {
        return balance;
    }
}
