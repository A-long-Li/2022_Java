package experiment.eight.com.mybank.data;

import experiment.eight.com.mybank.domain.Bank;
import experiment.eight.com.mybank.domain.CheckingAccount;
import experiment.eight.com.mybank.domain.Customer;
import experiment.eight.com.mybank.domain.SavingsAccount;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author liyajun
 * @date 2022/5/2 13:16
 */
public class DataSource {
    public void loadData(File file){
        try {
            Scanner sc = new Scanner(file);
            //get the count of new add acc
            int add_count_num = sc.nextInt();
            for(int i = 0;i < add_count_num;i++){
                String firstName = sc.next();
                String lastName = sc.next();
                Bank.addCustomer(firstName, lastName);
                Customer cus_cur = Bank.getCustomer(i);
                // cus account count
                int count_cus_acc = sc.nextInt();
                for (int j = 0; j < count_cus_acc; j++) {
                    char accType = sc.next().charAt(0);
                    if(accType == 'S'){
                        double initBalance = sc.nextDouble();
                        double growRate = sc.nextDouble();
                        cus_cur.addAccount(new SavingsAccount(initBalance,growRate));
                    }
                    else {
                        double initBalance = sc.nextDouble();
                        double overdraft = sc.nextDouble();
                        cus_cur.addAccount(new CheckingAccount(initBalance, overdraft));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
