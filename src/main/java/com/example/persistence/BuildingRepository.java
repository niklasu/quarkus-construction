package com.example.persistence;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface BuildingRepository extends CrudRepository<Building, Long> {
    List<Building> findAll();
    Building findByBuildingIdentifier(UUID buildingIdentifier);
}
