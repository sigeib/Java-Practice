public class TestShipmentOrder
{
  public static void main(String[] args) {
    //Testing save method
    System.out.println("Testing valid data save");
    Ore ore = new Ore('I',"kg");
    ShipmentOrder order = new ShipmentOrder(ore, 25.00, "Brian",
     "Kenya", 50.00);
    order.save();
    System.out.println("Order has been saved. \n");

    //Testing load method
    System.out.println("Testing valid load file");
    ShipmentOrder order3 = new ShipmentOrder();
    order3.load();
    System.out.println(order3);
    System.out.println("Order has been succesfully loaded. \n");

  }
}
