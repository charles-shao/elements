public final class NonMetal extends Element
{
  private char state;

  public NonMetal(String symbol, String name, int atomicNum, double mass, char state)
  {
    super(symbol, name, atomicNum, mass);
    this.state = state;
  }

  public String toString()
  {
    return String.format("<%s,%s/>", super.toString(), state);
  }
}
