package com.example.wp1.service.impl;

import com.example.wp1.model.Location;
import com.example.wp1.repository.jpa.LocationJpaRepository;
import com.example.wp1.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationJpaRepository locationJpaRepository;

    public LocationServiceImpl(LocationJpaRepository locationJpaRepository) {
        this.locationJpaRepository = locationJpaRepository;
    }


    @Override
    public List<Location> findAll() {
        return locationJpaRepository.findAll();
    }
}
