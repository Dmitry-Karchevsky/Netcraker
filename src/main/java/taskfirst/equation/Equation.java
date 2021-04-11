package taskfirst.equation;

/**
 * Разработайте класс для решения квадратных уравнений. Вычисление дискриминанта должен осуществлять вложенный класс.
 * После компиляции объясните структуру class файлов. Проанализируйте использование вложенного класса.
 */
public class Equation {

    /**
     * Использование x1 и x2 как отдельные переменные класса необязательно в данном случае, но если нужно будет
     * дополнить данный класс дополнительными методами и проверками, то возможно они могут пригодиться.
     *
     * Возможно в каких-то ситуациях c double и будет потеря точности, но на конечном ответе она не отразится.
     * На мой взгляд так понятнее, нежели использовать BigDecimal для данной задачи.
     */
    public static String getAnswers(double a, double b, double c){
        if (a == 0 && b == 0 && c == 0)
            return "x - любое число";
        else if (a == 0)
            return "x = " + (-1) * c / b;

        double discriminant = Discriminant.getDiscriminant(a, b, c);
        double x1 = (Math.sqrt(discriminant) - b) / (2 * a);
        if (discriminant < 0)
            return "Корней нет";
        if (discriminant == 0)
            return "x = " + x1;
        double x2 = (Math.sqrt(discriminant) * (-1) - b) / (2 * a);
        return "x1 = " + x1 + "\nx2 = " + x2;
    }

    /**
     * Вычисление Дискриминанта не такая сложная функция, чтобы выносить его в отдельный вложенный класс.
     * Можно, наверное, было обойтись и методом или просто строкой в решении, но раз требуется вложенный класс, то вот он.
     */
    private static class Discriminant{

        public static double getDiscriminant(double a, double b, double c) {
            return b * b - (4 * a * c);
        }
    }
}