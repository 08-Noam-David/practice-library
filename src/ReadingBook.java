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

  @Override
  public String toString() {
    return String.format(
        "%s (reading) - %s, %dp., \u20AA%d",
        this.getName(), this.author, this.getPages(), this.getPages());
  }
}
