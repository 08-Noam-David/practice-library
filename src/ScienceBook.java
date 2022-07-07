import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ScienceBook extends Book {
  private int price;
  private LocalDate publishDate;

  public ScienceBook(String name, int pages, int price, LocalDate publishDate) {
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
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return String.format(
        "%s (science) - pub. %s, %dp., \u20AA%d",
        this.getName(), dateFormat.format(this.publishDate), this.getPages(), this.price);
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public LocalDate getPublishDate() {
    return publishDate;
  }

  public void setPublishDate(LocalDate publishDate) {
    this.publishDate = publishDate;
  }
}
