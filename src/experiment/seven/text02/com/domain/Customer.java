package experiment.seven.text02.com.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    String firstName;
    String lastName;
    List<Account> accounts;
    //Account[] accounts;
    int numbersOfAccounts;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        accounts = new ArrayList<>();
    }
    public void addAccount(double amount){
           addAccount(new Account(amount));
    }
    public void addAccount(Account acc){
            accounts.add(acc);
    }
    public Account getAccount(int id){
        try {
            return accounts.get(id);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public int getNumbersOfAccounts() {
        return accounts.size();
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return  firstName + "-" +  lastName ;
    }
}
