package pract3;

import java.util.Map;

public class ConverterDemo {
    public static void main(String[] args) {
        // Создание конвертера со стандартными курсами
        CurrencyConverter converter = new CurrencyConverter();

        // Демонстрация конвертации
        System.out.println("=== Конвертер валют ===");

        // Одиночная конвертация
        double result = converter.convert(100, "USD", "EUR");
        System.out.println("100 USD в EUR: " + result);

        // Форматированный вывод
        System.out.println(converter.convertFormatted(100, "USD", "GBP"));
        System.out.println(converter.convertFormatted(1000, "JPY", "USD"));

        // Добавление новой валюты
        converter.setExchangeRate("CAD", 1.25);
        System.out.println(converter.convertFormatted(100, "USD", "CAD"));

        // Массовая конвертация
        double[] amounts = {10, 50, 100, 500};
        Map<Double, Double> results = converter.convertMultiple(amounts, "USD", "EUR");

        System.out.println("\nМассовая конвертация USD -> EUR:");
        for (Map.Entry<Double, Double> entry : results.entrySet()) {
            System.out.printf("%.0f USD = %.2f EUR\n", entry.getKey(), entry.getValue());
        }

        // Список поддерживаемых валют
        System.out.println("\nПоддерживаемые валюты:");
        for (String currency : converter.getSupportedCurrencies()) {
            double rate = converter.getExchangeRate(currency);
            System.out.printf("%s: %.4f\n", currency, rate);
        }
    }
}