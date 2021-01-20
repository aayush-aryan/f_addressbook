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

    @Override
    public void update() {
        int ch = 0;
        char choice;

        System.out.println("LastnameEnter the Key");
        String keys = scanner.next();
        fileReader();
        List<Person> a = map.get(keys);
        System.out.println(a);
        System.out.println("Enter the phone number for updation");
        String phone = scanner.next();
        for (int index = 0; index < a.size(); index++) {
            String str = map.get(keys).get(index).getPhone();
            if (str.equalsIgnoreCase(phone)) {
                Person obj = map.get(keys).get(index);
                System.out.println(" select field if yoy have to edit..!");
                do {
                    System.out.println("1. Change Address");
                    System.out.println("2. Change City");
                    System.out.println("3. Change State");
                    System.out.println("4. Change Zipcode");
                    System.out.println("5. change Phone Number");

                    ch = scanner.nextInt();

                    switch (ch) {
                        case 1:
                            System.out.println("Enter your Address");
                            String address = scanner.next();
                            obj.setAddress(address);
                            fileWriter();
                            System.out.println("Address Updated");
                            break;
                        case 2:
                            System.out.println("Enter your City ");
                            String city = scanner.next();
                            obj.setCity(city);
                            fileWriter();
                            System.out.println("City Updated");
                            break;
                        case 3:
                            System.out.println("Enter your State");
                            String state = scanner.next();
                            obj.setState(state);
                            fileWriter();
                            System.out.println("State Updated");
                            break;
                        case 4:
                            System.out.println("Enter Your Zipcode");
                            String zipcode = scanner.next();
                            obj.setZip(zipcode);
                            fileWriter();
                            System.out.println("Zipcode Updated");
                            break;
                        case 5:
                            System.out.println("Enter Phone Number");
                            String phone1 = scanner.next();
                            obj.setPhone(phone1);
                            fileWriter();
                            System.out.println("Phone Number Updated");
                            break;

                    }

                    System.out.println("Do You want to continue");
                    choice = scanner.next().charAt(0);

                } while (choice == 'Y' || choice == 'y');
            } else {
                System.out.println("Contact doesn't exist");
            }

        }
    }
    @Override
    public void delete() {
        String keys;

        System.out.println("Enter the key");
        keys = scanner.next();
        fileReader();
        List<Person> list = map.get(keys);

        System.out.println("Enter the FirstName you need to delete");
        String number = scanner.next();
        for (int index = 0; index < list.size(); index++) {
            if (number.equals(list.get(index).getFirstname())) {
                list.remove(index);
            }
        }

        fileWriter();
    }
    @Override
    public void addingMultiplePerson() {
        System.out.println("enter the number of Person you have to add in addressBooK");
        int numberOfPerson = scanner.nextInt();
        for(int index=0;index < numberOfPerson;index++){
            addperson();
        }

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
