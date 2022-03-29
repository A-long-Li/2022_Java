package experiment.five.InterfaceProject;

public class Cat extends Animal implements Pet{
    private String name;
    public Cat(String name){
        super(4);
        this.name = name;
    }
    public Cat(){
        this("");
    }
    @Override
    void eat() {
        System.out.println("Cat likes eating mice.");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String n) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println("Cat likes playing strings.");
    }
}
