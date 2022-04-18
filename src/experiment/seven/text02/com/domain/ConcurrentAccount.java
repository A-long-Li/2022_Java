package experiment.seven.text02.com.domain;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liyajun
 * @date 2022/4/18 14:03
 */
public class ConcurrentAccount {
    private volatile double balance = 0.0;
    private Lock lock = new ReentrantLock();

    /**
     * 存钱
     * @param amt
     */
    public void deposit(double amt){
        lock.lock();
        balance += amt;
        System.out.println(Thread.currentThread().getName()+"存入"+amt+"元");
        lock.unlock();
    }

    /**
     * 取钱
     * @param amt
     */
    public void withdraw(double amt){
        lock.lock();
        if(balance >= amt){
            balance -= amt;
            System.out.println(Thread.currentThread().getName()+"取出"+amt+"元");
        } else {
            System.out.println(Thread.currentThread().getName()+"余额不足");
        }
        lock.unlock();
    }

    /**
     * 获取余额
     */
    public void getBalance(){
        System.out.println("账户余额为" + balance+"元");
    }
}

/*


public class ConcurrentAccount {
    private volatile double balance = 0.0;

    public synchronized void deposit(double amt){
        this.notifyAll();
        balance += amt;
        System.out.println(Thread.currentThread().getName()+"存入"+amt+"元");
    }

    public synchronized void withdraw(double amt){
        if(balance == 0) {
            System.out.println(Thread.currentThread().getName()+"余额不足");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(balance >= amt){
            balance -= amt;
            System.out.println(Thread.currentThread().getName()+"取出"+amt+"元");
        } else {
            System.out.println(Thread.currentThread().getName()+"余额不足");
        }
    }

    public void getBalance(){
        System.out.println("账户余额为" + balance+"元");
    }
}
*/
