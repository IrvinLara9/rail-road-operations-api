package com.rail.road.operations

import com.rail.road.operations.model.Destination

interface DestinationRepo {

    fun findAll(): ArrayList<Destination>

    fun findById(name: String): Destination

    fun save(destination: Destination)

    fun deleteById(name: String): Boolean

    fun update(destination: Destination): Boolean
}