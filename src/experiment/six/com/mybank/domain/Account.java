package experiment.six.com.mybank.domain;

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
    public void deposit(double amt){
        balance += amt;
    }
    //取钱
    public void withdraw(double amt) throws OverdraftException {
        if(balance > amt) balance -= amt;
        else {
            throw new OverdraftException("余额不足", amt - balance);
        }
    }

    //获取余额
    public double getBalance(){
        return balance;
    }
}
