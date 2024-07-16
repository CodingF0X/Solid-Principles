package dependency_inversion;

public class DeliveryCompany {
    IDeliveryService deliveryService;
    // Dependecy injection :
    public DeliveryCompany(IDeliveryService deliveryService){
        this.deliveryService = deliveryService;
    }
    // Dependecy inversion :
    public void sendProduct(String product){
        deliveryService.deliverProduct(product);
    }
}
