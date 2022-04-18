package experiment.seven.text01;

import java.util.List;
import java.util.Stack;

/**
 * @author liyajun
 * @date 2022/4/18 14:58
 */
public class MyStack {
    static final int SIZE = 10;
    private volatile Stack<Character> st = new Stack<>();
    public  synchronized void push(char c){
        if(st.size() > SIZE){
            System.out.println("容量已满");
            try {
                this.wait();
                this.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + "生产了"+c);
            this.notify();
            st.push(c);
        }
    }
    public synchronized void pop(){
        if(st.size() == 0){
            System.out.println("容量为空请生产");
            try {
                this.wait();
                this.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + "取走了"+ st.pop());
            this.notify();
        }
    }
    public int getPoint(){
        return st.size();
    }
}
