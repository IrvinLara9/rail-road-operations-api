package com.rail.road.operations.repositories

import com.rail.road.operations.model.Destination

interface DestinationRepo {

    fun findAll(): List<Destination>

    fun findByName(name: String): Destination

    fun save(destination: Destination)

    fun deleteByName(name: String): Destination?

    fun update(destination: Destination)
}