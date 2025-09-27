package pract2.book;

public class Book {
    private String author;
    private String title;
    private int year;
    private String publisher;
    private int pages;

    // Конструкторы
    public Book() {
        this.author = "Неизвестный автор";
        this.title = "Без названия";
        this.year = 2023;
        this.publisher = "Неизвестный издатель";
        this.pages = 0;
    }

    public Book(String author, String title, int year, String publisher, int pages) {
        setAuthor(author);
        setTitle(title);
        setYear(year);
        setPublisher(publisher);
        setPages(pages);
    }

    // Геттеры
    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPages() {
        return pages;
    }

    // Сеттеры с валидацией
    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Автор не может быть пустым");
        }
        this.author = author.trim();
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Название не может быть пустым");
        }
        this.title = title.trim();
    }

    public void setYear(int year) {
        if (year < 0 || year > 2025) {
            throw new IllegalArgumentException("Год издания должен быть между 0 и 2025");
        }
        this.year = year;
    }

    public void setPublisher(String publisher) {
        if (publisher == null || publisher.trim().isEmpty()) {
            throw new IllegalArgumentException("Издатель не может быть пустым");
        }
        this.publisher = publisher.trim();
    }

    public void setPages(int pages) {
        if (pages < 0) {
            throw new IllegalArgumentException("Количество страниц не может быть отрицательным");
        }
        this.pages = pages;
    }

    // Метод для получения информации о книге
    public String getInfo() {
        return String.format("'%s' by %s, %d год, %s, %d стр.",
                title, author, year, publisher, pages);
    }

    @Override
    public String toString() {
        return getInfo();
    }
}