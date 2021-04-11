package taskfirst.equation;

import org.junit.jupiter.api.Test;

class EquationTest {

    @Test
    void getAnswers() {
        System.out.println("test1:\n" + Equation.getAnswers(1, 2, 3));
        System.out.println("test2:\n" + Equation.getAnswers(0, 0, 0));
        System.out.println("test3:\n" + Equation.getAnswers(0, 4, 3));
        System.out.println("test4:\n" + Equation.getAnswers(1, 4, 3));
        System.out.println("test5:\n" + Equation.getAnswers(1, 2, 1));
        System.out.println("test6:\n" + Equation.getAnswers(1.56, 7.5, -24.67));
    }
}