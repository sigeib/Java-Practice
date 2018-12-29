import java.io.*;

public class Orepile implements Serializable
{
    private Ore ore;
    private double weight;
    private double grade;

    public Orepile()
    {
      ore = new Ore();
      weight = 0.00;
      grade = 0.00;
    }
    public Orepile(Ore newOre, double newWeight, double newGrade)
    {
        if (newWeight < 0)
            throw new IllegalArgumentException("Invalid ore weight");
        ore = newOre;
        weight = newWeight;
        grade = newGrade;
    }

    public Orepile(Orepile newOrePile)
    {
        ore = newOrePile.getOre();
        weight = newOrePile.getWeight();
        grade = newOrePile.getGrade();
    }

    public Ore getOre()
    {
        return ore;
    }

    public double getWeight()
    {
        return weight;
    }

    public double getGrade()
    {
        return grade;
    }

    public void setGrade(double newGrade)
    {
        if (newGrade < 0 || newGrade > 100)
            throw new IllegalArgumentException("Invalid grade");
        grade = newGrade;
    }

    public String toString()
    {
      String pile = ("Ore(" + ore + ") Weight: " + weight + " Grade: " + grade);
      return pile;
    }

    public double calcMetalWeight()
    {
        double metalWeight = 0;
        metalWeight = weight * grade;
        return metalWeight;
    }
}
