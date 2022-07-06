import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;

public class BookShelf implements Comparable<BookShelf> {
  private static final int MAX_NUM_OF_PAGES = 1500;
  private static final int MAX_NUM_OF_BOOKS = 5;

  private int shelfId;
  private ArrayList<Book> booksOnShelf;

  public BookShelf(int shelfID, ArrayList<Book> bookShelf) {
    this.shelfId = shelfID;
    this.booksOnShelf = bookShelf;
  }

  public int shelfId() {
    return this.shelfId;
  }

  private ArrayList<Book> booksOnShelf() {
    return this.booksOnShelf;
  }

  public void changeShelfId(int shelfId) {
    this.shelfId = shelfId;
  }

  private void changeBooksOnShelf(ArrayList<Book> booksOnShelf) {
    this.booksOnShelf = booksOnShelf;
  }

  public void addBook(Book newBook) throws FullBookShelfException {
    this.booksOnShelf.add(newBook);

    if (this.booksOnShelf.size() > 5 || this.countPagesOnShelf() > 1_500) {
      this.booksOnShelf.remove(newBook);
      throw new FullBookShelfException();
    }
  }

  public void deleteBook(String bookName) throws DeleteBookException {
    boolean result = this.booksOnShelf.removeIf(book -> book.getName().equals(bookName));

    if (!result) {
      throw new DeleteBookException();
    }
  }

  public int countBooks() {
    return this.booksOnShelf.size();
  }

  public int countPagesOnShelf() {
    int count = 0;

    for (Book book : booksOnShelf) {
      if (book instanceof MagazineBook) {
        count += ((MagazineBook) book).actualPageCount();
      } else {
        count += book.getPages();
      }
    }

    return count;
  }

  public void sort() {
    Collections.sort(this.booksOnShelf);
  }

  public void print() {
    for (Book book : this.booksOnShelf) {
      System.out.println(book);
    }
  }

  @Override
  public int compareTo(BookShelf toCompare) {
    int result;

    if ((this.booksOnShelf().isEmpty()) && (toCompare.booksOnShelf().isEmpty())) {
      result = 0;
    } else if (this.booksOnShelf().isEmpty()) {
      result = 1;
    } else if (toCompare.booksOnShelf().isEmpty()) {
      result = -1;
    } else {
      result = this.booksOnShelf().get(0).compareTo(toCompare.booksOnShelf().get(0));
    }

    return (result);
  }
}
