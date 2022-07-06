public class DeleteBookException extends Exception {
  public DeleteBookException() {
    super("Book deletion error: Book wasn't found.");
  }
}
