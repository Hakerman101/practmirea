package pract1;
import java.util.Scanner;


public class pract15 {
    public static long calculateFactorial(int n) {
        // Факториал отрицательного числа не определен
        if (n < 0) {
            throw new IllegalArgumentException("Факториал отрицательного числа не определен");
        }

        // Факториал 0 и 1 равен 1
        if (n == 0 || n == 1) {
            return 1;
        }

        // Вычисление факториала с помощью цикла
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Дополнительный метод с циклом while для разнообразия
    public static long calculateFactorialWhile(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал отрицательного числа не определен");
        }

        long result = 1;
        int i = n;
        while (i > 1) {
            result *= i;
            i--;
        }
        return result;
    }

    // Метод для проверки работы факториала
    public static void testFactorial() {
        System.out.println("Тестирование метода calculateFactorial:");
        System.out.println("=======================================");

        // Тестовые случаи
        int[] testNumbers = {0, 1, 2, 3, 4, 5, 10, 15};

        for (int num : testNumbers) {
            long factorial = calculateFactorial(num);
            System.out.printf("%2d! = %d%n", num, factorial);
        }

        // Проверка на отрицательное число
        try {
            calculateFactorial(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Демонстрация работы метода
        System.out.println("Калькулятор факториала");
        System.out.println("======================");

        // Ввод числа от пользователя
        System.out.print("Введите неотрицательное целое число: ");
        int number = scanner.nextInt();

        try {
            // Вычисление факториала
            long factorial = calculateFactorial(number);
            System.out.printf("%d! = %d%n", number, factorial);

            // Альтернативный расчет для проверки
            long factorialWhile = calculateFactorialWhile(number);
            System.out.printf("Проверка (while): %d! = %d%n", number, factorialWhile);

            // Сравнение результатов
            if (factorial == factorialWhile) {
                System.out.println("✓ Оба метода дали одинаковый результат");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Запуск тестов
        System.out.println("\n");
        testFactorial();

        // Дополнительная информация о пределах
        System.out.println("\nИнформация о пределах:");
        System.out.println("Факториал 20! = " + calculateFactorial(20));
        System.out.println("Факториал 21! выходит за пределы long (" +
                (calculateFactorial(20) * 21L) + ") - переполнение");

        scanner.close();
    }
}
