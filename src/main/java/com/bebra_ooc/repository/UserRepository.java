package com.bebra_ooc.repository;

import com.bebra_ooc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findById(long id);

    void deleteById(long id);

    User save(User user);
}
