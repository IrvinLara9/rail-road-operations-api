package com.rail.road.operations.service

import com.rail.road.operations.repositories.DestinationRepo
import com.rail.road.operations.model.Destination
import jakarta.inject.Singleton


@Singleton
class DestinationServiceImpl (val repo: DestinationRepo): DestinationService {


    override fun findAll(): ArrayList<Destination> {
        return repo.findAll()
    }


    override fun getById(name: String): Destination {
        return repo.findById(name)
    }

    override fun save(destination: Destination) {
        repo.save(destination)
    }


}