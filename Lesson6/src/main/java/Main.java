public class Main {
    public static void main(String[] args) {
        User user = new User("Игорь", "Михаевич");
        user.setAge(24);
        user.info();

        User user1 = new User("man", 24);
        user1.info();
    }
}
