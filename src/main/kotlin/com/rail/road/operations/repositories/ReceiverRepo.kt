package com.rail.road.operations.repositories

import com.rail.road.operations.model.Receiver

interface ReceiverRepo {

    fun findAll(): List<Receiver>

    fun findByName(name: String): Receiver

    fun save(receiver: Receiver)

    fun deleteByName(name: String): Receiver?

    fun update(receiver: Receiver): Receiver
}