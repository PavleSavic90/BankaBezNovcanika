package BankaBezNovcanika;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Bank bank = new Bank();
    boolean exit;

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.runMenu();

    }
    public void runMenu(){
        printHeader();
        while (!exit){
            printMenu();
            int choice = getInput();
            preformAction(choice);
        }
    }

    private void printHeader() {
        System.out.println("--------------------------");
        System.out.println("-      Dobro dosli       -");
        System.out.println("-     u Banku P.S.       -");
        System.out.println("--------------------------");
    }
    private void printMenu(){
        System.out.println("Izaberite vasu opciju");
        System.out.println("1. Napravite racun");
        System.out.println("2. Uplatite na racun");
        System.out.println("3. Podignite sa racuna");
        System.out.println("4. Izlistaj racune");
        System.out.println("0. Izadji");

    }
    private int getInput(){
        int choice = -1;
        do {
            System.out.println("Ubacite vas izbor ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Neuspesna selekcija. Molimo koristite samo brojeve. ");
            }
            if (choice < 0 || choice > 4) {
                System.out.println("Izabrali ste nepostojecu opciju, pokusajte ponovo");
            }
        }
            while (choice < 0 || choice > 4) ;
            return choice;
        }

    private void preformAction(int choice){
        switch (choice){
            case 0:
                System.out.println("Hvala na saradnji");
                System.exit(0);
                break;
            case 1:
                createAnAccount();
                break;
            case 2:
                makeADeposit();
                break;
            case 3:
                makeAWithdrawal();
                break;
            case 4:
                listBalances();
            default:
                System.out.println("Greska");
        }
    }
    private void createAnAccount() {
        String firstName, lastName, jmbg, accountType = "";
        double initialDeposit = 0;
        boolean valid = false;
        while (!valid){
            System.out.println("molim vas izaberite vrstu racuna (tekuci)");
            accountType = scanner.nextLine();
            if (accountType.equalsIgnoreCase("tekuci")){
                valid = true;
            }
            else {
                System.out.println("Nepostojeci izbor racuna. Ukucajte tekuci");
            }
        }
        System.out.println("Unesite vase ime: ");
        firstName = scanner.nextLine();
        System.out.println("Unesite vase prezime: ");
        lastName = scanner.nextLine();
        System.out.println("Unesite vas JMBG");
        jmbg = scanner.nextLine();
        valid = false;
        while (!valid){
            System.out.print("Unesite pocetni depozit: ");
            try {
                initialDeposit = Double.parseDouble(scanner.nextLine());
            }
            catch (NumberFormatException e){
                System.out.println("Depozit mora biti broj");
            }
            if (accountType.equalsIgnoreCase("Tekuci")){
                if (initialDeposit < 1000){
                    System.out.println("Za otvaranje tekuceg racuna potrebno je najmanje 1000 dinara");
                }
                else {
                    valid = true;
                }

            }
        }

        Account account;
        if (accountType.equalsIgnoreCase("tekuci")){
                account = new Tekuci(initialDeposit);
        }else {
            account = new Tekuci(initialDeposit);
        }
        Customer customer = new Customer(firstName, lastName,jmbg, account);
        bank.addCustomer(customer);
    }



    private void makeAWithdrawal() {
            int account = selectAccount();
            if (account >= 0) {
                System.out.println(" Koliko zelite da povucete sa racuna: ");
                double amount = 0;
                try {
                    amount = Double.parseDouble(scanner.nextLine());
                } catch (NumberFormatException e) {
                    amount = 0;
                }
                bank.getCustomer(account).getAccount().withdraw(amount);
            }
    }
    private void makeADeposit() {
        int account = selectAccount();
        if (account >= 0) {
            System.out.println("Koliko zelite da uplatite na racun ");
            double amount = 0;
            try {
                amount = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                amount = 0;
            }
            bank.getCustomer(account).getAccount().deposit(amount);
        }
    }

    private int selectAccount() {
        ArrayList <Customer> customers = bank.getCustomers();
        if (customers.size() <= 0){
            System.out.println("Vasa banka nema musterija");
            return -1;
        }
        System.out.println("Izaberite racun: ");
        for (int i = 0; i <customers.size();i++){
            System.out.println((i + 1) + ") " + customers.get(i).basicInfo());
        }
        int account = 0;
        System.out.print("Unesite vas izbor ");
        try {
            account = Integer.parseInt(scanner.nextLine()) - 1;
        }
        catch (NumberFormatException e){
            account = -1;
        }
        if (account < 0 || account > customers.size()){
            System.out.println("Izabrali ste nepostojeci nalog. ");
            return account -1;
        }
        return account;
    }

    private void listBalances() {
            int account = selectAccount();
            if (account >= 0) {

                System.out.println(bank.getCustomer(account).getAccount());
            }
        }
    }
