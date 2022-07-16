package task2.model;

import java.util.ArrayList;
import java.util.List;

public class StorageUser {
    private static List<User> users = new ArrayList<>();

    public static List<User> getUsers() {
        return users;
    }

    public static void addUsers(User user) {
        users.add(user);
    }

    public static boolean checkUser(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static User getUser(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
