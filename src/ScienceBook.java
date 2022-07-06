public class ScienceBook extends Book {
  private int price;

  public ScienceBook(String name, int pages, int price) {
    super(name, pages);
    this.price = price;
  }

  @Override
  public int getPrice() {
    return this.price;
  }

  public void setPrice(int price) {
    this.price = price;
  }
}
