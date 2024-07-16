package dependency_inversion;

public class DeliveryDriver implements IDeliveryService{

  @Override
  public void deliverProduct(String product) {
    System.out.println("delivery driver is deliverign the "+ product);
  }
}
