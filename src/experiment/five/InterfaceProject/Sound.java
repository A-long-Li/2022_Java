package experiment.five.InterfaceProject;

public interface Sound {
    public default void shout(String voice){
        System.out.println(voice);
    }
}
