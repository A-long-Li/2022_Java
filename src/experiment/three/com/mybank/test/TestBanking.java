package experiment.three.com.mybank.test;

import experiment.three.com.mybank.domain.Bank;

import java.util.Random;

public class TestBanking {
    public static void main(String[] args) {
        //初始化成员
        for(int i = 0; i < 10; i++){
            Random ra = new Random();
            Bank.addCustomer(Integer.toString(i), "Jinx");
            for(int j = 0;j < 10; j++){
                Bank.getCustomer(i).addAccount(ra.nextDouble(1145.14));
                Bank.getCustomer(i).getAccount(j).withdraw(ra.nextDouble(1145.14));
            }
        }
        for(int i = 0;i < 10; i++){
            System.out.println(Bank.getCustomer(i).toString());
            for(int j = 0;j < 10; j++){
                System.out.println("第"+(j + 1 )+"个账户的余额为");
                System.out.println(String.format("%.2f", Bank.getCustomer(i).getAccount(j).getBalance()));
            }
        }

    }
}
