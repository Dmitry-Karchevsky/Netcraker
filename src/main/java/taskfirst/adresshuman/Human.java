package taskfirst.adresshuman;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
public class Human {
    @Id
    @Column (name = "id_human")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "name", length = 50, nullable = false)
    private String name;

    @Column (name = "surname", length = 50, nullable = false)
    private String surname;

    @Column (name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column (name = "age", nullable = false)
    private int age;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "id_address")
    private Address address;

    public Human(String name, String surname, LocalDate birthday, Address address) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        age = Period.between(birthday, LocalDate.now()).getYears();
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
