package interface_segregation;

public interface IHourlyPaid extends Iworker {
    double getHourlyRate();
    double calculatePay(int hoursWorked);
}
