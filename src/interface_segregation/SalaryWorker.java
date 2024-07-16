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
