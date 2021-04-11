package taskfirst.adresshuman;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class HumanServiceTest {

    private final Address[] addressesArray = {
            new Address("Russia", "Moscow", "Lenina", 12, 30),
            new Address("Russia", "Moscow", "Dzerjinskogo", 8, 14),
            new Address("Russia", "Taganrog", "Metallurgicheskaya", 13),
            new Address("Russia", "Moscow", "Shipilovskaya", 38, 321)
    };

    private final HumanService humanService = new HumanService();

    @Test
    void findHumansBySurname() {
        System.out.println("findHumansBySurname TEST");
        System.out.println(humanService.findHumansBySurname("Ivanov"));
        System.out.println(humanService.findHumansBySurname(null));
        System.out.println(humanService.findHumansBySurname("fff"));
        System.out.println(humanService.findHumansBySurname("Karchevsky"));
    }

    @Test
    void findHumansByAddress() {
        System.out.println("findHumansByAddress TEST");
        System.out.println(humanService.findHumansByAddress(addressesArray[0]));
    }

    @Test
    void findHumansBetweenTwoData() {
        System.out.println("findHumansBetweenTwoData TEST");
        System.out.println(humanService.findHumansBetweenTwoData(LocalDate.of(2001, 1, 1), LocalDate.of(1998, 1, 1)));
        System.out.println(humanService.findHumansBetweenTwoData(LocalDate.of(2050, 1, 1), LocalDate.of(2060, 1, 1)));
    }

    @Test
    void findOldestHuman() {
        System.out.println("findOldestHuman TEST");
        System.out.println(humanService.findOldestHuman());
    }

    @Test
    void findYoungestHuman() {
        System.out.println("findYoungestHuman TEST");
        System.out.println(humanService.findYoungestHuman());
    }

    @Test
    void findHumansByStreet() {
        System.out.println("findHumansByStreet TEST");
        System.out.println(humanService.findHumansByStreet(addressesArray[0].getStreet()));
    }
}