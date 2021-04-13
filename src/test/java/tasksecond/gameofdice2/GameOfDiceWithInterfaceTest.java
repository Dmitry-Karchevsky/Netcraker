package tasksecond.gameofdice2;

import org.junit.jupiter.api.Test;
import taskfirst.gameofdice.GameOfDice;

import static org.junit.jupiter.api.Assertions.*;

class GameOfDiceWithInterfaceTest {

    @Test
    void startGame() {
        String[] names = {"Dmitry", "Andrey", "Kristina"};
        GameOfDiceWithInterface.startGame(names, 4);
    }
}