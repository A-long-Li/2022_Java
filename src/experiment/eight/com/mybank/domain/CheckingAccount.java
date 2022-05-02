package experiment.eight.com.mybank.domain;

//能够透支的账户
public class CheckingAccount extends Account {
    double overdraftAmount;

    public CheckingAccount(double initBalance, double overdraftAmount){
        super(initBalance);
        this.overdraftAmount = overdraftAmount;
    }
    CheckingAccount(double initBalance){
        super(initBalance);
        this.overdraftAmount = 0.0;
    }

    public double getOverdraftAmount() {
        return overdraftAmount;
    }

    @Override
    public void withdraw(double amount) throws OverdraftException {
        if(balance < amount){
            //使用贷款
            double overdraftNeeded = amount - balance;
            if(overdraftNeeded > overdraftAmount){
                throw new OverdraftException("透支额度不足", overdraftNeeded);
            }
            else{
                balance = 0.0;
                overdraftAmount -= overdraftNeeded;
            }
        } // 能够付清
        else{
            balance -= amount;
        }
    }
}
