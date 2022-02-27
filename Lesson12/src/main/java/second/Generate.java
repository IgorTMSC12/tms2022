package second;

public class Generate {
    public boolean checkAuthorization(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        boolean loginPassword = false;
        if (login.length() < 20) {
            if (password.length() < 20) {
                if (password.equals(confirmPassword)) {
                    System.out.println("Пароль и логин введён верно");
                    return loginPassword = true;
                }
            } else {
                throw new WrongPasswordException("Ошибка. Пароль больше 20 символов");
            }
        } else {
            throw new WrongLoginException("Ошибка. Логин больше 20 символов");
        }
        return loginPassword;
    }
}
