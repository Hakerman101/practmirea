package pract2.book;

public class Bookshelf {
    private Book[] books;
    private int bookCount;

    // Конструкторы
    public Bookshelf(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Вместимость полки должна быть положительной");
        }
        this.books = new Book[capacity];
        this.bookCount = 0;
    }

    public Bookshelf() {
        this(10); // Полка по умолчанию на 10 книг
    }

    // Метод для добавления книги на полку
    public boolean addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount] = book;
            bookCount++;
            return true;
        }
        return false; // Полка заполнена
    }

    // Метод для добавления книги с параметрами
    public boolean addBook(String author, String title, int year, String publisher, int pages) {
        return addBook(new Book(author, title, year, publisher, pages));
    }

    // Метод для получения книги с самым поздним годом издания
    public Book getLatestBook() {
        if (bookCount == 0) {
            return null;
        }

        Book latest = books[0];
        for (int i = 1; i < bookCount; i++) {
            if (books[i].getYear() > latest.getYear()) {
                latest = books[i];
            }
        }
        return latest;
    }

    // Метод для получения книги с самым ранним годом издания
    public Book getEarliestBook() {
        if (bookCount == 0) {
            return null;
        }

        Book earliest = books[0];
        for (int i = 1; i < bookCount; i++) {
            if (books[i].getYear() < earliest.getYear()) {
                earliest = books[i];
            }
        }
        return earliest;
    }

    // Метод для сортировки книг по году издания (пузырьковая сортировка)
    public void sortBooksByYear() {
        for (int i = 0; i < bookCount - 1; i++) {
            for (int j = 0; j < bookCount - i - 1; j++) {
                if (books[j].getYear() > books[j + 1].getYear()) {
                    // Обмен книгами
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
    }

    // Геттеры
    public int getBookCount() {
        return bookCount;
    }

    public int getCapacity() {
        return books.length;
    }

    // Метод для отображения всех книг на полке
    public void displayBooks() {
        if (bookCount == 0) {
            System.out.println("Книжная полка пуста");
            return;
        }

        System.out.println("Книги на полке (" + bookCount + " из " + books.length + "):");
        for (int i = 0; i < bookCount; i++) {
            System.out.println((i + 1) + ". " + books[i].getInfo());
        }
    }

    // Метод для получения книги по индексу
    public Book getBook(int index) {
        if (index < 0 || index >= bookCount) {
            throw new IndexOutOfBoundsException("Неверный индекс книги");
        }
        return books[index];
    }
}