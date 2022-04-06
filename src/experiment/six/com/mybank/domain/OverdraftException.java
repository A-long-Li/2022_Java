package experiment.six.com.mybank.domain;

/**
 * @author liyajun
 * @date 2022/4/6 14:40
 */
public class OverdraftException extends Exception{
    private double deficit;

    public OverdraftException(String message,double deficit){
        super(message);
        this.deficit = deficit;
    }

    public double getDeficit() {
        return deficit;
    }
}
