package com.rail.road.operations.repositories

import com.rail.road.operations.model.Destination
import com.rail.road.operations.model.Receiver
import jakarta.inject.Singleton
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable
import software.amazon.awssdk.enhanced.dynamodb.Key
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import software.amazon.awssdk.services.dynamodb.model.AttributeValue
import java.net.URI


@Singleton
class ReceiverRepoImpl : ReceiverRepo {

    val table: DynamoDbTable<Receiver> = dynamoDbTable()

    override fun findAll(): List<Receiver> {
        val destinations = ArrayList<Receiver>()
        val queryConditional = QueryConditional
            .keyEqualTo(
                Key.builder()
                    .partitionValue("receiver")
                    .build()
            )
        val results = table.query(queryConditional).items().iterator();

        while (results.hasNext()) {
            destinations.add(results.next())
        }
        return destinations
    }

    override fun findByName(name: String): Receiver {
        val key = Key.builder()
            .partitionValue(AttributeValue.builder().s("receiver").build())
            .sortValue(AttributeValue.builder().s(name).build())
            .build()
        return table.getItem { r -> r.key(key) }
    }


    override fun save(receiver: Receiver) {
        table.putItem(receiver)
    }

    override fun deleteByName(name: String): Receiver? {
        val key = Key.builder()
            .partitionValue(AttributeValue.builder().s("receiver").build())
            .sortValue(AttributeValue.builder().s(name).build())
            .build()
        return table.deleteItem { r -> r.key(key) }
    }

    override fun update(receiver: Receiver) {
        table.updateItem(receiver)
    }

    private fun dynamoDbTable(): DynamoDbTable<Receiver> {

        val region = Region.of("us-east-1")

        val dynamoDbClient = DynamoDbClient.builder()
            .endpointOverride(URI.create("http://localhost:8000"))
            .region(region)
            .build()
        val dynamoDbClientEnhancedClient = DynamoDbEnhancedClient.builder()
            .dynamoDbClient(dynamoDbClient)
            .build()

        return dynamoDbClientEnhancedClient
            .table("Train", TableSchema.fromBean(Receiver::class.java))
    }

    private fun getKey(name: String): Key? {
        val key = Key.builder()
            .partitionValue(AttributeValue.builder().s("receiver").build())
            .sortValue(AttributeValue.builder().s(name).build())
            .build()
        return key
    }

}
