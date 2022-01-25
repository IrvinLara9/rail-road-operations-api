package com.rail.road.operations.service

import com.rail.road.operations.DestinationRepo
import com.rail.road.operations.model.Destination
import jakarta.inject.Singleton
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import software.amazon.awssdk.services.dynamodb.model.AttributeValue

import java.net.URI


@Singleton
class DestinationServiceImpl (val repo: DestinationRepo): DestinationService {


    override fun findAll(): ArrayList<Destination> {
        return repo.findAll()
    }


    override fun getById(name: String): Destination {
        return repo.findById(name)
    }

    override fun save(destination: Destination) {
        repo.save(destination)
    }


}