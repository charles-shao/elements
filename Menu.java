import java.util.*;

public class Menu
{

  private PeriodicTable periodicTable;

  public Menu(PeriodicTable periodicTable)
  {
    this.periodicTable = periodicTable;
  }

  public void run()
  {
    Scanner scanner = new Scanner(System.in);
    int optionPicked = 0;

    do
    {
      displayOptions();
      //  TODO: rescue InputMismatchException error
      optionPicked = scanner.nextInt();
      executeChoice(optionPicked);
    } while (optionPicked <= 0 || optionPicked > 0);
  }

  private void displayOptions() {
    System.out.println("Please enter your choice 1-5?");
    System.out.println(" 1. Read in a file to create the table");
    System.out.println(" 2. Add elements to the table");
    System.out.println(" 3. Display table");
    System.out.println(" 4. Write elements to file");
    System.out.println(" 5. Exit");
  }

  private void addElementPrompts() {
    Scanner scanner = new Scanner(System.in);
    String symbol, name;
    int atomicNum;
    double mass, conductivity;

    System.out.println(" 1. Element symbol?");
    symbol = scanner.nextLine();
    System.out.println(" 2. Element name?");
    name = scanner.nextLine();
    System.out.println(" 3. Element atomic number?");
    atomicNum = scanner.nextInt();
    System.out.println(" 4. Element mass?");
    mass = scanner.nextDouble();
    System.out.println(" 5. Element conductivity?");
    conductivity = scanner.nextDouble();

    Metal metal = new Metal(symbol, name, atomicNum, mass, conductivity);
    periodicTable.add(metal);
  }

  private void executeChoice(int choice)
  {
    switch (choice)
    {
      case 1:
        ElementReader elementReader = new ElementReader("elements_table.csv", periodicTable);
        elementReader.readToPeriodicTable();
        break;
      case 2:
        System.out.println("--- Adding new element ---");
        addElementPrompts();
        System.out.println("--- Added element to periodic table ---");
        break;
      case 3:
        System.out.println("--- Printing current table ---");
        periodicTable.printTable();
        break;
      case 4:
        System.out.println("--- Writing table to file ---");
        ElementWriter elementWriter = new ElementWriter(periodicTable);
        elementWriter.writeToFile();
        break;
      case 5:
        System.exit(0);
        break;
      default:
        System.out.println("Out of bounds option, exiting...");
        System.exit(0);
        break;
    }
  }


}
