package taskfirst.adresshuman;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Напишите программу «Адрес человека». Есть сущность Человек, которая
 * связана с сущностью Адрес. Считается, что у каждого человека есть только
 * один адрес. Организовать массив объектов Человек (не менее 4) и по массиву:
 * - осуществить поиск Человека по фамилии;
 * - осуществить поиск человека по атрибуту адреса;
 * - вывести людей, родившихся между определенными датами;
 * - найти самого старого (молодого);
 * - найти людей, проживающих на одной улице.
 */
public class HumanService {

    /**
     * Обычно здесь указываются репозитории через которые и происходит поиск/добавление по определенным параметрам.
     * Но в задании указан массив, следовательно все опреации с ним.
     */

    private final Address[] addressesArray = {
            new Address("Russia", "Moscow", "Lenina", 12, 30),
            new Address("Russia", "Moscow", "Dzerjinskogo", 8, 14),
            new Address("Russia", "Taganrog", "Metallurgicheskaya", 13),
            new Address("Russia", "Moscow", "Shipilovskaya", 38, 321)
    };

    private final Human[] humansArray = {
            new Human("Dmitry", "Karchevsky", LocalDate.of(1999, 8, 29), addressesArray[0]),
            new Human("Andrey", "Ivanov", LocalDate.of(1999, 3, 17), addressesArray[1]),
            new Human("Kristina", "Petrova", LocalDate.of(2000, 1, 14), addressesArray[2]),
            new Human("Sergey", "Ivanov", LocalDate.of(1995, 1, 13), addressesArray[3]),
            new Human("Olga", "Klochkova", LocalDate.of(2010, 4, 25), addressesArray[3]),
    };


    public List<Human> findHumansBySurname(String surname){
        List<Human> humanList = new ArrayList<>();
        for (Human human : humansArray){
            if (human.getSurname().equalsIgnoreCase(surname))
                humanList.add(human);
        }
        return humanList;
    }

    public List<Human> findHumansByAddress(Address address){
        return Arrays.stream(humansArray).filter(x -> x.getAddress().equals(address)).collect(Collectors.toList());
    }

    public List<Human> findHumansBetweenTwoData(LocalDate date1, LocalDate date2){
        if (date1.compareTo(date2) > 0){
            LocalDate tempDate = date1;
            date1 = date2;
            date2 = tempDate;
        }
        /*
        * Variable used in Lambda expression must be final or effectively final
        * Как именно в таком решении обойтись без использования finalDate и finalDate1 я не придумал.
        */
        LocalDate finalDate = date1;
        LocalDate finalDate1 = date2;
        return Arrays.stream(humansArray).filter(x -> x.getBirthday().isAfter(finalDate) && x.getBirthday().isBefore(finalDate1)).collect(Collectors.toList());
    }

    public Human findOldestHuman(){
        return Arrays.stream(humansArray).min(Comparator.comparing(Human::getBirthday)).orElse(null);
    }

    public Human findYoungestHuman(){
        return Arrays.stream(humansArray).max(Comparator.comparing(Human::getBirthday)).orElse(null);
    }

    public List<Human> findHumansByStreet(String street){
        return Arrays.stream(humansArray).filter(x -> x.getAddress().getStreet().equalsIgnoreCase(street)).collect(Collectors.toList());
    }
}
