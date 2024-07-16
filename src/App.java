import open_closed.DrawShape;
import open_closed.Rectangle;
import open_closed.Square;
import open_closed.Triangle;

public class App {
    public static void main(String[] args) throws Exception {
        Rectangle rectangle = new Rectangle();
        Triangle triangle = new Triangle();
        Square square = new Square();
        DrawShape shape = new DrawShape();
        shape.draw_Shape(square);
    }
}
