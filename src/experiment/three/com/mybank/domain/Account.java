package experiment.three.com.mybank.domain;

public class Account {
    protected double balance;
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
    public boolean withdraw(double amt){
        if(balance < amt) return false;
        balance -= amt;
        return true;
    }

    //获取余额
    public double getBalance(){
        return balance;
    }
}
