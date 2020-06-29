package com.example.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface BuildingRepository extends CrudRepository<Building, Long> {
    List<Building> findAll();

    @Query("FROM building b WHERE b.buildingIdentifier = :buildingIdentifier")
    Building findByBuildingIdentifier(@Param("buildingIdentifier") UUID buildingIdentifier);
}
