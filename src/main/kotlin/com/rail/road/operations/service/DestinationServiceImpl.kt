package com.rail.road.operations.service

import com.rail.road.operations.repositories.DestinationRepo
import com.rail.road.operations.model.Destination
import jakarta.inject.Singleton


@Singleton
class DestinationServiceImpl(val repo: DestinationRepo) : DestinationService {


    override fun findAll(): ArrayList<Destination> {
        return repo.findAll()
    }


    override fun getByName(name: String): Destination {
        return repo.findByName(name)
    }

    override fun save(destination: Destination) {
        repo.save(destination)
    }

    override fun update(destination: Destination, name: String) {
        destination.name = name
        repo.update(destination)
    }


}