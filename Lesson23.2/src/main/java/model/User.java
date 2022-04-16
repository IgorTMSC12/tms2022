package model;

public class User {

    private String email;
    private String password;

    {
        email = "user1@mail.ru";
        password = "qwerty123";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
