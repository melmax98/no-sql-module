package org.example.storage.repository;

import org.example.model.User;
import org.example.model.UserAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends MongoRepository<UserAccount, Long> {

    Optional<UserAccount> findByUser(User user);
}
