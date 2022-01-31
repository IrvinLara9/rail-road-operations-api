package com.rail.road.operations.service

import com.rail.road.operations.model.Destination

interface DestinationService {

    fun findAll(): List<Destination>

    fun getByName(name: String): Destination

    fun save(destination: Destination)

    fun update(destination: Destination, name: String, priority: Int): Destination

    fun deleteByName(name: String): Boolean

}