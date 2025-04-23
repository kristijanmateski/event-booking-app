package com.example.wp1.Data;

import com.example.wp1.model.Location;
import com.example.wp1.repository.jpa.LocationJpaRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final LocationJpaRepository locationJpaRepository;

    public DataInitializer(LocationJpaRepository locationJpaRepository) {
        this.locationJpaRepository = locationJpaRepository;
    }

    @PostConstruct
    public void init() {
        for (int i =1 ;i<=3;i++) {
            Location location = new Location("Location"+i,"address"+i,"capacity"+i,"description"+i);
            locationJpaRepository.save(location);
        }
    }
}
