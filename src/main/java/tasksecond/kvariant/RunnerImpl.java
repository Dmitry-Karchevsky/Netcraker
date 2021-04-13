package tasksecond.kvariant;

/**
 * Создайте интерфейс Runner с методами run() и getDistance().
 * Реализуйте интерфейс в классе RunnerImpl. Метод run() должен
 * прибавлять к текущей дистанции (изначально равной нулю)
 * число 1 при первом вызове, число 2 при втором, число 3 при
 * третьем и т.д. Метод getDistance() должен печатать текущую
 * дистанцию на экран.
 */
public class RunnerImpl implements Runner{
    private int distance = 0;
    private static int countOfCalling = 0;

    @Override
    public void run() {
        distance += ++countOfCalling;
    }

    @Override
    public void getDistance() {
        System.out.println(distance);
    }
}
