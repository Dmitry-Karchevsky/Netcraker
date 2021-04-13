package tasksecond.gameofdice2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GameOfDiceWithInterface {
    public static void startGame(String[] namesOfGamers, int countOfCubes){
        List<Gamer> gamerList = new ArrayList<>();
        for (String name : namesOfGamers){
            gamerList.add(new Gamer(name));
        }
        gamerList.add(new Gamer("Computer"));

        while (gamerList.stream().noneMatch(x -> x.getWins() == 7)){
            startRound(gamerList, countOfCubes);
        }

        System.out.println("В игре выиграл игрок: " + gamerList.get(0).getName());
    }

    private static void startRound(List<Gamer> gamerList, int countOfCubes){
        for (Gamer gamer : gamerList){
            System.out.print("Игрок " + gamer.getName() + " кидает кости - ");
            gamer.rollTheDice(countOfCubes);
            System.out.println(gamer.getPointsInOneGame());
        }
        gamerList.sort(Comparator.comparingInt(Gamer::getPointsInOneGame).reversed());
        int max = gamerList.get(0).getPointsInOneGame();
        int countOfMax = (int) gamerList.stream().filter(x->x.getPointsInOneGame() == max).count();
        if (countOfMax > 1){
            System.out.println("У игроков одинаковое количество баллов, они же и перекидывают:");
            gamerList.forEach(x->x.setPointsInOneGame(0));
            startRound(gamerList.subList(0, countOfMax), countOfCubes);
        } else {
            gamerList.get(0).addWin();
            System.out.println("В раунде выиграл игрок: " + gamerList.get(0).getName());
            System.out.println(gamerList);
        }
    }
}
