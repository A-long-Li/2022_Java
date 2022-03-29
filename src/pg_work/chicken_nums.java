package pg_work;

public class chicken_nums {
    public static void main(String[] args) {
        int head = 36;
        int lap = 100;
        for(int i = 0;i < 100; i++) {
            for(int j = 0;j < 100; j++) {
                if(i * 2 + j * 4  == lap && i + j == head) {
                    System.out.println(i + "只兔子 和 " + j+"只鸡");
                    return;
                }
            }
        }
    }
}
