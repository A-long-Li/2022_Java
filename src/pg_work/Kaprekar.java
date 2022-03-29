package pg_work;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Kaprekar {

    static int change(int n)
    {
        int [] cnt = new int[10];
        int [] arr  = new int[4];
        int [] op = new int[4];
        int ans = 0;
        int idx = 0;
        while(n != 0) {
            arr[idx++] = n % 10;
            cnt[n%10]++;
            n /= 10;
        }
        for (int i : cnt) {
            if(i == 4){
                System.out.println("N - N = 0");
                return 0;
            }
        }
        Arrays.sort(arr);
        for (int i = 0; i <= 3; i++) {
            System.out.print(arr[3-i]);
            ans = ans * 10 + arr[3-i];
        }
        System.out.print(" - ");
        int last = 0;
        for (int i = 0; i <= 3; i++) {
            System.out.print(arr[i]);
            last = last * 10 + arr[i];
        }
        ans -= last;
        last = ans;
        idx = 0;
        while (last != 0) {
            op[idx++] = last % 10;
            last /= 10;
        }
        System.out.print(" = ");
        for (int i = 0; i <= 3; i++) {
            System.out.print(op[3-i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n != 6174 && n != 0)
        {
            n = change(n);
            System.out.println("");
        }
    }
}
