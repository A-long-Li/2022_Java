package experiment.five.InterfaceProject;

public class Fish extends Animal implements Pet{
    private String name;
    @Override
    void eat() {
        System.out.println("Fish likes eating bugs in the ponds");
    }

    public Fish() {
        super(0);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String n) {
        this.name = n;
    }

    @Override
    public void play() {
        System.out.println("fish likes swimming in yje ponds");
    }
    @Override
    public void walk(){
        super.walk();
        System.out.println("fish are swimming happily in the pool.");
    }
}
