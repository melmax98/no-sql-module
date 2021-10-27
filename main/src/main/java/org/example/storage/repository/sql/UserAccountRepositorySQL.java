package org.example.storage.repository.sql;

import org.example.model.dto.UserAccountSQL;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
@ConditionalOnBean(DataSource.class)
public interface UserAccountRepositorySQL extends CrudRepository<UserAccountSQL, Long> {
}
