public abstract class Book implements Comparable<Book> {
  private String name;
  private int pages;

  public Book(String name, int pages) {
    this.name = name;
    this.pages = pages;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPages() {
    return pages;
  }

  public void setPages(int pages) {
    this.pages = pages;
  }

  public abstract int getPrice();

  @Override
  public int compareTo(Book other) {
    return this.name.compareTo(other.name);
  }
}
