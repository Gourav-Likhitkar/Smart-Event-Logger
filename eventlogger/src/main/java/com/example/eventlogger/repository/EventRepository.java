package com.example.eventlogger.repository;

import com.example.eventlogger.model.UserEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<UserEvent, Long> {
}
