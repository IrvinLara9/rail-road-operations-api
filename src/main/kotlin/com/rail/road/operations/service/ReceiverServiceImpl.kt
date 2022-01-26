package com.rail.road.operations.service

import com.rail.road.operations.repositories.ReceiverRepo
import com.rail.road.operations.model.Receiver
import jakarta.inject.Singleton


@Singleton
class ReceiverServiceImpl(val repo: ReceiverRepo) : ReceiverService {


    override fun findAll(): List<Receiver> {
        return repo.findAll()
    }


    override fun getByName(name: String): Receiver {
        return repo.findByName(name)
    }

    override fun save(receiver: Receiver) {
        repo.save(receiver)
    }

    override fun update(receiver: Receiver, name: String) {
        receiver.name = name
        repo.update(receiver)
    }

    override fun deleteByName(name: String) {
        repo.deleteByName(name)
    }


}