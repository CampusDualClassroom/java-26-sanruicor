package com.campusdual.classroom;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class Contact implements ICallActions{

    private String name;
    private String surname;
    private String phoneNumber;
    private String code;
    private List<String> otherNumbers = new ArrayList<>();

    public Contact(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.code = generateCode();
    }

    public Contact(String name, String surname, String phoneNumber, List<String> otherNumbers) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.code = generateCode();
        this.otherNumbers = otherNumbers;
    }

    private String generateCode() {

        String codeSurname = cleanString(surname);

        String code = "";
        String[] names = name.split(" ");
        String[] codeSurnameSplit = codeSurname.split(" ");
        code += names[0].toLowerCase().charAt(0);

        if(codeSurnameSplit.length > 1) {
            code += codeSurnameSplit[0].toLowerCase().charAt(0);
            for(int i = 1; i < codeSurnameSplit.length; i++) {
                code += codeSurnameSplit[i].toLowerCase();
            }
        } else {
            code += codeSurnameSplit[0].toLowerCase();
        }

        return code;
    }

    @Override
    public void callMyNumber() {
        System.out.println("Está llamando a : " + name + " " + surname + ": " + phoneNumber);
    }

    @Override
    public void callOtherNumber(String number) {
        System.out.println("Está llamando a : " + name + " " + surname + ": " + number);
    }

    @Override
    public void showContactDetails() {
        System.out.println("Nombre: " + name);
        System.out.println("Apellidos: " + surname);
        System.out.println("Teléfono Principal: " + phoneNumber);
        if (!otherNumbers.isEmpty()) {
            System.out.println("Otros números: ");
            for (String number : otherNumbers) {
                System.out.println(number);
            }
        }
        System.out.println("Código: " + code);
    }

    public String getName() {
        return name;
    }

    public String getSurnames() {
        return surname;
    }

    public String getPhone() {
        return phoneNumber;
    }

    public List<String> getOtherNumbers() {
        return otherNumbers;
    }

    public String getCode() {
        return code;
    }

    public static String cleanString(String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return texto;
    }
}
