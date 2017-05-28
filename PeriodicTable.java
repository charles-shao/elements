public class PeriodicTable
{
  private Element[][] elements;
  private int rows;
  private int columns;

  public PeriodicTable()
  {
    elements = new Element[10][10];
    rows = 0;
    columns = 0;
  }

  public void add(Element element)
  {
    System.out.println("Adding element...");
    elements[rows][columns] = element;
    incrementPointer();
  }

  public void printTable()
  {
    for (int i = 0; i < 10; i++)
    {
      for (int j = 0; j < 10; j++)
      {
        Element element = elements[i][j];
        if (element == null)
        {
          System.out.print(". \t");
        }
        else
        {
          System.out.print(element.getSymbol() + "\t");
        }
      }
      System.out.print("\n");
    }

  }

  // DEBUG tool
  public String currentPointer()
  {
    return String.format("%s, %s", rows, columns);
  }

  private void incrementPointer()
  {
    columns += 1;

    if (columns == 9) {
      columns = 0;
      rows += 1;

      if (rows == 9) {
        throw new IllegalArgumentException("you cannot have more than 100 elements");
      }
    }
  }

}
