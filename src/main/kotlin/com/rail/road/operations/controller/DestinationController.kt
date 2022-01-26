package com.rail.road.operations.controller

import com.rail.road.operations.model.Destination
import com.rail.road.operations.service.DestinationService
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*


@Controller("/destinations")
class DestinationController(val service: DestinationService) {

    @Get("/")
    open fun findAll(): List<Destination> {
        return service.findAll()
    }

    @Get("/{name}")
    open fun find(name: String): Destination {
        return service.getByName(name)
    }

    @Post("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    open fun find(destination: Destination): Destination {
        service.save(destination)
        return destination
    }

    @Patch("/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    open fun update(destination: Destination, name: String) {
        service.update(destination, name)
    }

    @Delete("/{name}")
    open fun delete(name: String) {
        service.deleteByName(name)
    }

}