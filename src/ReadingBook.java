public class ReadingBook extends Book {
  private String author;

  public ReadingBook(String name, String author, int pages) {
    super(name, pages);
    this.author = author;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  @Override
  public int getPrice() {
    return this.getPages() * 3;
  }
}
