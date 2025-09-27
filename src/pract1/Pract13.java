package pract1;

public class Pract13 {
    public static void main(String[] args) {
        // Вывод аргументов командной строки с помощью цикла for
        System.out.println("Аргументы командной строки:");


        System.out.println("\nВариант 1 - с индексом:");
        for (int i = 0; i < args.length; i++) {
            System.out.println("Аргумент " + i + ": " + args[i]);
        }

        // Вывод количества аргументов
        System.out.println("\nВсего аргументов: " + args.length);
    }
}
