package demo;

/**
 * @author liyajun
 * @date 2022/5/2 14:42
 */
class myStack{
    private String [] buff = new String[100];
    int pt = -1;
    public void push(String goods) {
        pt++;
        Thread.yield();
        buff[pt] = goods;
    }
    public String pop(){
        String goods = buff[pt];
        buff[pt] = null;
        Thread.yield();
        pt--;
        return goods;
    }
    int getPt(){
        return pt;
    }
}
class prod extends Thread {
    private myStack stack;
    public prod(myStack stack,String name){
        super(name);
        this.stack = stack;
        start();
    }
    @Override
    public void run(){
        String goods;
        for(int i = 0;i <= 200; i++){
            goods = "goods" + stack.getPt() + 1;
            stack.push(goods);
            System.out.println(currentThread().getName()+"1");
            Thread.yield();
        }
    }
}
class con extends Thread {
    private myStack stack;
    public con(myStack stack,String name){
        super(name);
        this.stack = stack;
        start();
    }
    @Override
    public void run(){
        for(int i = 0; i <= 200; i++){
            String goods = stack.pop();
            System.out.println(currentThread().getName()+"2"+goods);
            Thread.yield();
        }
    }
}
public class Test {
    public static void main(String[] args) {
        myStack my = new myStack();
        prod p = new prod(my,"push");
        con c = new con(my,"push");
    }
}
