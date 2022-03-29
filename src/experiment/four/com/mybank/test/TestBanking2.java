package experiment.four.com.mybank.test;


import experiment.four.com.mybank.domain.Account;
import experiment.four.com.mybank.domain.Bank;
import experiment.four.com.mybank.domain.CheckingAccount;
import experiment.four.com.mybank.domain.SavingsAccount;

import java.util.Random;

public class TestBanking2 {
    public static void main(String[] args) {
        Random ra = new Random();
        for(int i = 0;i < 10; i++){

            Bank.addCustomer(Integer.toString(i + 1), "Jinx");
            for(int j = 0;j < 10;j++){
                Bank.getCustomer(i).addAccount(ra.nextDouble(114.15));
            }
        }
        //普通账户
        for(int i = 0;i < 10; i++){
           if(i == 0) System.out.println(Bank.getCustomer(0).toString());
            System.out.print("账户"+(i+1)+"的余额为");
            System.out.println(String.format("%.2f",Bank.getCustomer(0).getAccount(i).getBalance()));
        }
        //测试利息账户
        for(int i = 0; i < 10; i ++){
            if(i == 0) System.out.println(Bank.getCustomer(1).toString());
            SavingsAccount sa = new SavingsAccount(Bank.getCustomer(1).getAccount(i).getBalance(),ra.nextDouble(114.51));
            System.out.print("账户"+(i+1)+"的余额加上利息为");
            System.out.println(String.format("%.2f",sa.getBalance()));
        }

        //测试贷款账户
        for(int i = 0; i < 10; i ++){
            if( i == 0)System.out.println(Bank.getCustomer(2).toString());
            System.out.println("账户"+(i+1)+"的取款情况为");
            CheckingAccount ck = new CheckingAccount(Bank.getCustomer(2).getAccount(i).getBalance(),ra.nextDouble(114.514));
            if(ck.withdraw(ra.nextDouble(114.51)) == 1){
                System.out.println("余额 + 贷款不足 不能取出");
                System.out.println("当前余额为" + String.format("%.2f",ck.getBalance()));
                System.out.println("当前可用贷款余额为" + String.format("%.2f",ck.getOverdraftAmount()));
            }
            else if(ck.withdraw(ra.nextDouble(114.51)) == 2){
                System.out.println("使用贷款可以取出");
                System.out.println("当前余额为" + String.format("%.2f",ck.getBalance()));
                System.out.println("当前可用贷款余额为" + String.format("%.2f",(ck.getOverdraftAmount())));
            }
            else{
                System.out.println("当前余额足够取出，不需要贷款");
                System.out.println("当前余额为" + String.format("%.2f",ck.getBalance()));
                System.out.println("当前可用贷款余额为" + String.format("%.2f",ck.getOverdraftAmount()));
            }
        }
    }
}
