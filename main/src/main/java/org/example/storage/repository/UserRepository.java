package org.example.storage.repository;

import org.example.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {

    User findByEmail(String email);

    Page<User> findByName(String name, Pageable pageable);
}
