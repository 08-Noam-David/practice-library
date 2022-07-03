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
    // TODO:
  }

  public int shelfId() {
    // TODO:
  }

  private ArrayList<Book> booksOnShelf() {
    // TODO:
  }

  public void changeShelfId(int shelfId) {
    // TODO:
  }

  private void changeBooksOnShelf(ArrayList<Book> booksOnShelf) {
    // TODO:
  }

  public void addBook(Book newBook) {
    // TODO:
  }

  public void deleteBook(String bookName) {
    // TODO:
  }

  public int countBooks() {
    // TODO:
  }

  public int countPagesOnShelf() {
    // TODO:
  }

  public void sort() {
    // TODO:
  }

  public void print() {
    // TODO:
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
