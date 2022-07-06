public class ScienceBook extends Book {
  private int price;
  private String author;

  public ScienceBook(String name, String author, int pages, int price) {
    super(name, pages);
    this.author = author;
    this.price = price;
  }

  @Override
  public int getPrice() {
    return this.price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }
}
