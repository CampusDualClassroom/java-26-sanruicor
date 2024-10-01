package com.campusdual.classroom;

import java.util.Map;

import com.campusdual.util.Utils;

public class Phonebook {

    public Map<String, Contact> phonebook = new java.util.HashMap<>();

    public void addContact(Contact contact) {
        phonebook.put(contact.getCode(), contact);
    }

    public void deleteContact(String code) {
        phonebook.remove(code);
    }

    public void showPhonebook() {
        for (Map.Entry<String, Contact> entry : phonebook.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getName() + " " + entry.getValue().getSurnames() + " : " + entry.getValue().getPhone());
        }
    }

    public void showContactMenu() {
        int option;
        String myCode;
        String code = "";

            int numero = Utils.integer("Introduce tu número de teléfono: ");
            myCode = getCode(numero);

            do {
            System.out.println("1. Llamar a su número");
            System.out.println("2. Llamar a otro número");
            System.out.println("3. Mostrar detalles del contacto");
            System.out.println("4. Salir");
            option = Utils.integer("Introduce una opción: ");
            switch (option) {
                case 1:
                    phonebook.get(myCode).callMyNumber();
                    break;
                case 2:
                    int anotherNumber = Utils.integer("Introduce el número al que quieres llamar: ");
                    code = getCode(anotherNumber);
                    phonebook.get(code).callOtherNumber(String.valueOf(anotherNumber));
                    break;
                case 3:
                    phonebook.get(code).showContactDetails();
                    break;
                case 4:
                    break;
            }

        } while (option != 4);

    }

    private String getCode(int number) {
        String code = "";
        for (Map.Entry<String, Contact> entry : phonebook.entrySet()) {
            if (entry.getValue().getPhone().equals(String.valueOf(number))) {
                code = entry.getKey();
            }
        }
        return code;
    }


    public Map<String, Contact> getData() {
            return phonebook;
    }

}
