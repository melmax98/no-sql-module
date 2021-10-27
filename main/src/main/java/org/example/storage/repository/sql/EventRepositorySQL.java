package org.example.storage.repository.sql;

import org.example.model.dto.EventSQL;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepositorySQL extends CrudRepository<EventSQL, Long> {
}