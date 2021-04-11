package taskfirst.adresshuman;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Address {
    @Id
    @Column (name = "id_address")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "country", length = 50, nullable = false)
    private String country;

    @Column (name = "city", length = 50, nullable = false)
    private String city;

    @Column (name = "street", length = 50, nullable = false)
    private String street;

    @Column (name = "numberHouse", nullable = false)
    private int numberHouse;

    @Column (name = "numberFlat")
    private int numberFlat;

    public Address(String country, String city, String street, int numberHouse, int numberFlat) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.numberHouse = numberHouse;
        this.numberFlat = numberFlat;
    }

    public Address(String country, String city, String street, int numberHouse) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.numberHouse = numberHouse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumberHouse() {
        return numberHouse;
    }

    public void setNumberHouse(int numberHouse) {
        this.numberHouse = numberHouse;
    }

    public int getNumberFlat() {
        return numberFlat;
    }

    public void setNumberFlat(int numberFlat) {
        this.numberFlat = numberFlat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return numberHouse == address.numberHouse &&
                numberFlat == address.numberFlat &&
                Objects.equals(country, address.country) &&
                Objects.equals(city, address.city) &&
                Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city, street, numberHouse, numberFlat);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", numberHouse=" + numberHouse +
                ", numberFlat=" + numberFlat +
                '}';
    }
}
