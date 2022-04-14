package demo;

/**
 * @author liyajun
 * @date 2022/4/6 15:32
 */
class ExMulti  {
    public static void example() {
        try{
            int a = 1/0;System.out.println("Test1");
        }catch(Exception e) {
            System.out.println("Test2");
        }finally{
            System.out.println("Test3");
        }
        System.out.println("Test4");
    }
    public static void main(String args[]) {example();
    }
}
