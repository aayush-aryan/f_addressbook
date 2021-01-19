package org.bridgelabz.addressbook;

import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to AddressBook");
        int choice;
        Controller controller = new Controller();
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("For Creating  Address Book press :1 ");
            System.out.println("For adding person press :2");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    controller.createaddressbook();
                    break;
                case 2:
                    controller.addperson();
                    break;
            }
        }while(choice !=2);
    }
}
