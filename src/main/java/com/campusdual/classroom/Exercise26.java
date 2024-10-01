package com.campusdual.classroom;


public class Exercise26 {
    public static void main(String[] args) {
        Contact c1 = new Contact("Adela","Santalla", "666777888");
        Contact c2 = new Contact("Javier","López", "123456789");
        Contact c3 = new Contact("Carlos","Fernandez-Simón", "234567890");
        Contact c4 = new Contact("Jose Manuel","Soria", "345678901");

        Phonebook p = new Phonebook();
        p.addContact(c1);
        p.addContact(c2);
        p.addContact(c3);
        p.addContact(c4);

        p.showContactMenu();
    }
}
