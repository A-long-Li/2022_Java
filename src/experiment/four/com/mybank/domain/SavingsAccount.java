package experiment.four.com.mybank.domain;
//能计算利息的账户
public class SavingsAccount extends Account{
    private double interestRate;
    public SavingsAccount(double initBalance,double interestRate){
        this.balance = initBalance;
        this.interestRate = interestRate;
    }


    //计算利息
    public double accumulateInterest(){
        return balance + interestRate;
    }
}
