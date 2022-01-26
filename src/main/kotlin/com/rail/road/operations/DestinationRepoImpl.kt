package com.rail.road.operations

import com.rail.road.operations.model.Destination
import jakarta.inject.Singleton
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable
import software.amazon.awssdk.enhanced.dynamodb.Key
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import software.amazon.awssdk.enhanced.dynamodb.model.UpdateItemEnhancedRequest
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import software.amazon.awssdk.services.dynamodb.model.AttributeValue
import software.amazon.awssdk.services.dynamodb.model.UpdateItemRequest
import software.amazon.awssdk.services.dynamodb.model.UpdateItemResponse
import java.net.URI
import java.util.concurrent.CompletableFuture


@Singleton
class DestinationRepoImpl : DestinationRepo {

    val table: DynamoDbTable<Destination> = dynamoDbTable()

    override fun findAll(): ArrayList<Destination> {
        val destinations = ArrayList<Destination>()
        val results = table.scan().items().iterator()
        while (results.hasNext()) {
            destinations.add(results.next())
        }
        return destinations
    }

    override fun findById(name: String): Destination {
        val key = getKey(name)
        return table.getItem { r -> r.key(key) }
    }


    override fun save(destination: Destination) {
        table.putItem(destination)
    }

    override fun deleteById(name: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun update(destination: Destination) {
        table.updateItem(destination)
    }


    private fun dynamoDbTable(): DynamoDbTable<Destination> {

        val region = Region.of("us-east-1")

        val dynamoDbClient = DynamoDbClient.builder()
            .endpointOverride(URI.create("http://localhost:8000"))
            .region(region)
            .build()
        val dynamoDbClientEnhancedClient = DynamoDbEnhancedClient.builder()
            .dynamoDbClient(dynamoDbClient)
            .build()

        return dynamoDbClientEnhancedClient
            .table("Train", TableSchema.fromBean(Destination::class.java))
    }

    private fun getKey(name: String): Key? {
        val key = Key.builder()
            .partitionValue(AttributeValue.builder().s("destination").build())
            .sortValue(AttributeValue.builder().s(name).build())
            .build()
        return key
    }

}