package com.example.persistence;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "building")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonbTransient
    private Long id;

    @Column(name = "building_identifier", nullable = false, unique = true, columnDefinition = "BINARY(16)")
    private UUID buildingIdentifier;

    @Embedded
    @Valid
    @NotNull
    private BuildingAddress address;

    public Building() {
    }

    public Building(Long id) {
        this.id = id;
    }

    public Building(BuildingAddress buildingAddress) {
        this.address = buildingAddress;
    }

    @PrePersist
    private void generateUUID() {
        buildingIdentifier = UUID.randomUUID();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BuildingAddress getAddress() {
        return address;
    }

    public void setAddress(BuildingAddress address) {
        this.address = address;
    }

    public UUID getBuildingIdentifier() {
        return buildingIdentifier;
    }

    public void setBuildingIdentifier(UUID buildingIdentifier) {
        this.buildingIdentifier = buildingIdentifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return Objects.equals(id, building.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", buildingIdentifier=" + buildingIdentifier +
                ", address=" + address +
                '}';
    }
}
