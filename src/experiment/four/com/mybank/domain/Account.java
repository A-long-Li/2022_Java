package experiment.four.com.mybank.domain;

public class Account {
    protected double balance;

    public Account(double initBalance) {
        this.balance = initBalance;
    }

    //初始化余额
    public void initBalance(double balance) {
        this.balance = balance;
    }
    //存钱
    public boolean deposit(double amt){
        if(amt < 0) return false;
        balance += amt;
        return true;
    }
    //取钱
    public int withdraw(double amt){
        if(balance < amt) return 0;
        balance -= amt;
        return 1;
    }

    //获取余额
    public double getBalance(){
        return balance;
    }
}
