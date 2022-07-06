import java.text.SimpleDateFormat;
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

  @Override
  public String toString() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    return String.format(
        "%s (science) - pub. %s, %dp., \u20AA%d",
        this.getName(), dateFormat.format(this.publishDate), this.getPages(), this.price);
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
