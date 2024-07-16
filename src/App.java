import dependency_inversion.DeliveryCompany;
import dependency_inversion.DeliveryDriver;
import dependency_inversion.IDeliveryService;

public class App {
    public static void main(String[] args) throws Exception {
        IDeliveryService deliveryService = new DeliveryDriver();
        DeliveryCompany company = new DeliveryCompany(deliveryService);
        
        company.sendProduct("Parcel");
    }
}
