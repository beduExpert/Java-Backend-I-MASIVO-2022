public class MultiplyBy2Command implements Command {

  public int execute(int counter) {
    return counter * 2;
  }

  public int unexecute(int counter) {
    return counter / 2;
  }
}