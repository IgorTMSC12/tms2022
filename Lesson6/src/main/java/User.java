public class User {
    private String name;
    private String lastname;
    private String sex;
    private int age;

    public User(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public User(String sex) {
        this.sex = sex;
    }

    public User(String sex, int age) {
        this(sex);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Deprecated
    public void info() {
        System.out.println(name + " " + lastname + " " + age + " " + sex);
    }
}
