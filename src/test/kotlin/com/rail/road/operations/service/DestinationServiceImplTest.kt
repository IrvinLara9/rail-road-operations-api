package com.rail.road.operations.service

import com.rail.road.operations.model.Destination
import com.rail.road.operations.repositories.DestinationRepo
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

import org.mockito.Mockito.*


@MicronautTest
internal class DestinationServiceImplTest {

    @Inject
    lateinit var service: DestinationService

    @Inject
    lateinit var repo: DestinationRepo

    @Test
    fun testFindAll() {
        `when`(repo.findAll()).thenReturn(listOf(Destination("", ""), Destination("", ""), Destination("", "")))

        val all = service.findAll()

        Assertions.assertEquals(3, all.size)
    }

    @Test
    fun getByName() {
        val name = "someName"
        `when`(repo.findByName(name)).thenReturn(Destination("Destination", name))

        val one = service.getByName(name)

        Assertions.assertEquals(name, one.name)
    }

    @Test
    fun save() {
        val destination: Destination = Destination(name = "coolName")
        `when`(repo.save(destination)).thenReturn(destination)

        val saved = service.save(destination)

        Assertions.assertEquals(destination, saved)
    }

    @MockBean(DestinationRepo::class)
    fun destinationRepo(): DestinationRepo? {
        return mock(DestinationRepo::class.java)
    }

}