public class Person {
    public static final String MALE = "male";
    public static final String FEMALE = "female";

    private String name;
    private int age;
    private String sex;
    private Adress adress;

    public Person(Adress adress, String name, int age, String sex) {
        this.adress = adress;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public Adress getAdress() {
        return adress;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public void info() {
        System.out.println(name + " " + age + " " + sex + " " + adress);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", adreass='" + adress + '\'' +
                '}';
    }
}

