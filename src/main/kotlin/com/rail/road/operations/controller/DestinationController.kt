package com.rail.road.operations.controller

import com.rail.road.operations.model.Destination
import com.rail.road.operations.service.DestinationService
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*


@Controller("/")
class DestinationController(val service: DestinationService) {

    @Get("/destinations")
    open fun findAll(): ArrayList<Destination> {
        return service.findAll()
    }

    @Get("/destination/{name}")
    open fun find(name: String): Destination {

        return service.getById(name)
    }

    @Post("/destination/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    open fun find(destination: Destination): Destination {
        service.save(destination)
        return destination
    }

    @Patch("/destination/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    open fun update(destination: Destination, name: String) {
        service.update(destination, name)
    }

}