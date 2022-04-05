public class text11 {
    public static void main(String[] args) {
        for (int i = 0; i < 26; i++) {
            int c = i + 'a';
            System.out.print((char)c + ", " + c + ": ");
            switch (c) {
                case 'a' :
                case 'e' :
                case 'i' :
                case 'o' :
                case 'u' : System.out.println("vowel");
                    break;
                case 'y' :
                case 'w' : System.out.println("Sometimes a vowel");
                    break;
                default: System.out.println("consonant");
            }
        }
    }
}