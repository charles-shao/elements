public abstract class Element
{
  private String symbol;
  private String name;
  private int atomicNum;
  private double mass;

  public Element(String symbol, String name, int atomicNum, double mass)
  {
    this.symbol = symbol;
    this.name = name;
    this.atomicNum = atomicNum;
    this.mass = mass;
  }

  public String getSymbol()
  {
    return symbol;
  }

  public String toString()
  {
    return String.format("%s,%s,%s,%s", symbol, name, atomicNum, mass);
  }

}
