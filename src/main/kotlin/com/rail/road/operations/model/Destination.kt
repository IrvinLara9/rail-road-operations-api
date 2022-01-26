package com.rail.road.operations.model

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey


@DynamoDbBean
data class Destination(
    @get: DynamoDbPartitionKey var type: String = "destination",
    @get: DynamoDbSortKey var name: String? = null,
    var priority: Int? = null
)