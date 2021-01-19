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
            System.out.println("For updating press :3");
            System.out.println("For deleting existing person by using FirstName press:4");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    controller.createaddressbook();
                    break;
                case 2:
                    controller.addperson();
                    break;
                case 3:
                    controller.update();
                    break;
                case 4:
                    controller.delete();
                    break;
            }

        }while(choice !=5);
    }
}
