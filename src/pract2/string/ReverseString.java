package pract2.string;

import java.util.Arrays;

public class ReverseString {

    // Метод для обращения массива строк без использования дополнительного массива
    public static void reverseArray(String[] array) {
        if (array == null || array.length <= 1) {
            return; // Нечего обращать для пустого массива или массива с одним элементом
        }

        int left = 0;
        int right = array.length - 1;

        // Меняем элементы местами, двигаясь с обоих концов к центру
        while (left < right) {
            // Обмен элементами
            String temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            // Двигаем указатели к центру
            left++;
            right--;
        }
    }

    // Альтернативный метод с использованием цикла for
    public static void reverseArrayFor(String[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        for (int i = 0; i < array.length / 2; i++) {
            String temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    // Метод для вывода массива
    public static void printArray(String[] array, String message) {
        System.out.print(message + ": ");
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        System.out.println("=== ОБРАЩЕНИЕ МАССИВА СТРОК ===");

        // Тест 1: Обычный массив
        String[] fruits = {"яблоко", "банан", "апельсин", "виноград", "киви"};
        System.out.println("\nТест 1 - Массив фруктов:");
        printArray(fruits, "Исходный массив");

        reverseArray(fruits);
        printArray(fruits, "После обращения (while)");

        // Возвращаем обратно для демонстрации второго метода
        reverseArrayFor(fruits);
        printArray(fruits, "После возврата (for)");

        // Тест 2: Массив с четным количеством элементов
        String[] colors = {"красный", "оранжевый", "желтый", "зеленый"};
        System.out.println("\nТест 2 - Массив цветов (четное количество):");
        printArray(colors, "Исходный массив");

        reverseArray(colors);
        printArray(colors, "После обращения");

        // Тест 3: Массив с одним элементом
        String[] single = {"один"};
        System.out.println("\nТест 3 - Массив с одним элементом:");
        printArray(single, "Исходный массив");

        reverseArray(single);
        printArray(single, "После обращения");

        // Тест 4: Пустой массив
        String[] empty = {};
        System.out.println("\nТест 4 - Пустой массив:");
        printArray(empty, "Исходный массив");

        reverseArray(empty);
        printArray(empty, "После обращения");

        // Тест 5: Массив с null значениями
        String[] withNull = {"первый", null, "третий", null};
        System.out.println("\nТест 5 - Массив с null значениями:");
        printArray(withNull, "Исходный массив");

        reverseArray(withNull);
        printArray(withNull, "После обращения");

        // Тест 6: Демонстрация пошагового процесса
        System.out.println("\n=== ПОШАГОВЫЙ ПРОЦЕСС ОБРАЩЕНИЯ ===");
        String[] demo = {"A", "B", "C", "D", "E"};
        printArray(demo, "Начальное состояние");

        // Демонстрация шагов
        String[] step1 = demo.clone();
        String temp = step1[0];
        step1[0] = step1[4];
        step1[4] = temp;
        printArray(step1, "Шаг 1: A<->E");

        String[] step2 = step1.clone();
        temp = step2[1];
        step2[1] = step2[3];
        step2[3] = temp;
        printArray(step2, "Шаг 2: B<->D");

        printArray(step2, "Результат (C остался на месте)");

        // Проверка работы на большем массиве
        System.out.println("\n=== ПРОВЕРКА НА БОЛЬШЕМ МАССИВЕ ===");
        String[] words = {"раз", "два", "три", "четыре", "пять", "шесть", "семь"};
        printArray(words, "Исходный массив");

        reverseArray(words);
        printArray(words, "После обращения");

        // Проверка корректности обращения
        System.out.println("\n=== ПРОВЕРКА КОРРЕКТНОСТИ ===");
        String[] test = {"1", "2", "3", "4", "5"};
        System.out.println("Проверка корректности обращения:");
        printArray(test, "До");
        reverseArray(test);
        printArray(test, "После");
        reverseArray(test);
        printArray(test, "После двойного обращения (должен вернуться исходный)");
    }
}