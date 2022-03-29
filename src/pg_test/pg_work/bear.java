package pg_test.pg_work;

public class bear {
    public static void main(String[] args) {
        int sum = 1543;
        int ans = 0;
        while (sum >= 1)
        {
            if(sum % 2 == 0) sum /= 2;
            else {
                sum /= 2;
                ans++;
            }
        }
        System.out.println(ans);
    }
}
