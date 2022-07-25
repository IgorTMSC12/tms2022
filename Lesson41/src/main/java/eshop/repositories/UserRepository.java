package eshop.repositories;

import eshop.entities.User;

public interface UserRepository extends BaseRepository<User> {
    User getUserByLoginAndPass(String login, String pass);
}
