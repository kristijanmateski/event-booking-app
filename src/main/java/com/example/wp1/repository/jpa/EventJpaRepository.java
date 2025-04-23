package com.example.wp1.repository.jpa;

import com.example.wp1.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventJpaRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByLocationId(Long locationId);
}
