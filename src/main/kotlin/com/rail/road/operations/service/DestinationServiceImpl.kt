package com.rail.road.operations.service

import com.rail.road.operations.repositories.DestinationRepo
import com.rail.road.operations.model.Destination
import jakarta.inject.Singleton


@Singleton
class DestinationServiceImpl(val repo: DestinationRepo) : DestinationService {

    override fun findAll(): List<Destination> {
        return repo.findAll()
    }

    override fun getByName(name: String): Destination {
        return repo.findByName(name)
    }

    override fun save(destination: Destination) {
        repo.save(destination)
    }

    override fun update(destination: Destination, name: String): Destination {
        destination.name = name

        return repo.update(destination)
    }

    override fun deleteByName(name: String): Boolean {
        if (repo.deleteByName(name) != null) {
            return true
        }
        return false
    }

}