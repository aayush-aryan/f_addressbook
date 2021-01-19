package org.bridgelabz.addressbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
public class AddressBook implements Service{

    int numberofaddressbook = 0;
    Map<String, List<Person>> map = new HashMap<>();
    String[] addressbook = new String[10];
    Scanner scanner = new Scanner(System.in);
    String key = "";
    Person person;

        @Override
        public void createaddressbook() {
            System.out.println("Enter the Name of Address Book you need to create");
            addressbook[numberofaddressbook] = scanner.next();
            map.put(addressbook[numberofaddressbook], new LinkedList<Person>());
            numberofaddressbook++;
            fileWriter();
            System.out.println("Address Book Created");

        }

    @Override
    public void addperson() {
        fileReader();
        if (numberofaddressbook == 0) {
            System.out.println("There is no addressBook if you want to create presss 1;");
            int press = scanner.nextInt();

            if (press == 1) {
                createaddressbook();

            } else {
                return;
            }

        }
        for (int select = 0; select < numberofaddressbook; select++) {
            System.out.println(select + " " + addressbook[select]);
        }
        System.out.println("Select Your addressBook");
        int select = scanner.nextInt();
        key = addressbook[select];
        person = new Person();

        System.out.println("Enter the First name");
        String firstname = scanner.next();
        person.setFirstname(firstname);

        System.out.println("Enter the Last name");
        String lastname = scanner.next();
        person.setLastname(lastname);

        System.out.println("Enter your Address");
        String address = scanner.next();
        person.setAddress(address);

        System.out.println("Enter your City");
        String city = scanner.next();
        person.setCity(city);

        System.out.println("Enter your State");
        String state = scanner.next();
        person.setState(state);

        System.out.println("Enter your Zip Code");
        String zipcode = scanner.next();
        person.setZip(zipcode);

        System.out.println("Enter your Phone Number");
        String phone = scanner.next();
        person.setPhone(phone);

        List<Person> a = map.get(key);

        a.add(person);
        map.put(key, a);
        fileWriter();

    }

        private void fileWriter() {
            FileOutputStream fileoutputstream ;
            try {
                fileoutputstream = new FileOutputStream("store.csv");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileoutputstream);
                objectOutputStream.writeObject(map);
                objectOutputStream.writeObject(addressbook);
                objectOutputStream.writeInt(numberofaddressbook);
                objectOutputStream.writeObject(key);
                objectOutputStream.flush();
                objectOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public void fileReader() {
        try {
            FileInputStream fileInputStream = new FileInputStream("store.csv");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            map = (HashMap) objectInputStream.readObject();

            addressbook = (String[]) objectInputStream.readObject();
            numberofaddressbook = objectInputStream.readInt();
            key = (String) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
