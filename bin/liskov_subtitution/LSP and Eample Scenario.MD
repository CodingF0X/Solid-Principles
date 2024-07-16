# Liskov Substitution Principle (LSP)
<br/>
### The Liskov Substitution Principle states that objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program. Essentially, if class B is a subclass of class A, then objects of type A should be able to be replaced with objects of type B without altering the desirable properties of the program (e.g., correctness, task performed).
 

# EXAMPLE SCENARIO
<br/>
Suppose we have a base interface Bird with a method fly(). 
We want to create a hierarchy where some birds can fly and others cannot.
We will demonstrate the correct and incorrect ways to handle this with respect to LSP. <br/>
Say we have two birds, Sparrow and Penguin. Obviuously Sparrow Flies, while Penguin don't.
Both implement IBird interface. However, Penguin Can't fly!. Thus we need to throw an exception when penguin invokes the fly() method.

## Example of Penguin implementin IBird( incorrect approach ) : 
<br/>

```Java
package liskov_subtitution;

public interface IBird {

    public void fly();
}
```

### Sparrow Class
```Java
package liskov_substitution;

public class Sparrow implements Bird {
    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}
```
<br/>

### Penguin Class
```Java
package liskov_substitution;

public class Penguin implements IBird {
    @Override
    public void fly() {
        // Penguins cannot fly, but this class forces them to implement fly
        throw new UnsupportedOperationException("Penguins cannot fly");
    }
}
```
<br/>

### in Main App:  
<br/>

```Java
 package liskov_substitution;

public class App {
    public static void main(String[] args) {
        IBird sparrow = new Sparrow();
        IBird penguin = new Penguin();

        sparrow.fly(); // Works fine
        penguin.fly(); // Throws an exception
    }
}
```
<br/>

In this example, substituting a Penguin where a Bird is expected causes problems, because Penguin cannot fly. This violates LSP.

## Correct approach
<br/>
We create two different interfaces. One for birds birds without specifying whether they fly or not. And one for flying birds only.

```Java
package liskov_substitution;

public interface IBird {
    void eat();
}
```

```Java
package liskov_substitution;

public interface IFlyable {
    void fly();
}
```

### Sparrow Class

```Java
package liskov_substitution;

public class Sparrow implements IBird, IFlyable {
    @Override
    public void eat() {
        System.out.println("Sparrow is eating");
    }

    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}
```

### Penguin Class
```Java
package liskov_substitution;

public class Penguin implements IBird {
    @Override
    public void eat() {
        System.out.println("Penguin is eating");
    }
}
```

### Main app:
```Java
package liskov_substitution;

public class App {
    public static void main(String[] args) {
        IBird sparrow = new Sparrow();
        IBird penguin = new Penguin();

        sparrow.eat(); // Works fine
        penguin.eat(); // Works fine

        Flyable flyableSparrow = new Sparrow();
        flyableSparrow.fly(); // Works fine

        // Penguin does not implement Flyable, so it cannot be assigned to Flyable type
        // Flyable flyablePenguin = new Penguin();
        // This leads to Compile-time error
    }
}

```

In this approach, birds that fly, can implement both interfaces. While birds that can't fly, then they only implement IBird which has the common behaviuor amongst all birds which is eating. Thus both objects adhered to LSP.
