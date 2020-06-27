package com.example.api;

import com.example.CounterBean;
import com.example.persistence.Building;
import com.example.persistence.BuildingRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/counter")
public class CounterEndpoint {
    private final CounterBean counterBean;

    public CounterEndpoint(CounterBean counterBean) {
        this.counterBean = counterBean;
    }

    @GET
    public int getCount() {
        return counterBean.get();
    }
}