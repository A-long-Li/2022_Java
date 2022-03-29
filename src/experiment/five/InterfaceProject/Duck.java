package experiment.five.InterfaceProject;

public class Duck extends Animal implements Pet,Sound{
    private String name;

    public Duck( String name) {
        super(2);
        this.name = name;
    }

    @Override
    public void walk() {
        System.out.println("duck swim and walks with"+legs+"legs");
    }

    @Override
    void eat() {
        System.out.println("duck like eating waterweeds");
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
        System.out.println("duck likes playing with water");
    }
    public void shout(String voice){
        Sound.super.shout(voice);
        System.out.println("i am a yellow duck");
    }
}
