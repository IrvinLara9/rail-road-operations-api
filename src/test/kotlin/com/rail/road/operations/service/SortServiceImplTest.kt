package com.rail.road.operations.service

import com.rail.road.operations.model.Cart
import com.rail.road.operations.model.Destination
import com.rail.road.operations.model.Receiver
import com.rail.road.operations.repositories.DestinationRepo
import com.rail.road.operations.repositories.ReceiverRepo
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.Mockito

@MicronautTest
internal class SortServiceImplTest {

    @Inject
    lateinit var service: SortService

    @Inject
    lateinit var destinationRepo: DestinationRepo

    @Inject
    lateinit var receiverRepo: ReceiverRepo

    @Test
    fun sort() {
        Mockito.`when`(destinationRepo.findAll()).thenReturn(listOf(Destination(name = "d1", priority = 1), Destination(name = "d2", priority = 2), Destination(name = "d3", priority = 3)))
        Mockito.`when`(receiverRepo.findAll()).thenReturn(listOf(Receiver(name = "r1", priority = 1), Receiver(name = "r2", priority = 2), Receiver(name = "r3", priority = 1)))

        val c1 = Cart("Car 1", "d2", "r1")
        val c2 = Cart("Car 2", "d3", "r2")
        val c3 = Cart("Car 3", "d1", "r3")

        val carts = listOf(c1, c2, c3)

        val sorted = service.sort(carts)

        val expected = listOf(c3, c1, c2)

        val pairs = expected zip sorted

        pairs.forEach {
            pair ->  assertEquals(pair.first, pair.second)
        }

      //  assertEquals(listOf(c3, c1, c2), sorted)
    }

    @MockBean(DestinationRepo::class)
    fun destinationRepo(): DestinationRepo? {
        return Mockito.mock(DestinationRepo::class.java)
    }

    @MockBean(ReceiverRepo::class)
    fun receiverRepo(): ReceiverRepo? {
        return Mockito.mock(ReceiverRepo::class.java)
    }


}