public class Savings extends Account {

    //properties
    private double deposit;
    private double withdraw;

    public Savings(){}

    public Savings(int acc_no, String customer, double balance, String type, double overdraft, double deposit, double withdraw){
        super(acc_no,customer,balance,type,overdraft);
        this.deposit = deposit;
        this.withdraw = withdraw;
    }
    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(double withdraw) {
        this.withdraw = withdraw;
    }

    public double getTotalBalance(){
        double totalBalance = super.getBalance();
        totalBalance += getDeposit();
        totalBalance -= getWithdraw();
        return totalBalance;
    }

}
