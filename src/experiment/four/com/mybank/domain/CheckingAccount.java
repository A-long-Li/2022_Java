package experiment.four.com.mybank.domain;
//能够透支的账户
public class CheckingAccount extends Account{
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
    public int withdraw(double amount) {
        if(balance < amount){
            //使用贷款
            double overdraftNeeded = amount - balance;
            if(overdraftNeeded > overdraftAmount){
                return 1;
            }
            else{
                balance = 0.0;
                overdraftAmount -= overdraftNeeded;
                return 2;
            }
        } // 能够付清
        else{
            balance -= amount;
        }
        return 3;
    }
}
