package experiment.two;

public class perfect_number {
    public static void main(String[] args){
        // write your code here
        for(int i = 1;i <= 1000; i++){
            if(i % 2 == 0 && valid(i)) {
                System.out.println(i);
            }
        }
    }
    static boolean valid(int x) {
        int cur = x;
        for(int i = 1; i <= x/2; i++) {
            if(x % i == 0) cur -= i;
        }
        return cur == 0;
    }
}
