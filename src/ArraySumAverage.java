public class ArraySumAverage {
    public static void main(String[] args) {
        // Инициализация массива как в Java
        int[] array = {5, 2, 8, 1, 9, 3};
        int sum = 0;

        // Вычисляем сумму элементов массива
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        // Вычисляем среднее арифметическое
        double average = (double) sum / array.length;

        // Выводим результаты
        System.out.println("Сумма элементов массива: " + sum);
        System.out.println("Среднее арифметическое: " + average);
        System.out.printf("Среднее арифметическое (форматированное): %.2f\n", average);
    }
}