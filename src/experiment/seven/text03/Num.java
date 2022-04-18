package experiment.seven.text03;

/**
 * @author liyajun
 * @date 2022/4/18 15:56
 * 出数字的线程为守护线程
 */
public class Num {

    public static void main(String[] args) {
        GenNum n1 = new GenNum();
        Thread t1 = new Thread(n1);
        t1.run();
        //将t1出数字的设置为守护线程
        t1.setDaemon(true);
        try {
            Thread.sleep(100);
            GenNum n2 = new GenNum();
            Thread t2 = new Thread(n2);
            while(true){
                t2.interrupt();
                t2.run();
                Thread.sleep(100);
                t1.interrupt();
                if(n1.getNum() == n2.getNum()){
                    System.out.println("猜的数字为"+n2.getNum());
                    System.out.println("猜对了!");
                    break;
                } else if(n1.getNum() > n2.getNum()){
                    System.out.println("猜的数字为"+n2.getNum());
                    System.out.println("猜小了");
                } else {
                    System.out.println("猜的数字为"+n2.getNum());
                    System.out.println("猜大了");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
