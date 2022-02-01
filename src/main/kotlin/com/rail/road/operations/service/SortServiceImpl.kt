package com.rail.road.operations.service

import com.rail.road.operations.model.Cart
import com.rail.road.operations.repositories.DestinationRepo
import com.rail.road.operations.repositories.ReceiverRepo
import jakarta.inject.Singleton


@Singleton
class SortServiceImpl(val destinationRepo: DestinationRepo, val receiverRepo: ReceiverRepo) : SortService {

    override fun sort(carts: List<Cart>): List<Cart> {

        val receivers = receiverRepo.findAll().map { it.name to it.priority }.toMap()
        val destinations = destinationRepo.findAll().map { it.name to it.priority }.toMap()

        carts.forEach {
            it.destinationPriority = destinations.get(it.destination)
            it.receiverPriority = receivers.get(it.receiver)
        }

        return carts.sortedWith(compareBy(Cart::destinationPriority, Cart::receiverPriority))
    }

}