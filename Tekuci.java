package BankaBezNovcanika;

public class Tekuci extends Account{
    private static String accountType= "Tekuci";
   Tekuci (double initialDeposit) {
       super();
       this.setBalance(initialDeposit);

   } public String toString() {
       return "vrsta racuna" + accountType + "Racun\n "+
               "Broj racuna: +" + this.getAccountNumber()  + "\n"+
               "Stanje: " + this.getBalance() + "\n";
    }

    }

