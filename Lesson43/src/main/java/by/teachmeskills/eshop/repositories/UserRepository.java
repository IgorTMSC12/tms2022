package by.teachmeskills.eshop.repositories;

import by.teachmeskills.eshop.entities.User;

public interface UserRepository extends BaseRepository<User> {

    User getUserByLoginAndPass(String login, String pass);
}