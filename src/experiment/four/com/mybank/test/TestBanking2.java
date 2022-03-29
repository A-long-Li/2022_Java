package experiment.four.com.mybank.test;

import com.mybank.domain.Account;
import com.mybank.domain.Bank;
import experiment.four.com.mybank.domain.SavingsAccount;

import java.util.Random;

public class TestBanking2 {
    public static void main(String[] args) {
        for(int i = 0;i < 10; i++){
            Random ra = new Random();
            Bank.addCustomer(Integer.toString(i + 1), "Jinx");
            Bank.getCustomer(i).addAccount(ra.nextDouble(114.15));
        }
        for(int i = 0; i < 10; i ++){
        }
    }
}
