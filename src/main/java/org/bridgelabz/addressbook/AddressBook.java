package org.bridgelabz.addressbook;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.*;
public class AddressBook implements Service{

    int numberofaddressbook = 0;
    Map<String, List<Person>> map = new HashMap<>();
    String[] addressbook = new String[10];
    Scanner scanner = new Scanner(System.in);
    String key = "";

        @Override
        public void createaddressbook() {
            System.out.println("Enter the Name of Address Book you need to create");
            addressbook[numberofaddressbook] = scanner.next();
            map.put(addressbook[numberofaddressbook], new LinkedList<Person>());
            numberofaddressbook++;
            fileWriter();
            System.out.println("Address Book Created");

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

}
