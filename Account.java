public class Account {

    //properties
    private int acc_no;
    private String customer;
    private double balance;
    private String type;
    private double overdraft;

    public Account(){}

    public Account(int acc_no, String customer, double balance, String type, double overdraft) {
        this.acc_no = acc_no;
        this.customer = customer;
        this.balance = balance;
        this.type = type;
        this.overdraft = overdraft;
    }

    public int getAcc_no() {
        return acc_no;
    }

    public void setAcc_no(int acc_no) {
        this.acc_no = acc_no;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    public double getTotalBalance(){
        return balance+1;
    }

    @Override
    public String toString() {
        return "Account{" +
                "acc_no=" + acc_no +
                ", customer='" + customer + '\'' +
                ", balance=" + balance +
                ", type='" + type + '\'' +
                ", overdraft=" + overdraft +
                '}';
    }
}
