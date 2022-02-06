import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Adress adressperson1 = new Adress("Belarus", "Minsk");
        Person person1 = new Person(adressperson1, "Igor", 20, Person.MALE);

        Adress adressperson2 = new Adress("Russ", "Gantsevichi");
        Person person2 = new Person(adressperson2, "Nikita", 16, Person.MALE);

        Adress adressperson3 = new Adress("Belarus", "Slytsk");
        Person person3 = new Person(adressperson3, "Natalia", 44, Person.FEMALE);

        Adress adressperson4 = new Adress("Belarus", "Minsk");
        Person person4 = new Person(adressperson4, "Darya", 23, Person.FEMALE);

        Adress adressperson5 = new Adress("Belarus", "Minsk");
        Person person5 = new Person(adressperson5, "Dima", 30, Person.MALE);

        Adress adressperson6 = new Adress("Belarus", "Minsk");
        Person person6 = new Person(adressperson6, "Alexander", 26, Person.MALE);

        Person[] people = new Person[]{person1, person2, person3, person4, person5, person6};
        PersonRegistry asd = new PersonRegistry(people);
        MilitaryOffice afs = new MilitaryOffice(asd);

        System.out.println(Arrays.toString(afs.findBy()));
        System.out.println("Количество годных призывников в городе Минске: " + afs.findByTown("Minsk"));
        System.out.println("Количество призывников от 25 до 27 лет: " + afs.findByAge());
        System.out.println("Количество призывников у которых имя Александр: " + afs.findByName("Alexander"));
    }


}
