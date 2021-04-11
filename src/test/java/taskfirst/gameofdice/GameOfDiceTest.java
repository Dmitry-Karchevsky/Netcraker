package taskfirst.gameofdice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOfDiceTest {

    @Test
    void startGame() {
        String[] names = {"Dmitry", "Andrey", "Kristina"};
        GameOfDice.startGame(names, 4);
    }
}