package org.bridgelabz.addressbook;

public class Controller {

    Service service = new AddressBook();
    public void createaddressbook() {
        service.createaddressbook();

    }
    public void addperson() {
        service.addperson();
    }
    public void update()
    {
        service.update();
    }
    public void delete()
    {
        service.delete();
    }
    public void addingMultiplePerson() {
        service.addingMultiplePerson();
    }
    public void search() {
        service.search();
    }
}
