import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static Book getBookFromUser() {
    Scanner scanner = new Scanner(System.in);

    final int SCIENCE = 1;
    final int MAGAZINE = 2;
    final int READING = 3;

    Book bookToReturn = null;

    System.out.println("What is the type of the book?");
    System.out.println(SCIENCE + " - science book");
    System.out.println(MAGAZINE + " - magazine");
    System.out.println(READING + " - reading");

    int choice = Integer.parseInt(scanner.nextLine());

    String name, author;
    int pages, price;

    switch (choice) {
      case (SCIENCE) -> {
        System.out.println("Enter the book's name:");
        name = scanner.nextLine();

        System.out.println("Enter the amount of page the book has:");
        pages = scanner.nextInt();

        System.out.println("Enter the book's price (\u20AA):");
        price = scanner.nextInt();

        System.out.println("Enter the publication year of the book:");
        int year = scanner.nextInt();

        System.out.println("Enter the publication month, as a number:");
        int month = scanner.nextInt();

        System.out.println("Enter the publication day, as a number:");
        int day = scanner.nextInt();

        LocalDate publishDate = LocalDate.of(year, month, day);

        bookToReturn = new ScienceBook(name, pages, price, publishDate);
      }
      case (MAGAZINE) -> {
        System.out.println("Enter the book's name:");
        name = scanner.nextLine();

        System.out.println("Enter the book's author:");
        author = scanner.nextLine();

        System.out.println("Enter the amount of page the book has:");
        pages = scanner.nextInt();

        System.out.println("Enter the book's price (\u20AA):");
        price = scanner.nextInt();

        bookToReturn = new MagazineBook(name, author, pages, price);
      }
      case (READING) -> {
        System.out.println("Enter the book's name:");
        name = scanner.nextLine();

        System.out.println("Enter the book's author:");
        author = scanner.nextLine();

        System.out.println("Enter the amount of page the book has:");
        pages = scanner.nextInt();

        bookToReturn = new ReadingBook(name, author, pages);
      }
      default -> System.out.println("Wrong input");
    }

    return (bookToReturn);
  }

  public static void main(String[] args) {
    final int RETURN_BOOK_OPTION = 1;
    final int ADD_BOOK_OPTION = 2;
    final int LOST_BOOK_OPTION = 3;
    final int REMOVE_BOOK_OPTION = 4;
    final int SORT_LIBRARY_OPTION = 5;
    final int PRINT_LIBRARY = 6;
    final int EXIT_OPTION = -999;

    Scanner scanner = new Scanner(System.in);

    BookShelf[] libShelves = new BookShelf[Library.NUM_OF_SHELVES];

    for (int i = 0; i < Library.NUM_OF_SHELVES; i++) {
      libShelves[i] = new BookShelf(i + 1, new ArrayList<>());
    }

    Library library = new Library("The Library", libShelves);

    Book book;

    System.out.println("What do you want to do?");
    System.out.println(RETURN_BOOK_OPTION + " - return book");
    System.out.println(ADD_BOOK_OPTION + " - add book");
    System.out.println(LOST_BOOK_OPTION + " - report a lost book");
    System.out.println(REMOVE_BOOK_OPTION + " - remove book");
    System.out.println(SORT_LIBRARY_OPTION + " - sort library");
    System.out.println(PRINT_LIBRARY + " - print library");
    System.out.println(EXIT_OPTION + " - exit");
    int choice = Integer.parseInt(scanner.nextLine());

    while (choice != EXIT_OPTION) {

      switch (choice) {
        case (RETURN_BOOK_OPTION) -> {
          book = getBookFromUser();
          if (book == null) {
            System.out.println("try again");
          } else {
            System.out.println("Insert the shelf id");
            int shelfID = Integer.parseInt(scanner.nextLine());

            // Try to add the book
            try {
              library.addBook(shelfID, book);
            } catch (FullBookShelfException e) {
              System.out.println(e.getMessage());
            }
          }
        }
        case (ADD_BOOK_OPTION) -> {
          book = getBookFromUser();
          if (book == null) {
            System.out.println("try again");
          } else {

            // Try to add the book
            try {
              library.addBook(book);
            } catch (FullBookShelfException e) {
              System.out.println(e.getMessage());
            }
          }
        }
        case (LOST_BOOK_OPTION) -> {
          System.out.println("Insert the shelf number of the lost book");
          int shelfID = Integer.parseInt(scanner.nextLine());
          System.out.println("Insert the name of the lost book");
          String bookName = scanner.nextLine();
          library.deleteBook(shelfID, bookName);
        }
        case (REMOVE_BOOK_OPTION) -> {
          System.out.println("Insert the name of the book");
          String name = scanner.nextLine();

          // Try to delete the book
          try {
            library.deleteBook(name);
          } catch (DeleteBookException e) {
            System.out.println(e.getMessage());
          }
        }
        case (SORT_LIBRARY_OPTION) -> library.sort();
        case (PRINT_LIBRARY) -> library.print();
        default -> System.out.println("Wrong input");
      }

      System.out.println("What do you want to do?");
      System.out.println(RETURN_BOOK_OPTION + " - return book");
      System.out.println(ADD_BOOK_OPTION + " - add book");
      System.out.println(LOST_BOOK_OPTION + " - report a lost book");
      System.out.println(REMOVE_BOOK_OPTION + " - remove book");
      System.out.println(SORT_LIBRARY_OPTION + " - sort library");
      System.out.println(PRINT_LIBRARY + " - print library");
      System.out.println(EXIT_OPTION + " - exit");
      choice = Integer.parseInt(scanner.nextLine());
    }
  }
}
