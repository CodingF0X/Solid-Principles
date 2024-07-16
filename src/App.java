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
