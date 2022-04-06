public interface Command {
  public int execute(int counter);
  public int unexecute(int counter);
}