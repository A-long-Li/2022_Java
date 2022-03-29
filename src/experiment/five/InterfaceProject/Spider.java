package experiment.five.InterfaceProject;

public class Spider extends Animal{
    public Spider(){
        super(8);
    }

    @Override
    void eat() {
        System.out.println("Spider eats flying on the net");
    }
}
