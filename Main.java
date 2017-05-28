import java.util.*;

public class Main
{
  public static void main(String[] args)
  {
    System.out.println("It's starting boys");

    PeriodicTable periodicTable = new PeriodicTable();
    Menu menu = new Menu(periodicTable);

    menu.run();
  }
}
