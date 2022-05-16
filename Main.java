import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int type=0;
        //array of customers
        Customer[] customers = new Customer[3];
        customers[0] = new Customer("Bruce","Wayne","Brampton","bWayne","12345");
        customers[1] = new Customer("Thanos", "Badman", "North York", "tBadman", "56789");
        customers[2] = new Customer("Wonder", "Woman", "Oakville", "wWoman", "39087");

        //array of accounts
        Account[] acc = new Account[4];
        acc[0] = new Account(1,"Bruce Wayne", 500, "Savings", 0);
        acc[1] = new Account(2, "Thanos Badman", 1000.00, "Savings", 0);
        acc[2] = new Account(3, "Wonder Woman", 500000.00, "Checking", 1500);
        acc[3] = new Account(4, "Bruce Wayne", 400000.00, "Checking", 10000);

        customers[0].addAccount(acc[0]);
        customers[0].addAccount(acc[3]);
        customers[1].addAccount(acc[1]);
        customers[2].addAccount(acc[2]);

        //Enter the username, if username does not exist the program terminates.
        System.out.println("Enter your username:");
        String uname = in.next();
        for(int i =0;i<customers.length;i++){
            if(uname.equals(customers[i].getUsername())){
                String res = "";
                do{
                    /*In side a do-while loop, because I implemented a way for user to retry password if it was enter incorrectly.
                    Program would terminate if you cannot get the password and you do not want to retry.
                     */
                    System.out.println("Enter your password:");
                    String pword = in.next();
                    if(pword.equals(customers[i].getPw())){
                        System.out.println("Welcome Mr."+customers[i].getFname()+" "+customers[i].getLname()+"!");
                        System.out.println("Account Type:");
                        System.out.println("Enter 'C' or 'c' for Checkings Account");
                        System.out.println("Enter 'S' or 's' for Savings Account");
                        String accountres = in.next();

                        if(accountres.equalsIgnoreCase("c")){
                            String operationres = "";
                            type=1;
                            if(uname.equalsIgnoreCase("bwayne")){
                                type=0;
                            }
                            do {
                                    if (customers[i].getType(type).equals("Checking")) {
                                        System.out.println("Name: "+customers[i].getCustomer(type)+"\n");
                                        System.out.println("Balance: " + customers[i].getBalance(type) + "\n");
                                        System.out.println("Account type: " + customers[i].getType(type) + "\n");
                                        System.out.println("Operation: \n");
                                        System.out.println("Enter D or 'd' to deposit");
                                        System.out.println("Enter W or 'w' to withdraw");
                                        System.out.println("Enter X or 'x' to exit app");
                                        operationres = in.next();
                                        if (operationres.equalsIgnoreCase("d")) {
                                            System.out.println("How much do you want to Deposit: ");
                                            double depo = in.nextDouble();
                                            Account checkingacc = new Checking(customers[i].getAcc_no("checking"), customers[i].getCustomer(type), customers[i].getBalance(type), customers[i].getType(type), customers[i].getOverdraft(type), depo, 0);
                                            customers[i].setBalance(checkingacc.getTotalBalance(), type);
                                            System.out.println(checkingacc.getTotalBalance());
                                        }
                                        else if (operationres.equalsIgnoreCase("w")) {
                                            System.out.println("How much do you want to Withdraw: ");
                                            double withdraw = in.nextDouble();
                                            Account checkingacc = new Checking(customers[i].getAcc_no("checking"), customers[i].getCustomer(type), customers[i].getBalance(type), customers[i].getType(type),customers[i].getOverdraft(type), 0, withdraw);
                                            if (checkingacc.getTotalBalance() < -customers[i].getOverdraft(type) || customers[i].getBalance(type) < -customers[i].getOverdraft(type)) {
                                                System.out.println("Cannot withdraw that much money!\n");
                                                customers[i].setBalance(customers[i].getBalance(type), type);
                                            } else {
                                                System.out.println(checkingacc.getTotalBalance());
                                                customers[i].setBalance(checkingacc.getTotalBalance(), type);
                                            }
                                        }
                                    }
                            }while(!operationres.equalsIgnoreCase("x"));
                            System.out.println("Good Bye! Have a Great Day");
                        }else if(accountres.equalsIgnoreCase("s")){
                            String operationres = "";
                            type=1;
                            do {
                                    if (customers[i].getType(type).equals("Savings") && customers[i].getCustomer(type).equals(customers[i].getFname() + " " + customers[i].getLname())) {
                                        System.out.println("Name: "+customers[i].getCustomer(type)+"\n");
                                        System.out.println("Balance: " + customers[i].getBalance(type));
                                        System.out.println("Account type: " + customers[i].getType(type) + "\n");
                                        System.out.println("Operation: \n");
                                        System.out.println("Enter D or 'd' to deposit");
                                        System.out.println("Enter W or 'w' to withdraw");
                                        System.out.println("Enter X or 'x' to exit app");
                                        operationres = in.next();
                                        if (operationres.equalsIgnoreCase("d")) {
                                            System.out.println("How much do you want to Deposit: ");
                                            double depo = in.nextDouble();
                                            Account savingsacc = new Checking(customers[i].getAcc_no("savings"), customers[i].getCustomer(type), customers[i].getBalance(type), customers[i].getType(type), customers[i].getOverdraft(type), depo, 0);
                                            customers[i].setBalance(savingsacc.getTotalBalance(), type);
                                            System.out.println(savingsacc.getTotalBalance());
                                        } else if (operationres.equalsIgnoreCase("w")) {
                                            System.out.println("How much do you want to Withdraw: ");
                                            double withdraw = in.nextDouble();
                                            Account savingsacc = new Checking(customers[i].getAcc_no("savings"), customers[i].getCustomer(type), customers[i].getBalance(type), customers[i].getType(type), customers[i].getOverdraft(type), 0, withdraw);
                                            if (savingsacc.getTotalBalance() < 0 ||  customers[i].getTotalBalance(type) < 0) {
                                                System.out.println("Cannot withdraw that much money!\n");
                                                customers[i].setBalance(customers[i].getBalance(type),type);
                                            } else {
                                                customers[i].setBalance(savingsacc.getTotalBalance(), type);
                                                System.out.println(savingsacc.getTotalBalance());
                                            }
                                        }
                                    }
                            }while(!operationres.equalsIgnoreCase("x"));
                            System.out.println("Good Bye! Have a Great Day");
                        }else{
                            System.out.println("Account does not Exist");
                        }
                        break;
                    }else{
                        System.out.println("Wrong password, Want to try again? (Y/N)");
                        res = in.next();
                    }
                }while(res.equalsIgnoreCase("y"));
                if(res.equalsIgnoreCase("n")){
                    System.out.println("Log in Failed.");
                }
            }
        }
    }
}
