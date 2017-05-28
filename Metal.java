public final class Metal extends Element
{
  private double conductivity;

  public Metal(String symbol, String name, int atomicNum, double mass, double conductivity)
  {
    super(symbol, name, atomicNum, mass);
    this.conductivity = conductivity;
  }

  public String toString()
  {
    return String.format("<%s,%s/>", super.toString(), conductivity);
  }
}
