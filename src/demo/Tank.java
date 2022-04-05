package demo;

/**
 * @author liyajun
 * @date 2022/3/30 14:51
 */
class Tank {
    char c;
    static void f(Tank y) {
        y.c = 'z';
    }
    public static void main(String[] args) {
        Tank x = new Tank();
        x.c = 'a';
        System.out.println("1: x.c: " + x.c);
        f(x);
        System.out.println("2: x.c: " + x.c);
    }
}

