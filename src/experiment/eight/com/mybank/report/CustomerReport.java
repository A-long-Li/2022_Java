package experiment.eight.com.mybank.report;

import experiment.eight.com.mybank.domain.Bank;
import experiment.eight.com.mybank.domain.Customer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author liyajun
 * @date 2022/5/2 13:31
 */
public class CustomerReport {
    public void generateReport(){
        File file = new File("src\\experiment\\eight\\com\\mybank\\TestData\\rep.dat");
//        System.out.println("start");
        try (PrintWriter pt = new PrintWriter(new FileWriter(file))){
            pt.println("_______________________ split line _________________________");
            for(int i = 0;i < Bank.getNumbersOfCustomers(); i++){
                Customer customer = Bank.getCustomer(i);
                pt.println(customer);
            }
            pt.println("_______________________ split line _________________________");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
