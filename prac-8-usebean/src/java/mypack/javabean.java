package mypack;
import java.io.*;
public class javabean implements Serializable{
    public String name;
    public String accno;
    public float balance=0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccno() {
        return accno;
    }

    public void setAccno(String accno) {
        this.accno = accno;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
    public javabean(){}
    
}
