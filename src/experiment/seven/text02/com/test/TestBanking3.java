package experiment.seven.text02.com.test;

import experiment.seven.text02.com.domain.ConcurrentAccount;

/**
 * @author liyajun
 * @date 2022/4/18 14:09
 */
public class TestBanking3 {
    public static void main(String[] args) {
        ConcurrentAccount ca = new ConcurrentAccount();
        new Thread(() -> {
            while (true){
                ca.deposit(114);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ca.getBalance();
            }
        }).start();
        new Thread(() -> {
            while (true){
                ca.withdraw(114);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ca.getBalance();
            }
        }).start();
    }
}
