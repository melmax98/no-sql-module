package org.example.storage.repository.sql;

import org.example.model.dto.UserAccountSQL;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepositorySQL extends CrudRepository<UserAccountSQL, Long> {
}
