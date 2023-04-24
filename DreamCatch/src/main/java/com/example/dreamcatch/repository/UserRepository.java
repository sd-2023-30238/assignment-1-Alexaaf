package com.example.dreamcatch.repository;

import com.example.dreamcatch.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long > {
    @Override
    User save (User user);

    User findUserByEmailAndPassword(String email,String password);
}
