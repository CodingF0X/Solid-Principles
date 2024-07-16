import liskov_subtitution.IBird;
import liskov_subtitution.IFly;
import liskov_subtitution.Penguin;
import liskov_subtitution.Sparrow;

public class App {
    public static void main(String[] args) throws Exception {
        IBird sparrow = new Sparrow();
        IBird penguin = new Penguin();
        
        IFly flyableSparrow = new Sparrow();

        sparrow.eat();
        penguin.eat();
        System.out.println("--------");
        flyableSparrow.fly();
        

    }
}
