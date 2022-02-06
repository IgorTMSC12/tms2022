public class MilitaryOffice {
    PersonRegistry personRegistry;

    public MilitaryOffice(PersonRegistry personRegistry) {
        this.personRegistry = personRegistry;
    }

    public Person[] findBy() {
        Person[] result = new Person[personRegistry.getPeople().length];
        for (int i = 0; i < personRegistry.getPeople().length; i++) {
            Person person = personRegistry.getPeople()[i];
            if (person.getAge() >= 18 && person.getAge() <= 27 && person.getSex() == Person.MALE) {
                result[i] = person;
            }
        }
        return result;
    }

    public int findByTown(String town) {
        int count = 0;
        for (int i = 0; i < personRegistry.getPeople().length; i++) {
            Person person = personRegistry.getPeople()[i];
            if (town.equals(person.getAdress().getTown()) && person.getAge() >= 18 && person.getAge() <= 27 && person.getSex() == Person.MALE) {
                count++;
            }
        }
        return count;
    }

    public int findByAge() {
        int count = 0;
        for (int i = 0; i < personRegistry.getPeople().length; i++) {
            Person person = personRegistry.getPeople()[i];
            if (person.getAge() <= 27 && person.getSex() == Person.MALE) {
                count++;
            }
        }
        return count;
    }

    public int findByName(String name) {
        int count = 0;
        for (int i = 0; i < personRegistry.getPeople().length; i++) {
            Person person = personRegistry.getPeople()[i];
            if (person.getAge() <= 27 && person.getSex() == Person.MALE && name.equals(person.getName())) {
                count++;
            }
        }
        return count;
    }

}

