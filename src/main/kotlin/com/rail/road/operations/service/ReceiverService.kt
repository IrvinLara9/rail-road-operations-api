package com.rail.road.operations.service

import com.rail.road.operations.model.Receiver

interface ReceiverService {
    fun findAll(): List<Receiver>

    fun getByName(name: String): Receiver

    fun save(receiver: Receiver)

    fun update(receiver: Receiver, name: String)

    fun deleteByName(name: String)
}