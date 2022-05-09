package pg_test.work_1;

public class Narcissistic_num {
    static boolean check(int x)
    {
        int t = x;
        int sum = 0;
        while (t != 0)
        {
            sum += Math.pow(t%10,3);
            t/=10;
        }
        return x == sum;
    }
    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) {
            if(check(i)) System.out.println(i);
        }
    }
}
