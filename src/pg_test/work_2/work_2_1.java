package pg_test.work_2;

import static java.lang.Thread.sleep;

/**
 * @author liyajun
 * @date 2022/5/9 14:51
 */
public class work_2_1 {
    public static void main(String[] args) {
        print();

        print();
    }

    private static void print() {
        new Thread(() -> {
            for(int i = 1;i <= 20;i++){
                System.out.println(Thread.currentThread().getName()+"第"+i+"次打印");
                try {
                    sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
