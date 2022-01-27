package com.rail.road.operations.service

import com.rail.road.operations.model.Cart

interface SortService {

    fun sort(carts: List<Cart>): List<Cart>

}