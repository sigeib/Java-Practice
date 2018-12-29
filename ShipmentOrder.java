import java.io.*;
import java.util.*;

public class ShipmentOrder
{
    private int orderID;
    private static int nextOrderID = 1;
    private Ore ore;
    private double unitPrice;
    private String customerName;
    private String shippingDest;
    private double orderedMetalWt;
    private double shippedOreWt;
    private boolean isPending;

    public ShipmentOrder()
    {
      orderID = nextOrderID;
      nextOrderID ++;
      this.ore = new Ore();
      this.unitPrice = 0.00;
      setCustomerName("unspecified");
      setShippingDest("unspecified");
      this.orderedMetalWt = 0.00;
      isPending = true;
    }

    public ShipmentOrder(Ore ore, double unitPrice, String newCustomerName, String newShippingDest, double orderedMetalWt)
    {
        orderID = nextOrderID;
        nextOrderID ++;
	    	this.ore = ore;
        this.unitPrice = unitPrice;
        setCustomerName(newCustomerName);
        setShippingDest(newShippingDest);
        this.orderedMetalWt = orderedMetalWt;
        isPending = true;

    }


	private int getnextOrderID()
	{
		return nextOrderID;
	}
	private int getOrderID()
	{
		return orderID;
	}
	private Ore getOre()
	{
		return ore;
	}
	private double getUnitPrice()
	{
		return unitPrice;
	}
	private String getCustomerName()
	{
		return customerName;
	}
	private String getShippingDest()
	{
		return shippingDest;
	}
	private double getorderedMetalWt()
	{
		return orderedMetalWt;
	}
	private double getShippedOreWt()
	{
    if (isPending == true)
      throw new IllegalArgumentException("Shipment is pending");
		return shippedOreWt;
	}
	private boolean getIsPending()
	{
		return isPending;
	}


    public static void setNextOrderID(int nextOrderID)
    {
        ShipmentOrder.nextOrderID = nextOrderID;
    }

    public void setUnitPrice(double unitPrice)
    {
        this.unitPrice = unitPrice;
    }

    public void setCustomerName(String customerName)
    {
        if (customerName == null || customerName.equals(""))
            throw new IllegalArgumentException("Invalid customer name");
        this.customerName = customerName;
    }

    public void setShippingDest(String shippingDest)
    {
      if (shippingDest == null || shippingDest.equals(""))
          throw new IllegalArgumentException("Invalid shipping destination");
        this.shippingDest = shippingDest;
    }

    public void setorderedMetalWt(double orderedMetalWt)
    {
        this.orderedMetalWt = orderedMetalWt;
    }

    public void setShippedOreWt(double shippedOreWt)
    {
        this.shippedOreWt = shippedOreWt;
        isPending = false;
    }

    public String toString()
    {
      String order = ("orderID: " + orderID + " ore: " + ore +" unitPrice: " + unitPrice + " CustomerName: " + customerName +
        " ShippingDest: " + shippingDest + " orderedMetalWt: " + orderedMetalWt + " isPending: " + isPending);
      return order;
    }
    public double shipmentValue()
    {
        double value = 0;
        value = orderedMetalWt * unitPrice;
        return value;
    }

    public double calcAverageGrade()
    {
      if (isPending == true)
        throw new IllegalArgumentException("No ore has been shipped to calculate the grade");

      double average = orderedMetalWt / shippedOreWt * 100;
      return average;
    }

    public void save()
    {
      Scanner sc = new Scanner(System.in);
      System.out.println("Please enter file to save to.");
      String fileName = sc.nextLine();
      FileOutputStream fileStream = null;
      DataOutputStream dataStream;

      try
      {
        fileStream = new FileOutputStream(fileName);
        dataStream = new DataOutputStream(fileStream);

        dataStream.writeInt(orderID);
        ore.write(fileStream);
        dataStream.writeDouble(unitPrice);
        dataStream.writeUTF(customerName);
        dataStream.writeUTF(shippingDest);
        dataStream.writeDouble(orderedMetalWt);
        dataStream.writeBoolean(isPending);

        fileStream.close();
      } catch (IOException e)
      {
        if (fileStream != null)
        {
          try {fileStream.close(); } catch (IOException ex2) { }
        }
        System.out.println("Error in saving to file: " + e.getMessage());
      }
    }

    public void load()
    {
      Scanner sc = new Scanner(System.in);
      System.out.println("Please enter file to load from");
      String fileName = sc.nextLine();

      FileInputStream fileStream = null;
      DataInputStream dataStream;

      try
      {
        fileStream = new FileInputStream(fileName);
        dataStream = new DataInputStream(fileStream);

        orderID = dataStream.readInt();
	    	this.ore = new Ore(dataStream.readChar(), dataStream.readUTF());
        this.unitPrice = dataStream.readDouble();
        customerName = dataStream.readUTF();
        shippingDest = dataStream.readUTF();
        this.orderedMetalWt = dataStream.readDouble();
        isPending = dataStream.readBoolean();

        fileStream.close();
      } catch (IOException e)
      {
        if (fileStream == null)
        {
          try {fileStream.close(); } catch (IOException ex2) { }
        }
        System.out.println("Error loading file: " + e.getMessage());
      }
    }
}
