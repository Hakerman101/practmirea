package pract1;

public class pract14 {
    public static void main(String[] args) {
        System.out.println("Первые 10 чисел гармонического ряда:");
        System.out.println("=====================================");

        // Вывод с форматированием в виде таблицы
        System.out.printf("%-5s %-15s %-15s%n", "№", "Дробь", "Десятичное");
        System.out.println("-------------------------------------");

        for (int i = 1; i <= 10; i++) {
            // Вычисление члена гармонического ряда
            double harmonicNumber = 1.0 / i;

            // Форматированный вывод
            System.out.printf("%-5d %-15s %-15.6f%n",
                    i,
                    "1/" + i,
                    harmonicNumber);
        }

        // Дополнительный вывод: частичные суммы гармонического ряда
        System.out.println("\nЧастичные суммы гармонического ряда:");
        System.out.println("=====================================");

        double sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += 1.0 / i;
            System.out.printf("H(%d) = %.6f%n", i, sum);
        }
    }
}
