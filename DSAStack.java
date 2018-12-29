public class DSAStack
{
  private Orepile [] orePiles;
  private int numberOfPiles;
  private final int DEFAULT_CAPACITY = 50;

  //default constr
  public DSAStack()
  {
    orePiles = new Orepile[DEFAULT_CAPACITY] ;
    numberOfPiles = 0;
  }

  public DSAStack(int maxCapacity)
  {
    if (maxCapacity == 0)
      throw new IllegalArgumentException("Invalid capacity");

    orePiles = new Orepile[maxCapacity] ;
    numberOfPiles = 0;
  }

  public int getNumberOfPiles()
  {
    return numberOfPiles;
  }

  public boolean isEmpty()
  {
    boolean empty = false;
    if (numberOfPiles == 0)
    {
      empty = true;
    }
    return empty;
  }

  public boolean isFull()
  {
    boolean full = false;
    if (numberOfPiles == orePiles.length)
    {
      full = true;
    }
    return full;
  }

  public void push(Orepile newOrePile)
  {
    if (isFull())
    {
      throw new IllegalArgumentException("Shed is full!");
    } else
    {
      orePiles[numberOfPiles] = newOrePile;
      numberOfPiles++;
    }
  }

  public Orepile pop()
  {
    Orepile topPile = top();
    numberOfPiles--;
    return topPile;
  }

  public Orepile top()
  {
    Orepile topPile = new Orepile();
    if (isEmpty())
    {
      throw new IllegalArgumentException("The shed is empty");
    } else
    {
      topPile = orePiles[numberOfPiles - 1] ;
    }
    return topPile;
  }
}
