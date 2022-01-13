package BankaBezNovcanika;

public class Account {
    private double balance = 0;
    private int accountNumber;
    private static int numberOfAccounts = 1000000;

    Account (){
        accountNumber = numberOfAccounts++;
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void withdraw (double amount){
        if (amount > balance){
            System.out.println("Nemate dovoljno sredstava");
            return;
        }
        balance -= amount;
        System.out.println("povukli ste  " + amount);
        System.out.println("you have have a balance of " + balance);

    }
    public void deposit (double amount){
        if (amount <= 0){
            System.out.println("Ne mozete uplatiti negativnu sumu");
            return;
        }
        balance += amount;
        System.out.println("Uplatili ste  " + amount + "dinara");
        System.out.println("Vase stanje na racunu je  " + balance);


    }
}
