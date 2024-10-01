package com.campusdual.classroom;

import java.text.Normalizer;

public class Contact implements ICallActions{

    private String name;
    private String surname;
    private String phoneNumber;
    private String code;

    public Contact(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.code = generateCode();
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
        System.out.println("Teléfono: " + phoneNumber);
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

    public String getCode() {
        return code;
    }

    public static String cleanString(String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return texto;
    }
}
