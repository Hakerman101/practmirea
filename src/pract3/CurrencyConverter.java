package pract3;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {
    private Map<String, Double> exchangeRates;

    // Конструктор с инициализацией базовых курсов
    public CurrencyConverter() {
        exchangeRates = new HashMap<>();
        initializeDefaultRates();
    }

    // Конструктор с пользовательскими курсами
    public CurrencyConverter(Map<String, Double> customRates) {
        exchangeRates = new HashMap<>(customRates);
    }

    // Инициализация стандартных курсов
    private void initializeDefaultRates() {
        exchangeRates.put("USD", 1.0);      // Базовая валюта
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.73);
        exchangeRates.put("JPY", 110.25);
        exchangeRates.put("RUB", 75.50);
        exchangeRates.put("CNY", 6.45);
    }

    // Основной метод конвертации
    public double convert(double amount, String fromCurrency, String toCurrency) {
        validateCurrency(fromCurrency);
        validateCurrency(toCurrency);

        if (amount < 0) {
            throw new IllegalArgumentException("Сумма не может быть отрицательной");
        }

        // Конвертация через USD как базовую валюту
        double amountInUSD = amount / exchangeRates.get(fromCurrency);
        return amountInUSD * exchangeRates.get(toCurrency);
    }

    // Добавление/обновление курса валюты
    public void setExchangeRate(String currency, double rate) {
        if (rate <= 0) {
            throw new IllegalArgumentException("Курс должен быть положительным");
        }
        exchangeRates.put(currency.toUpperCase(), rate);
    }

    // Получение текущего курса
    public double getExchangeRate(String currency) {
        validateCurrency(currency);
        return exchangeRates.get(currency);
    }

    // Проверка существования валюты
    private void validateCurrency(String currency) {
        String currencyUpper = currency.toUpperCase();
        if (!exchangeRates.containsKey(currencyUpper)) {
            throw new IllegalArgumentException("Валюта " + currency + " не поддерживается");
        }
    }

    // Получение списка поддерживаемых валют
    public String[] getSupportedCurrencies() {
        return exchangeRates.keySet().toArray(new String[0]);
    }

    // Форматированный вывод результата конвертации
    public String convertFormatted(double amount, String fromCurrency, String toCurrency) {
        double result = convert(amount, fromCurrency, toCurrency);
        return String.format("%.2f %s = %.2f %s",
                amount, fromCurrency.toUpperCase(),
                result, toCurrency.toUpperCase());
    }

    // Метод для массовой конвертации (несколько сумм)
    public Map<Double, Double> convertMultiple(double[] amounts, String fromCurrency, String toCurrency) {
        Map<Double, Double> results = new HashMap<>();
        for (double amount : amounts) {
            results.put(amount, convert(amount, fromCurrency, toCurrency));
        }
        return results;
    }
}
