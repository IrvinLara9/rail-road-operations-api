package com.rail.road.operations.controllers

import com.google.gson.Gson
import com.rail.road.operations.model.Destination
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.*

@MicronautTest
class DestinationControllerTest() {

    @Inject
    @field:Client("/destinations")
    lateinit var client : HttpClient

    @BeforeEach
    fun setup() {
        println("setup")
    }

    @Test
    fun testFindAll() {
        println("findAll")
        val request: HttpRequest<Any> = HttpRequest.GET("/")
        val body = client.toBlocking().retrieve(request)

        Assertions.assertNotNull(body)
    }

    @Test
    fun testSave() {
        println("save")
        val destination = Destination("destination", "test", 10)

        val request: HttpRequest<Any> = HttpRequest.POST("/", destination)
        val body = client.toBlocking().retrieve(request)

        Assertions.assertNotNull(body)
        Assertions.assertEquals(Gson().toJson(destination).toString(), body)
    }

    @Test
    fun testUpdate() {
        println("update")
        val destination = Destination("destination", "test", 20)

        val request: HttpRequest<Any> = HttpRequest.PATCH("/test", destination)
        val body = client.toBlocking().retrieve(request)

        Assertions.assertNotNull(body)
        Assertions.assertEquals(Gson().toJson(destination).toString(), body)
    }

    @Test
    fun testDelete() {
        println("delete")
        val request: HttpRequest<Any> = HttpRequest.DELETE("/test")
        val body = client.toBlocking().retrieve(request)

        Assertions.assertNotNull(body)
        Assertions.assertEquals("true", body)
    }

}