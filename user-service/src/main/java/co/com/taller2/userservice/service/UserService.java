package co.com.taller2.userservice.service;

import co.com.taller2.userservice.persistence.entity.User;

import java.util.List;

public interface UserService {

    void save(User user);

    void delete(long id);

    List<User> findAll();

    User findById(Long id);

}
