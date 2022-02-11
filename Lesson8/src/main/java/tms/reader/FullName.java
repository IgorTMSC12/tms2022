package tms.reader;

public class FullName {
    private String name;
    private String lastname;
    private String surname;


    public FullName(String name, String lastname, String surname) {
        this.name = name;
        this.lastname = lastname;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "FullName{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
