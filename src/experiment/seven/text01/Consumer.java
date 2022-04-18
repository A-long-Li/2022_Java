package experiment.seven.text01;

/**
 * @author liyajun
 * @date 2022/4/18 14:58
 */
public class Consumer extends Thread{
    private MyStack myStack;
    public Consumer(MyStack my){
        this.myStack = my;
    }
    @Override
    public void run(){
        while(true){
            myStack.pop();
        }
    }
}
