public class PersonRegistry {
    private Person[] people;

    public PersonRegistry(Person[] people) {
        this.people = people;
    }

    public Person[] getPeople() {
        return people;
    }
}