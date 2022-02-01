package com.rail.road.operations.service

import com.rail.road.operations.model.Destination
import com.rail.road.operations.repositories.DestinationRepo
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle
import org.mockito.Mockito
import org.mockito.Mockito.*
import java.util.*


@MicronautTest
@TestInstance(Lifecycle.PER_CLASS)
internal class DestinationServiceImplTest {

    @Inject
    lateinit var service: DestinationService
    @Inject
    lateinit var repo: DestinationRepo

    @Test
    fun testFindAll() {
        var all = service.findAll()
        Assertions.assertEquals(all.size, 3)
    }

    @BeforeAll
    fun before(){
        Mockito.`when`(repo.findAll()).thenReturn(listOf(Destination("",""), Destination("","") ,Destination("","")))
    }

    @MockBean(DestinationRepo::class)
    fun destinationRepo(): DestinationRepo? {
        return mock(DestinationRepo::class.java)
    }

}