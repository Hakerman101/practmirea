package pract2.book;

public class BookTest {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ КЛАССА BOOK ===");

        // Тестирование конструкторов и методов Book
        Book book1 = new Book("Лев Толстой", "Война и мир", 1869, "Русский вестник", 1225);
        Book book2 = new Book("Фёдор Достоевский", "Преступление и наказание", 1866, "Русский вестник", 608);
        Book book3 = new Book();

        // Установка свойств через сеттеры
        book3.setAuthor("Антон Чехов");
        book3.setTitle("Вишнёвый сад");
        book3.setYear(1904);
        book3.setPublisher("Знание");
        book3.setPages(96);

        // Вывод информации о книгах
        System.out.println("Книга 1: " + book1.getInfo());
        System.out.println("Книга 2: " + book2);
        System.out.println("Книга 3: " + book3);

        // Тестирование геттеров
        System.out.println("\nАвтор книги 1: " + book1.getAuthor());
        System.out.println("Год издания книги 2: " + book2.getYear());

        System.out.println("\n=== ТЕСТИРОВАНИЕ КЛАССА BOOKSHELF ===");

        // Создание книжной полки
        Bookshelf shelf = new Bookshelf(5);

        // Добавление книг на полку
        shelf.addBook(book1);
        shelf.addBook(book2);
        shelf.addBook(book3);
        shelf.addBook("Иван Тургенев", "Отцы и дети", 1862, "Русский вестник", 288);
        shelf.addBook("Николай Гоголь", "Мёртвые души", 1842, "Современник", 352);

        // Попытка добавить книгу на заполненную полку
        boolean added = shelf.addBook("Александр Пушкин", "Евгений Онегин", 1833, "Литература", 240);
        System.out.println("Добавлена ли шестая книга? " + (added ? "Да" : "Нет"));

        // Отображение книг на полке
        shelf.displayBooks();

        // Поиск книг с самым ранним и поздним годом издания
        Book earliest = shelf.getEarliestBook();
        Book latest = shelf.getLatestBook();

        System.out.println("\nСамая ранняя книга: " + (earliest != null ? earliest.getInfo() : "нет книг"));
        System.out.println("Самая поздняя книга: " + (latest != null ? latest.getInfo() : "нет книг"));

        // Сортировка книг по году издания
        System.out.println("\n=== СОРТИРОВКА КНИГ ПО ГОДУ ИЗДАНИЯ ===");
        shelf.sortBooksByYear();
        shelf.displayBooks();

        // Проверка после сортировки
        System.out.println("\nПосле сортировки:");
        System.out.println("Первая книга: " + shelf.getBook(0).getInfo());
        System.out.println("Последняя книга: " + shelf.getBook(shelf.getBookCount() - 1).getInfo());

        // Тестирование обработки ошибок
        System.out.println("\n=== ТЕСТИРОВАНИЕ ОБРАБОТКИ ОШИБОК ===");
        try {
            Book invalidBook = new Book("", "Тест", 2020, "Тест", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании книги: " + e.getMessage());
        }

        try {
            shelf.getBook(10); // Неверный индекс
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка доступа к книге: " + e.getMessage());
        }
    }
}