package liskov_subtitution;

public class Penguin implements IBird {

   @Override
   public void eat() {
       System.out.println("Penguin eats ...");
   }
}
