public class FullBookShelfException extends Exception {
  public FullBookShelfException() {
    super(
        "Full book shelf: The shelf can contain a maximum of five  or a total page count fo 1,500.");
  }
}
