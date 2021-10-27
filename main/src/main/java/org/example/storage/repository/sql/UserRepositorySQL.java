package org.example.storage.repository.sql;

import org.example.model.dto.UserSQL;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositorySQL extends CrudRepository<UserSQL, Long> {
}
