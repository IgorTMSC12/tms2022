package tms.reader;

import lombok.ToString;

@ToString
public class FullName {
    private String name;
    private String lastname;
    private String surname;


    public FullName(String name, String lastname, String surname) {
        this.name = name;
        this.lastname = lastname;
        this.surname = surname;
    }

}
