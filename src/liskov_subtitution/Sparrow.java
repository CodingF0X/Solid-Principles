package liskov_subtitution;

public class Sparrow implements IBird, IFly {

    @Override
    public void eat() {
        System.out.println("Sparrow eats ...");
    }

    @Override
    public void fly() {
        System.out.println("Sparrow Flies ...");
    }
}
