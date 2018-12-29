public class TestADT
{
  public static void main(String[] args) {
    //Testing stack
    Ore ore = new Ore('I', "kg");
    Orepile orePileA = new Orepile(ore, 15.0, 65.0);
    Orepile orePileB = new Orepile(ore, 45.0, 70.0);
    Orepile orePileC = new Orepile(ore, 30.0, 95.0);
    DSAStack shedIron = new DSAStack(10);
    System.out.println("Testing push...");
    shedIron.push(orePileA);
    shedIron.push(orePileB);
    shedIron.push(orePileC);
    System.out.println("Push successfull. \n");

    System.out.println("Testing pop...");
    Orepile pile = shedIron.pop();
    System.out.println(pile);
    System.out.println("Pop successfull...\n");

    //Testing Queue
    Ore ore1 = new Ore('N', "t");
    Orepile orePile1 = new Orepile(ore1, 17.5, 91.0);
    Orepile orePile2 = new Orepile(ore1, 22.5, 70.0);
    Orepile orePile3 = new Orepile(ore1, 50.0, 40.0);
    DSAQueue shedNickel = new DSAQueue(5);
    System.out.println("Testing enqueue...");
    shedNickel.enqueue(orePile1);
    shedNickel.enqueue(orePile2);
    shedNickel.enqueue(orePile3);
    System.out.println("Enqueue successfull. \n");

    System.out.println("Testing dequeue...");
    Orepile pile2 = shedNickel.dequeue();
    System.out.println(pile2);
    System.out.println("Dequeue successfull. \n");
  }
}
