package experiment.seven.text01;

/**
 * @author liyajun
 * @date 2022/4/18 14:58
 */
public class Producer extends Thread{
    private MyStack myStack;
    public Producer(MyStack my){
        this.myStack = my;
    }
    @Override
    public void run(){
        while(true){
            //if(myStack.getPoint() == MyStack.SIZE) this.notifyAll();
            myStack.push('c');
        }
    }

}
