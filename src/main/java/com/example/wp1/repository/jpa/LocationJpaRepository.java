package com.example.wp1.repository.jpa;

import com.example.wp1.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationJpaRepository extends JpaRepository<Location, Long> {
}
