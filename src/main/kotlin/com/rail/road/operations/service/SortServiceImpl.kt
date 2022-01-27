package com.rail.road.operations.service

import com.rail.road.operations.model.Cart
import com.rail.road.operations.repositories.DestinationRepo
import com.rail.road.operations.repositories.ReceiverRepo
import jakarta.inject.Singleton


@Singleton
class SortServiceImpl(val destinationRepo: DestinationRepo, val receiverRepo: ReceiverRepo) : SortService {

    override fun sort(carts: List<Cart>): List<Cart> {
        carts.forEach {
            it.destinationPriority = destinationRepo.findByName(it.destination).priority
            it.receiverPriority = receiverRepo.findByName(it.receiver).priority
        }

        return carts.sortedWith(compareBy(Cart::destinationPriority, Cart::receiverPriority))
    }

}