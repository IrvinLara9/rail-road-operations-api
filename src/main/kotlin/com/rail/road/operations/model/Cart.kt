package com.rail.road.operations.model

import com.fasterxml.jackson.annotation.JsonIgnore

data class Cart(
    val name: String, val destination: String,
    val receiver: String,
    var destinationPriority: Int? = null,
    @get:JsonIgnore
    var receiverPriority: Int? = null
)