package experiment.five.InterfaceProject;

public class TestAnimal {
    public static void main(String[] args) {
        Spider s1 = new Spider();
        s1.eat();
        Animal s2 = new Cat();
        System.out.println(s2.legs);
        s2.walk();
        s2.eat();
        Pet s3 = new Cat("fluffy");
        s3.getName();
        s3.play();
        Cat s4 = new Cat("Grafield");
        s4.getName();
        int legs = s4.legs;
        s4.eat();
        s4.walk();
        s4.play();
        Pet s5 = new Fish();
        s5.getName();
        Duck s6  = new Duck("donald duck");
        s6.shout("gagaga");
    }
}
