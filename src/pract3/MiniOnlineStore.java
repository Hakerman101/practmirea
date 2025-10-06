package pract3;

import java.util.*;

// Класс товара
class Product {
    private int id;
    private String name;
    private double price; // цена в базовой валюте (рубли)
    private int stock;

    public Product(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // Геттеры
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    public void reduceStock(int quantity) {
        this.stock -= quantity;
    }

    @Override
    public String toString() {
        return String.format("%d. %s - %.2f руб. (в наличии: %d)", id, name, price, stock);
    }
}

// Класс корзины покупок
class ShoppingCart {
    private Map<Product, Integer> items;

    public ShoppingCart() {
        items = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        if (quantity <= 0) {
            System.out.println("Количество должно быть положительным!");
            return;
        }

        if (product.getStock() < quantity) {
            System.out.println("Недостаточно товара на складе!");
            return;
        }

        items.put(product, items.getOrDefault(product, 0) + quantity);
        System.out.printf("Добавлено: %s x%d\n", product.getName(), quantity);
    }

    public void removeProduct(Product product) {
        items.remove(product);
    }

    public void clearCart() {
        items.clear();
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void displayCart() {
        if (isEmpty()) {
            System.out.println("Корзина пуста");
            return;
        }

        System.out.println("\n=== Ваша корзина ===");
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.printf("%s x%d = %.2f руб.\n",
                    product.getName(), quantity, product.getPrice() * quantity);
        }
    }
}

// Конвертер валют (расширенная версия)
class CurrencyConverter1 {
    private Map<String, Double> exchangeRates;
    private String baseCurrency;

    public CurrencyConverter1() {
        this.baseCurrency = "RUB";
        exchangeRates = new HashMap<>();
        initializeRates();
    }

    private void initializeRates() {
        exchangeRates.put("RUB", 1.0);
        exchangeRates.put("USD", 0.011);
        exchangeRates.put("EUR", 0.010);
        exchangeRates.put("GBP", 0.0085);
        exchangeRates.put("JPY", 1.65);
        exchangeRates.put("CNY", 0.079);
    }

    public double convert(double amount, String fromCurrency, String toCurrency) {
        if (!exchangeRates.containsKey(fromCurrency.toUpperCase()) ||
                !exchangeRates.containsKey(toCurrency.toUpperCase())) {
            throw new IllegalArgumentException("Валюта не поддерживается");
        }

        double amountInBase = amount / exchangeRates.get(fromCurrency.toUpperCase());
        return amountInBase * exchangeRates.get(toCurrency.toUpperCase());
    }

    public void displayRates() {
        System.out.println("\n=== Курсы валют (к RUB) ===");
        for (Map.Entry<String, Double> entry : exchangeRates.entrySet()) {
            if (!entry.getKey().equals("RUB")) {
                System.out.printf("1 %s = %.4f RUB\n", entry.getKey(), 1/entry.getValue());
            }
        }
    }

    public Set<String> getSupportedCurrencies() {
        return exchangeRates.keySet();
    }
}

// Основной класс магазина
class OnlineStore {
    private List<Product> products;
    private ShoppingCart cart;
    private CurrencyConverter1 converter;
    private Scanner scanner;

    public OnlineStore() {
        initializeProducts();
        cart = new ShoppingCart();
        converter = new CurrencyConverter1();
        scanner = new Scanner(System.in);
    }

    private void initializeProducts() {
        products = new ArrayList<>();
        products.add(new Product(1, "Ноутбук", 50000.0, 10));
        products.add(new Product(2, "Смартфон", 25000.0, 15));
        products.add(new Product(3, "Наушники", 5000.0, 30));
        products.add(new Product(4, "Планшет", 35000.0, 8));
        products.add(new Product(5, "Мышь", 1500.0, 50));
        products.add(new Product(6, "Клавиатура", 3000.0, 25));
    }

    public void run() {
        System.out.println("=== Добро пожаловать в интернет-магазин! ===");

        while (true) {
            displayMainMenu();
            int choice = getIntInput("Выберите действие: ");

            switch (choice) {
                case 1 -> displayProducts();
                case 2 -> addToCart();
                case 3 -> cart.displayCart();
                case 4 -> checkout();
                case 5 -> converter.displayRates();
                case 0 -> {
                    System.out.println("Спасибо за посещение!");
                    return;
                }
                default -> System.out.println("Неверный выбор!");
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("\n=== Главное меню ===");
        System.out.println("1. Просмотр товаров");
        System.out.println("2. Добавить в корзину");
        System.out.println("3. Просмотр корзины");
        System.out.println("4. Оформить заказ");
        System.out.println("5. Курсы валют");
        System.out.println("0. Выход");
    }

    private void displayProducts() {
        System.out.println("\n=== Каталог товаров ===");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private void addToCart() {
        displayProducts();
        int productId = getIntInput("Введите ID товара: ");
        int quantity = getIntInput("Введите количество: ");

        Product selectedProduct = findProductById(productId);
        if (selectedProduct != null) {
            cart.addProduct(selectedProduct, quantity);
        } else {
            System.out.println("Товар не найден!");
        }
    }

    private void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Корзина пуста!");
            return;
        }

        cart.displayCart();

        // Расчет общей стоимости в рублях
        double totalInRubles = calculateTotalInRubles();
        System.out.printf("\nОбщая стоимость: %.2f RUB\n", totalInRubles);

        // Выбор валюты для оплаты
        System.out.println("\nДоступные валюты: " + converter.getSupportedCurrencies());
        System.out.print("Выберите валюту для оплаты (RUB/USD/EUR/GBP/JPY/CNY): ");
        String currency = scanner.next().toUpperCase();

        try {
            double totalInSelectedCurrency = converter.convert(totalInRubles, "RUB", currency);
            System.out.printf("Стоимость в выбранной валюте: %.2f %s\n", totalInSelectedCurrency, currency);

            // Подтверждение заказа
            System.out.print("\nПодтвердить заказ? (да/нет): ");
            String confirm = scanner.next().toLowerCase();

            if (confirm.equals("да") || confirm.equals("yes") || confirm.equals("y")) {
                processOrder();
                System.out.println("Заказ успешно оформлен!");
            } else {
                System.out.println("Заказ отменен.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private double calculateTotalInRubles() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            total += product.getPrice() * quantity;
        }
        return total;
    }

    private void processOrder() {
        // Обновляем количество товаров на складе
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            product.reduceStock(quantity);
        }
        cart.clearCart();
    }

    private Product findProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    private int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Пожалуйста, введите целое число!");
                scanner.next(); // очистка неправильного ввода
            }
        }
    }
}

// Главный класс приложения
public class MiniOnlineStore {
    public static void main(String[] args) {
        OnlineStore store = new OnlineStore();
        store.run();
    }
}