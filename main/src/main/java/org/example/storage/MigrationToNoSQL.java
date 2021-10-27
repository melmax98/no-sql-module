package org.example.storage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.storage.repository.EventRepository;
import org.example.storage.repository.TicketRepository;
import org.example.storage.repository.UserAccountRepository;
import org.example.storage.repository.UserRepository;
import org.example.storage.repository.sql.EventRepositorySQL;
import org.example.storage.repository.sql.TicketRepositorySQL;
import org.example.storage.repository.sql.UserAccountRepositorySQL;
import org.example.storage.repository.sql.UserRepositorySQL;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class MigrationToNoSQL implements CommandLineRunner {

    private final EntityMapper entityMapper;

    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final UserAccountRepository userAccountRepository;
    private final TicketRepository ticketRepository;

    private final EventRepositorySQL eventRepositorySQL;
    private final UserRepositorySQL userRepositorySQL;
    private final UserAccountRepositorySQL userAccountRepositorySQL;
    private final TicketRepositorySQL ticketRepositorySQL;

    @Override
    public void run(String... args) {
        try {
            eventRepositorySQL.findAll()
                    .forEach(eventSQL -> eventRepository.save(entityMapper.map(eventSQL)));

            userRepositorySQL.findAll()
                    .forEach(userSQL -> userRepository.save(entityMapper.map(userSQL)));

            userAccountRepositorySQL.findAll()
                    .forEach(userAccountSQL -> userAccountRepository.save(entityMapper.map(userAccountSQL)));

            ticketRepositorySQL.findAll()
                    .forEach(ticketSQL -> ticketRepository.save(entityMapper.map(ticketSQL)));
        } catch (Exception e) {
            log.error("Something went wrong while transferring information from SQL to NoSQL");
        }
    }
}
