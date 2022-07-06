import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Library {
  public static final int NUM_OF_SHELVES = 10;

  private BookShelf[] libShelves;
  private String libraryName;

  public Library(String name, BookShelf[] bookShelves) {
    this.changeLibraryName(name);
    this.changeLibShelves(bookShelves);
  }

  public String libraryName() {
    return (this.libraryName);
  }

  public BookShelf[] libShelves() {
    return (this.libShelves);
  }

  public void changeLibraryName(String libraryName) {
    this.libraryName = libraryName;
  }

  public void changeLibShelves(BookShelf[] libShelves) {
    if (libShelves.length == Library.NUM_OF_SHELVES) {
      this.libShelves = libShelves;
    }
  }

  public int booksInLibrary() {
    int books = 0;

    for (BookShelf current : this.libShelves()) {
      books += current.countBooks();
    }

    return (books);
  }

  public int numOfPagesInLibrary() {
    int pages = 0;

    for (BookShelf current : this.libShelves()) {
      pages += current.countPagesOnShelf();
    }

    return (pages);
  }

  public void print() {
    for (BookShelf current : this.libShelves()) {

      if (current.countBooks() != 0) {
        System.out.println("Shelf number: " + (current.shelfId()));
        current.print();
      }
    }

    System.out.println();
  }

  public void addBook(int shelfID, Book newBook) {
    try {
      this.libShelves()[shelfID - 1].addBook(newBook);
    } catch (FullBookShelfException e) {
      throw new RuntimeException(e);
    }
  }

  public void addBook(Book newBook) throws FullBookShelfException {
    boolean isSecc = false;

    for (BookShelf current : this.libShelves()) {
      // TODO: Implement
      try {
        current.addBook(newBook);
        isSecc = true;
        break;
      } catch (FullBookShelfException ignored) {
      }
    }

    throw new FullBookShelfException();
  }

  public boolean deleteBook(int shelfID, String bookName) {
    try {
      this.libShelves()[shelfID - 1].deleteBook(bookName);

      return (true);
    } catch (DeleteBookException e) {
      return (false);
    }
  }

  public void deleteBook(String bookName) throws DeleteBookException {
    // TODO: Fix
    boolean isSecc = false;

    for (BookShelf current : this.libShelves()) {

      try {
        current.deleteBook(bookName);
        isSecc = true;
        break;
      } catch (DeleteBookException ignored) {
      }
    }

    throw new DeleteBookException();
  }

  public void sort() {
    for (BookShelf currBookShelf : this.libShelves()) {
      currBookShelf.sort();
    }

    Arrays.sort(this.libShelves());
  }
}
