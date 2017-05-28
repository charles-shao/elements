import java.util.*;

public class Main
{
  public static void main(String[] args)
  {
    System.out.println("It's starting boys");

    PeriodicTable peroidicTable = new PeriodicTable();
    Menu menu = new Menu(peroidicTable);

    menu.run();
  }
}
