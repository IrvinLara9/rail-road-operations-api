package com.rail.road.operations.controller

import com.rail.road.operations.model.Cart
import com.rail.road.operations.model.Receiver
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*

@Controller("/sort")
class SortController {

    @Post("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    open fun sort(@Body carts: List<Cart>): List<Cart> {
        return carts.sortedWith(compareBy(Cart::destination, Cart::receiver))
    }

}