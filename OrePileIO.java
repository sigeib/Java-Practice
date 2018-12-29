import java.util.*;
import java.io.*;
import java.lang.*;

public class OrePileIO
{
  public static void main(String[] args) {
    //Saving an OrePile
    Ore ore = new Ore('I',"kg");
    Orepile orePile = new Orepile(ore, 45.50, 70);
    savePile(orePile);
    System.out.println("Ore pile succesfully saved.");

    //Loading an OrePile
    Orepile pile;
    pile = loadPile();
    System.out.println(pile);
    System.out.println("Ore pile succesfully loaded.");
  }

  public static void savePile(Orepile orePile)
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter file name to save to: ");
    String fileName = sc.nextLine();

    FileOutputStream fileStream = null;
    ObjectOutputStream objectStream;

    try
    {
      fileStream = new FileOutputStream(fileName);
      objectStream = new ObjectOutputStream(fileStream);

      objectStream.writeObject(orePile);
      objectStream.close();
    } catch (Exception e)
    {
      System.out.println("Error writing object: " + e.getMessage());
    }
  }

  public static Orepile loadPile()
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter file name to load from: ");
    String fileName = sc.nextLine();
    FileInputStream fileStream = null;
    ObjectInputStream objectStream;
    Orepile orePile = new Orepile();

    try
    {
      fileStream = new FileInputStream(fileName);
      objectStream = new ObjectInputStream(fileStream);

      orePile = (Orepile)objectStream.readObject();
      objectStream.close();

    }catch (ClassNotFoundException e)
    {
      System.out.println("Class ContainerClassnot found: " + e.getMessage());
    }catch (Exception e)
    {
      System.out.println("Error writing object: " + e.getMessage());
    }

    return orePile;
  }
}
