package experiment.seven.text03;

import java.util.Random;

/**
 * @author liyajun
 * @date 2022/4/18 16:02
 */
public class GenNum implements Runnable{
    int num;
    @Override
    public synchronized void run(){
        Random ran = new Random();
        this.num = ran.nextInt(100);
    }
    public int getNum(){
        return num;
    }
}
