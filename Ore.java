import java.io.*;

public class Ore implements Serializable
{
    private static final char ORETYPE_IRON = 'I';
    private static final char ORETYPE_NICKEL = 'N';

    private static final String UNIT_TONNES = "t";
    private static final String UNIT_KILOGRAMS = "kg";
    private static final String UNIT_GRAMS = "g";

    private char oreType;
    private String units;

    public Ore()
    {
        oreType = ' ';
        units = new String();
    }

    public Ore(char newOreType, String newUnits)
    {
        if (newOreType != Ore.ORETYPE_IRON && newOreType != Ore.ORETYPE_NICKEL)
            throw new IllegalArgumentException("Illegal ore type provided.");

        oreType = newOreType;
        setUnits(newUnits);
    }

    public Ore(Ore newOre)
    {
        oreType = newOre.getOreType();
        units = newOre.getUnits();
    }

    public char getOreType()
    {
        return oreType;
    }

    public String getUnits()
    {
        return units;
    }

    public void setUnits(String newUnits)
    {
        if (newUnits == null || newUnits.equals(""))
            throw new IllegalArgumentException("Units must not be blank");
        if (!newUnits.equals(Ore.UNIT_TONNES) && !newUnits.equals(Ore.UNIT_KILOGRAMS) && !newUnits.equals(Ore.UNIT_GRAMS))
            throw new IllegalArgumentException("Invalid unit type: " + newUnits);

        units = newUnits;
    }

    public String toString ()
    {
      String oreString = (" oreType: " + oreType + " Units: " + units);
      return oreString;
    }

    public void write(FileOutputStream fileStream)
    {
      DataOutputStream dataStream = new DataOutputStream(fileStream);
      try
      {
        dataStream.writeChar(oreType);
        dataStream.writeUTF(units);
      } catch (IOException e)
      {
        if (fileStream == null)
        {
          try {fileStream.close(); } catch (IOException ex2) { }
        }
        System.out.println("Error writing file: " + e.getMessage());
      }
    }
}
