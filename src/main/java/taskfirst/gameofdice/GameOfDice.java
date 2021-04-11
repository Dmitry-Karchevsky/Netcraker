package taskfirst.gameofdice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Реализуйте игру в кости. Играют N игроков (компьютер в списке последний).
 * Подкидываются одновременно К кубиков. Выигрывает тот, у кого большая
 * сумма очков. Кто выиграл, тот и кидает первым в следующем кону. Игра идет
 * до 7 выигрышей. Начинаете игру Вы.
 */
public class GameOfDice {

    private static final Random RANDOM = new Random();

    /**
     * Возможно авторы предпологали использование многопоточности в этой задаче.
     * Каждый игрок - отдельный поток. Но игроки кидают кости по очереди, друг за другом,
     * с этим, как мне кажется справится и один поток.
     * Снова мало данных о задаче, поэтому предположим на вход поступает просто массив строк,
     * содержащий имена игроков (+ 1 компьютер) и количество кубиков, которыми они будут играть.
     * Выводиться будет соответственно ход игры и имя победителя.
     */
    public static void startGame(String[] namesOfGamers, int countOfCubes){
        List<Gamer> gamerList = new ArrayList<>();
        for (String name : namesOfGamers){
            gamerList.add(new Gamer(name));
        }
        gamerList.add(new Gamer("Computer"));

        while (gamerList.stream().noneMatch(x -> x.getWins() == 7)){
            startRound(gamerList, countOfCubes);
            gamerList.forEach(x->x.setPointsInOneGame(0));
        }

        System.out.println("В игре выиграл игрок: " + gamerList.get(0).getName());
    }

    private static void startRound(List<Gamer> gamerList, int countOfCubes){
        for (Gamer gamer : gamerList){
            System.out.print("Игрок " + gamer.getName() + " кидает кости - ");
            for (int i = 0; i < countOfCubes; i++) {
                //int pointsOneRoll = (int) (Math.random() * 6 + 1);
                int pointsOneRoll = RANDOM.nextInt(6) + 1;
                gamer.addPointsInOneGame(pointsOneRoll);
                System.out.print(pointsOneRoll + " ");
            }
            System.out.println("-> " + gamer.getPointsInOneGame());
        }
        Collections.sort(gamerList);
        int max = gamerList.get(0).getPointsInOneGame();// С дополнительными переменными код по-моему более понятен
        int countOfMax = (int) gamerList.stream().filter(x->x.getPointsInOneGame() == max).count();
        if (countOfMax > 1){
            System.out.println("У игроков одинаковое количество баллов, они же и прекидывают:");
            gamerList.forEach(x->x.setPointsInOneGame(0));
            startRound(gamerList.subList(0, countOfMax), countOfCubes);
        } else {
            gamerList.get(0).addWin();
            System.out.println("В раунде выиграл игрок: " + gamerList.get(0).getName());
            System.out.println(gamerList);
        }
    }

    private static class Gamer implements Comparable<Gamer>{
        private final String name;
        private int wins;
        private int pointsInOneGame;

         public Gamer(String name) {
            this.name = name;
            wins = 0;
            pointsInOneGame = 0;
        }

        /*
        * Обычно вместе с compareTo переопределяется и equals с hashcode,
        * но для данной задачи достаточно явного сравнения "int-ов"
        * */
        @Override
        public int compareTo(Gamer o) {
            return Integer.compare(o.pointsInOneGame, pointsInOneGame);
        }

        public String getName() {
            return name;
        }

        public int getWins() {
            return wins;
        }

        public void addWin() {
            this.wins++;
        }

        public int getPointsInOneGame() {
            return pointsInOneGame;
        }

        public void setPointsInOneGame(int pointsInOneGame) {
            this.pointsInOneGame = pointsInOneGame;
        }

        public void addPointsInOneGame(int pointsInOneRoll) {
            this.pointsInOneGame += pointsInOneRoll;
        }

        @Override
        public String toString() {
            return "Gamer{" +
                    "name='" + name + '\'' +
                    ", wins=" + wins +
                    '}';
        }
    }
}
