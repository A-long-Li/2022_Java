package experiment.seven.text01;

/**
 * @author liyajun
 * @date 2022/4/18 14:58
 */
public class SyncTest {
    public static void main(String[] args) {
        MyStack my = new MyStack();
        Consumer co = new Consumer(my);
        Producer pr = new Producer(my);
        co.start();
        pr.start();
    }
}
