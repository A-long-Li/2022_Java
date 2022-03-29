package experiment.two;

public class Palindrome_number {
    boolean valid(int i) {
        String s = Integer.toString(i);
        int l = 0,r = s.length() - 1;
        while(l < r) {
            if(s.toCharArray()[l++] != s.toCharArray()[r--]) return false;
        }
        return true;
    }

}
