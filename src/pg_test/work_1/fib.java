package pg_test.work_1;

import java.util.Scanner;

public class fib {
    static int fib(int n)
    {
        if(n == 1 || n == 0) return n;
        return fib(n-1) + fib(n-2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fib(n));
    }
}
