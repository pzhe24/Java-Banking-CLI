import java.util.ArrayList;

public class Customer {

    //properties
    private String fname;
    private String lname;
    private String location;
    private String username;
    private String pw;
    private ArrayList<Account> accounts;

    public Customer(){}

    public Customer(String fname, String lname, String location, String username, String pw){
        this.fname = fname;
        this.lname = lname;
        this.location = location;
        this.username = username;
        this.pw = pw;
        this.accounts = new ArrayList<Account>();
    }

    public void addAccount(Account account){
        accounts.add(account);
    }

    public int getAcc_no(String type){
        return accounts.get(0).getAcc_no();
    }

    public String getCustomer(int type){
        if(type==1){
            return accounts.get(0).getCustomer();
        }else{
            return accounts.get(1).getCustomer();
        }
    }
    public double getBalance(int type){
        if(type==1){
            return accounts.get(0).getBalance();
        }else{
            return accounts.get(1).getBalance();
        }
    }
    //need a way to get the 2 accounts from bruce wayne.
    public String getType(int type){
        if(type==1){
            return accounts.get(0).getType();
        }else{
            return accounts.get(1).getType();
        }
    }

    public double getOverdraft(int type){
        if(type==1){
            return accounts.get(0).getOverdraft();
        }else{
            return accounts.get(1).getOverdraft();
        }
    }

    public double getTotalBalance(int type){
        if(type==1){
            return accounts.get(0).getTotalBalance();
        }else{
            return accounts.get(1).getTotalBalance();
        }
    }

    public void setBalance(double balance, int type){
        if(type==1){
            this.accounts.get(0).setBalance(balance);
        }else{
            this.accounts.get(1).setBalance(balance);
        }
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", location='" + location + '\'' +
                ", username='" + username + '\'' +
                ", pw='" + pw + '\'' +
                '}';
    }
}
