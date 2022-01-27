package com.rail.road.operations.controller

import com.rail.road.operations.model.Cart
import com.rail.road.operations.service.DestinationService
import com.rail.road.operations.service.SortService
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*

@Controller("/sort")
class SortController(val sortService: SortService) {

    @Post("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    open fun sort(@Body carts: List<Cart>): List<Cart> {
        return sortService.sort(carts)
    }

}