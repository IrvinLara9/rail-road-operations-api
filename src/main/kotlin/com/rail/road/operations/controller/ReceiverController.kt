package com.rail.road.operations.controller

import com.rail.road.operations.model.Destination
import com.rail.road.operations.model.Receiver
import com.rail.road.operations.service.ReceiverService
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*

@Controller("/receivers")
class ReceiverController(val service: ReceiverService) {

    @Get("/")
    open fun findAll(): List<Receiver> {
        return service.findAll()
    }

    @Get("/{name}")
    open fun find(name: String): Receiver {
        return service.getByName(name)
    }

    @Post("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    open fun save(receiver: Receiver): Receiver {
        service.save(receiver)
        return receiver
    }

    @Patch("/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    open fun update(receiver: Receiver, name: String, priority: Int): Receiver {
        return service.update(receiver, name, priority)
    }

    @Delete("/{name}")
    open fun delete(name: String): Boolean {
        return service.deleteByName(name)
    }

}