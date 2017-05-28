import java.util.*;
import java.io.*;

public class ElementWriter
{
  private PeriodicTable periodicTable;

  public ElementWriter(PeriodicTable periodicTable)
  {
    this.periodicTable = periodicTable;
  }

  public void writeToFile()
  {
    try
    {
      FileOutputStream outputStream = new FileOutputStream("output.txt");
      PrintWriter printWriter = new PrintWriter(outputStream);

      for (int rows = 0; rows < 10; rows++)
      {
        for (int columns = 0; columns < 10; columns++)
        {
          Element element = periodicTable.fetchAt(rows, columns);
          if (element != null)
          {
            printWriter.println(element.toString());
          }

        }
      }

      printWriter.close();
    }
    catch (IOException e)
    {
      System.out.println(e.getMessage());
    }
  }

}
