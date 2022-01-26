#!/bin/bash

export AWS_PAGER=""

# Drop
aws dynamodb delete-table --endpoint http://localhost:8000 --table-name Train


# Create
aws dynamodb create-table --endpoint http://localhost:8000 --table-name Train \
  --attribute-definitions AttributeName=type,AttributeType=S AttributeName=name,AttributeType=S \
    --key-schema AttributeName=type,KeyType=HASH AttributeName=name,KeyType=RANGE \
    --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5

# Insert
aws dynamodb put-item --endpoint http://localhost:8000  --table-name Train \
    --item '{"type":{"S":"destination"}, "name": {"S": "Chicago"}}'

aws dynamodb put-item --endpoint http://localhost:8000  --table-name Train \
--item '{"type":{"S":"destination"}, "name": {"S": "Houston"}}'

aws dynamodb put-item --endpoint http://localhost:8000  --table-name Train \
--item '{"type":{"S":"destination"}, "name": {"S": "LA"}}'

aws dynamodb put-item --endpoint http://localhost:8000  --table-name Train \
--item '{"type":{"S":"receiver"}, "name": {"S": "FedEx"}}'


aws dynamodb put-item --endpoint http://localhost:8000  --table-name Train \
--item '{"type":{"S":"receiver"}, "name": {"S": "UPS"}}'

aws dynamodb put-item --endpoint http://localhost:8000  --table-name Train \
--item '{"type":{"S":"receiver"}, "name": {"S": "Old Dominion"}}'

# Disply all values in table
aws dynamodb scan --endpoint http://localhost:8000  --table-name Train
