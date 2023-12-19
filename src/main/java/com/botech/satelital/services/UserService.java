package com.botech.satelital.services;
import java.util.List;
import java.util.Optional;
import com.botech.satelital.models.entities.User;
import com.botech.satelital.models.entities.UserRequest;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(Long id);

    User save(User user);

    Optional<User> update(UserRequest user, Long id);

    void deleteById(Long id);
}
