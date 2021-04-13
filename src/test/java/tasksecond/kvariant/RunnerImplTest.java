package tasksecond.kvariant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RunnerImplTest {

    @Test
    void run() {
        RunnerImpl runner = new RunnerImpl();
        runner.run();
        runner.getDistance();
        runner.run();
        runner.getDistance();
        runner.run();
        runner.getDistance();
        runner.run();
        runner.getDistance();
    }
}