package BankaBezNovcanika;

public class Customer {
    private final String firstName;
    private final String lastName;
    private final String jmbg;
    private final Account account;


    public Customer(String firstName, String lastName, String jmbg, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jmbg = jmbg;
        this.account = account;
    }

    @Override
    public String toString(){
        return "\nCustomer information \n" +
                "Ime: " + firstName + "\n" +
                "Prezime: " + lastName + "\n" +
                "JMBG: " + jmbg + "\n" +
                account;
     }
    public String basicInfo(){
        return "Ime: " + firstName +
                " Prezime: " + lastName +
                " JMBG: " + jmbg +
                " Broj racuna"  + account.getAccountNumber();
    }
        Account getAccount (){
        return account;
        }
}
