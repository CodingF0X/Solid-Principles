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
