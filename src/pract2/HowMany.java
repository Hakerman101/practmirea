package pract2;

import java.util.Scanner;

public class HowMany {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        // Разделение строки на слова (учитываем пробелы, табуляции и множественные пробелы)
        String[] words = input.trim().split("\\s+");

        // Если введена пустая строка, массив будет содержать одну пустую строку
        int wordCount = (input.trim().isEmpty()) ? 0 : words.length;

        System.out.println("Количество слов: " + wordCount);
    }
}