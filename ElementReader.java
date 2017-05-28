import java.util.*;
import java.io.*;

public class ElementReader
{
  private String filename;
  private PeriodicTable periodicTable;

  private FileInputStream inputStream;
  private InputStreamReader reader;
  private BufferedReader bufferedReader;

  public ElementReader(String filename, PeriodicTable periodicTable) {
    this.filename = filename;
    this.periodicTable = periodicTable;

    try
    {
      inputStream = new FileInputStream(filename);
      reader = new InputStreamReader(inputStream);
      bufferedReader = new BufferedReader(reader);
    }
    catch(IOException e)
    {
      System.out.println(e.getMessage());
    }
  }

  public void readToPeriodicTable() {
    String line;

    try
    {
      do {
        line = bufferedReader.readLine();
        if (line != null) {
          System.out.println(line);
          convertToElement(line);
        }
      } while (line != null);
    }
    catch(IOException e)
    {
      System.out.println(e.getMessage());
    }
  }

  private void convertToElement(String line) {
    String[] elements = line.split("/>");

    for(int i = 0; i < elements.length; i++)
    {
      String element = elements[i];
      element = element.replace("<", "");

      String[] tokens = element.split(",");

      String symbol = tokens[0];
      String name = tokens[1];
      int atomicNum = Integer.parseInt(tokens[2]);
      double mass = Double.parseDouble(tokens[3]);

      // Non metal
      if (tokens[4].charAt(0) == 'S' || tokens[4].charAt(0) == 'L' || tokens[4].charAt(0) == 'G')
      {
        char state = tokens[4].charAt(0);
        periodicTable.add(new NonMetal(symbol, name, atomicNum, mass, state));
      }
      else
      {
        double conductivity = Double.parseDouble(tokens[4]);
        periodicTable.add(new Metal(symbol, name, atomicNum, mass, conductivity));
      }

      // System.out.println(periodicTable.currentPointer());
    }
  }

}
