import java.util.Date;

public class ScienceBook extends Book {
  private int price;
  private Date publishDate;

  public ScienceBook(String name, int pages, int price, Date publishDate) {
    super(name, pages);
    this.price = price;
    this.publishDate = publishDate;
  }

  @Override
  public int getPrice() {
    return this.price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public Date getPublishDate() {
    return publishDate;
  }

  public void setPublishDate(Date publishDate) {
    this.publishDate = publishDate;
  }
}
