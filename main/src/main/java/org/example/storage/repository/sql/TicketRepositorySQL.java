package org.example.storage.repository.sql;

import org.example.model.dto.TicketSQL;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepositorySQL extends CrudRepository<TicketSQL, Long> {
}
