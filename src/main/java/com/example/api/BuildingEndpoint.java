package com.example.api;

import com.example.persistence.Building;
import com.example.persistence.BuildingRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/buildings")
public class BuildingEndpoint {
    private final BuildingRepository buildingRepository;

    public BuildingEndpoint(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Building create(Building building) {
        return buildingRepository.save(building);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{buildingId}")
    public Building getByBuildingId(@PathParam("buildingId") Long buildingId) {
        return buildingRepository.findById(buildingId).orElseThrow(() -> new NotFoundException("Building id " + buildingId + " not found"));
    }


}