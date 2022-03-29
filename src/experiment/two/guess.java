package experiment.two;

import java.util.Random;
import java.util.Scanner;

public class guess {
    public void guess(){
        Random ra = new Random();
        int cur = ra.nextInt(100) + 1;
        System.out.println("please enter a num");
        Scanner sc = new Scanner(System.in);
        int get = sc.nextInt();
        while(get != cur){
            if(get > cur) System.out.println("Try a smaller number");
            else if(get < cur) System.out.println("Try a larger number");
            get = sc.nextInt();
        }
        System.out.println("congratulations");
    }
}
