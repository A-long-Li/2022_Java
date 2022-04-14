package experiment.three.com.mybank.domain;

public class Customer {
    String firstName;
    String lastName;
    Account[] accounts;
    int numbersOfAccounts;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        numbersOfAccounts = 0;
        accounts = new Account[10];
    }
    public void addAccount(double amount){
           addAccount(new Account(amount));
    }
    public void addAccount(Account acc){
        try {
            accounts[numbersOfAccounts++] = acc;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
    }
    public Account getAccount(int id){
        try {
            return accounts[id];
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
        return  null;
    }
    public int getNumbersOfAccounts() {
        return numbersOfAccounts;
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
