package pract3;

public class zad1 {
    public static void main(String[] args) {
        // 1. Создание объектов Double с использованием valueOf()
        Double doubleObj1 = Double.valueOf(3.14);
        Double doubleObj2 = Double.valueOf("2.71");

        // 2. Преобразование String к double
        String numberStr = "5.89";
        double primitiveDouble = Double.parseDouble(numberStr);

        // 3. Преобразование Double ко всем примитивным типам
        byte byteValue = doubleObj1.byteValue();
        short shortValue = doubleObj1.shortValue();
        int intValue = doubleObj1.intValue();
        long longValue = doubleObj1.longValue();
        float floatValue = doubleObj1.floatValue();
        double doubleValue = doubleObj1.doubleValue();
        boolean booleanValue = (doubleObj1 != 0); // Логическое преобразование

        // 4. Вывод значения Double на консоль
        System.out.println("Объект Double: " + doubleObj1);

        // 5. Преобразование double к строке
        String d = Double.toString(3.14);
        System.out.println("Строковое представление: " + d);
    }
}
