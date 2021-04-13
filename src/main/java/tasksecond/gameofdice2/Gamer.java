package tasksecond.gameofdice2;

import java.util.Random;

public class Gamer implements RollTheDice{

    private static final Random RANDOM = new Random();

    private final String name;
    private int wins;
    private int pointsInOneGame;

    public Gamer(String name) {
        this.name = name;
        wins = 0;
        pointsInOneGame = 0;
    }

    @Override
    public void rollTheDice(int countOfDice) {
        pointsInOneGame = 0;
        for (int i = 0; i < countOfDice; i++) {
            pointsInOneGame += RANDOM.nextInt(6) + 1;
        }
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

    @Override
    public String toString() {
        return "Gamer{" +
                "name='" + name + '\'' +
                ", wins=" + wins +
                '}';
    }
}
