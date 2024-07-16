# Dependency Inversion Principle (DIP)

Dependency Inversion Principle (DIP) is one of the SOLID principles that aims to reduce the coupling between high-level modules and low-level modules. Instead of high-level modules depending directly on low-level modules, both should depend on abstractions.<br/>
Abstractions should not depend on details. Details should depend on abstractions.

## EXAMPLE SCENARIO

Assume a delivery company (DeliveryCompany) that needs to send products to customers. The actual delivery (i.e product) is handled by a delivery driver (DeliveryDriver).

### 1- Bad Practice

```Java
package dependency_inversion;

public class DeliveryCompany {
    // Tightly coupled:
    public void sendProduct(String product){
        DeliveryDriver driver = new DeliveryDriver();
        driver.deliverProduct(product);
    }
}
```

<br/>

```Java
package dependency_inversion;

public class DeliveryDriver {

    public void deliverProduct(String product) {
        System.out.println("deliverProduct ....");
    }
}
```

<br/>

In the above code, the DeliveryCompany class directly depends on the DeliveryDriver class. This tight coupling makes it difficult to change the delivery mechanism or to mock the delivery process for testing purposes.

### 2- Best Practice

**To apply the Dependency Inversion Principle, we will :**

-Define an abstraction for the delivery service (i.e interface). <br/>
-Make the DeliveryCompany depend on this abstraction. <br/>
-Implement the delivery service in a concrete class (DeliveryDriver). <br/>

**Step 1: Define an Abstraction**
<br/>

```Java
package dependency_inversion;

public interface IDeliveryService {
    void deliverProduct(String product);
}
```

**Step 2: Implement the Abstraction in the low level module**
<br/>

```Java
package dependency_inversion;

public class DeliveryDriver implements IDeliveryService{

  @Override
  public void deliverProduct(String product) {
    System.out.println("delivery driver is deliverign the "+ product);
  }
}
```

<br/>

**Step 3: Modify the High-Level Module**
<br/>
Make the DeliveryCompany depend on the IDeliveryService abstraction instead of the DeliveryDriver class. <br/>

```Java
package dependency_inversion;

public class DeliveryCompany {
    IDeliveryService deliveryService;

    public DeliveryCompany(IDeliveryService deliveryService){
        this.deliveryService = deliveryService;
    }
    public void sendProduct(String product){
        deliveryService.deliverProduct(product);
    }
}
``` 
<br/>

**Main App :**
```Java
public class App {
    public static void main(String[] args) throws Exception {
        IDeliveryService deliveryService = new DeliveryDriver();
        DeliveryCompany company = new DeliveryCompany(deliveryService);
        
        company.sendProduct("Parcel");
    }
}
```
<br/>

**Output :**
delivery driver is deliverign the Parcel

<br/>

By following the Dependency Inversion Principle, we have decoupled the high-level DeliveryCompany class from the low-level DeliveryDriver class, making the code more flexible and easier to maintain. This approach also makes it easier to test the DeliveryCompany class by mocking the DeliveryService interface.
