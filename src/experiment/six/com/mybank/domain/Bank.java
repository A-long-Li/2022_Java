package experiment.six.com.mybank.domain;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    static List<Customer> customers;
    static {
        customers = new ArrayList<>();
    }
    public static void addCustomer(String firstName, String lastName){
        customers.add(new Customer(firstName,lastName));
    }
    public static int getNumbersOfCustomers(){
        return customers.size();
    }
    public static Customer getCustomer(int id){
        try {
            return customers.get(id);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
        return null;
    }
}
