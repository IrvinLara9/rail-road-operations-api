package com.rail.road.operations.service

import com.rail.road.operations.model.Destination

interface DestinationService {
    fun findAll(): ArrayList<Destination>

    fun getById(name: String): Destination

    fun save(destination: Destination)

    fun update(destination: Destination, name: String)
}