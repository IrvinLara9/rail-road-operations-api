package com.rail.road.operations.service

import com.rail.road.operations.repositories.DestinationRepo
import io.micronaut.context.annotation.Requires
import io.micronaut.core.util.StringUtils
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Test


@MicronautTest
@Requires(property = "mockito.test.enabled", defaultValue = StringUtils.FALSE, value = StringUtils.TRUE)
internal class DestinationServiceImplTest {

    @Inject
    var destinationRepo : DestinationRepo? = null

//    @BeforeEach
//    fun setUp() {
//        MockitoAnnotations.openMocks(this)
//    }
//
//    @Mock
//    lateinit var destinationRepo : DestinationRepo
//
//    @InjectMocks
//    lateinit var destinationServiceImpl : DestinationServiceImpl

    @Test
    fun findAll() {

    }

    @Test
    fun getByName() {
    }

    @Test
    fun save() {
    }

    @Test
    fun update() {
    }

    @Test
    fun deleteByName() {
    }

    @Test
    fun getRepo() {

    }
}