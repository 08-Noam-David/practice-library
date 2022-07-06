public class MagazineBook extends Book {
  private int price;
  private String author;

  public MagazineBook(String name, String author, int pages, int price) {
    super(name, pages);
    this.author = author;
    this.price = price;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  @Override
  public int getPrice() {
    return this.price;
  }

  @Override
  public String toString() {
    return String.format(
        "%s (magazine) - %s, %dp., \u20AA%d",
        this.getName(), this.author, this.actualPageCount(), this.price);
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int actualPageCount() {
    return this.getPages() * 2;
  }
}
