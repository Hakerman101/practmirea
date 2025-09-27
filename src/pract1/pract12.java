package pract1;
import java.util.Scanner;

public class pract12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод размера массива
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        // Проверка на корректный размер
        if (size <= 0) {
            System.out.println("Размер массива должен быть положительным числом!");
            return;
        }

        // Создание и ввод элементов массива
        int[] array = new int[size];
        System.out.println("Введите " + size + " элементов массива:");

        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        // Вычисление суммы с помощью цикла while
        int sumWhile = 0;
        int index = 0;
        while (index < array.length) {
            sumWhile += array[index];
            index++;
        }

        // Вычисление суммы с помощью цикла do-while
        int sumDoWhile = 0;
        int j = 0;
        if (array.length > 0) {
            do {
                sumDoWhile += array[j];
                j++;
            } while (j < array.length);
        }

        // Поиск максимального и минимального элемента
        int max = array[0];
        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }

        // Вывод результатов
        System.out.println("\n=== РЕЗУЛЬТАТЫ ===");
        System.out.println("Массив: " + java.util.Arrays.toString(array));
        System.out.println("Сумма элементов (цикл while): " + sumWhile);
        System.out.println("Сумма элементов (цикл do-while): " + sumDoWhile);
        System.out.println("Максимальный элемент: " + max);
        System.out.println("Минимальный элемент: " + min);
        System.out.println("Среднее арифметическое: " + (double)sumWhile / array.length);

        scanner.close();
    }
}
