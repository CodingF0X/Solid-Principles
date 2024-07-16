# Interface Segregation Principle (ISP)

The Interface Segregation Principle states that no client should be forced to depend on methods it does not use. This means that instead of having one large, general-purpose interface, we should have multiple smaller, more specific interfaces. This allows clients (i.e classes) to only implement the functionality they actually need.

## Example Scenario

Let's consider a scenario involving different types of workers. Some workers are paid hourly, some are paid a fixed salary, and some are both paid and evaluated based on performance.

### 1- Example of using single interface( incorrect approach ):

**IWorker interface**

```Java
package interface_segregation;

public interface IWorker {
    void work();
    double getHourlyRate();
    double calculatePay(int hoursWorked);
    double getSalary();
    void evaluatePerformance();
}
```

**Hourly Worker Class** 

<br/>

```Java
package interface_segregation;

public class HourlyWorker implements Iworker {

    @Override
    public void work() {
        System.out.println("HourlyWorker is working");
    }

    @Override
    public double getHourlyRate() {
        return 14.0;
    }

    @Override
    public double calculatePay(int hoursWorked) {
        return hoursWorked * getHourlyRate();
    }

    @Override
    public double getSalary() {
        throw new UnsupportedOperationException("Hourly worker dont get salary !");
    }

    @Override
    public void evaluatePerformance() {
        throw new UnsupportedOperationException("Hourly worker dont get evaluated !");
    }
}
```

**Salary Worker Class**

<br/>

```Java
package interface_segregation;

public class SalaryWorker implements Iworker {

    @Override
    public void work() {
        System.out.println("Salary worker is worker ");
    }

    @Override
    public double getHourlyRate() {
        throw new UnsupportedOperationException(" This worker dont get paid by hours !");
    }

    @Override
    public double calculatePay(int hoursWorked) {
        throw new UnsupportedOperationException(" This worker dont get paid by hours !");

    }

    @Override
    public double getSalary() {
        return 3700.0;
    }

    @Override
    public void evaluatePerformance() {
        System.out.println("Evaluating performance ...");
    }
}

```
<br/>
In this incorrect example, both HourlyWorker and SalariedWorker are forced to implement methods they do not use, violating the Interface Segregation Principle.

### 2- Example of using single interface( Correct Approach ):
We create seperate interface for each functionality and as follows: <br/>

**IWorker Interface**
```Java
package interface_segregation;

public interface Iworker {
    public void work();
}
```
<br/>

**IHourlyPaid Interface**
```Java
package interface_segregation;

public interface IHourlyPaid extends Iworker {
    double getHourlyRate();
    double calculatePay(int hoursWorked);
}
```
<br/>

**ISalaryPaid Inteface**
```Java
package interface_segregation;

public interface ISalaryPaid extends Iworker {
    double getSalary();
    void evaluatePerformance();
}
```
<br/>

Now each class implements the interface that provides the relevant functions. <br/>

**Horly Worker Class**

```Java
package interface_segregation;

public class HourlyWorker implements IHourlyPaid {

    @Override
    public void work() {
        System.out.println("HourlyWorker is working");
    }

    @Override
    public double getHourlyRate() {
        return 14.0;
    }

    @Override
    public double calculatePay(int hoursWorked) {
        return hoursWorked * getHourlyRate();
    }

}
```
<br/>

**Salary Worker Class**
```Java
package interface_segregation;

public class SalaryWorker implements ISalaryPaid {

    @Override
    public void work() {
        System.out.println("Salary worker is worker ");
    }
    

    @Override
    public double getSalary() {
        return 3700.0;
    }

    @Override
    public void evaluatePerformance() {
        System.out.println("Evaluating performance ...");
    }
}
```

**Main app**
```Java
import interface_segregation.HourlyWorker;
import interface_segregation.IHourlyPaid;
import interface_segregation.ISalaryPaid;
import interface_segregation.SalaryWorker;


public class App {
    public static void main(String[] args) throws Exception {
        ISalaryPaid salWorker = new SalaryWorker();
        IHourlyPaid hourWorker = new HourlyWorker();

        salWorker.work();
        salWorker.evaluatePerformance();
        System.out.println(salWorker.getSalary());

        System.out.println("------------");
        
        hourWorker.work();
        System.out.println(hourWorker.calculatePay(8));
        System.out.println(hourWorker.getHourlyRate());
    }
}
```

<br/>

By using multiple smaller interfaces, we ensure that each class only implements methods it actually needs, adhering to the Interface Segregation Principle.
