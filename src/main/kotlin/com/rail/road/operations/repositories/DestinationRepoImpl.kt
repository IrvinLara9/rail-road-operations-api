package com.rail.road.operations.repositories

import com.rail.road.operations.model.Destination
import jakarta.inject.Singleton
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable
import software.amazon.awssdk.enhanced.dynamodb.Key
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import software.amazon.awssdk.services.dynamodb.model.AttributeValue
import java.net.URI

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

    override fun findByName(name: String): Destination {
        val key = Key.builder()
            .partitionValue(AttributeValue.builder().s("destination").build())
            .sortValue(AttributeValue.builder().s(name).build())
            .build()
        return table.getItem { r -> r.  key(key) }
    }

    override fun save(destination: Destination) {
        table.putItem(destination)
    }

    override fun deleteByName(name: String): Destination? {
        val key = Key.builder()
            .partitionValue(AttributeValue.builder().s("destination").build())
            .sortValue(AttributeValue.builder().s(name).build())
            .build()
        return table.deleteItem { r -> r.key(key) }
    }

    override fun update(destination: Destination): Boolean {
        TODO("Not yet implemented")
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
}