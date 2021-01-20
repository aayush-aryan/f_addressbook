package org.bridgelabz.addressbook;

import java.io.Serializable;
import java.util.Comparator;

public class Person implements Serializable {
    private String firstname;
    private String lastname;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public static Comparator<Person> sortbyname;

    static {
        sortbyname = (person1, person2) -> {
            String FirstName1 = person1.getLastname();
            String FirstName2 = person2.getLastname();

            return FirstName1.compareTo(FirstName2);

        };
    }

    public static Comparator<Person> sortbyCity;

    static {
        sortbyCity = (person1, person2) -> {
            String FirstName1 = person1.getCity();
            String FirstName2 = person2.getCity();

            return FirstName1.compareTo(FirstName2);

        };
    }
}
