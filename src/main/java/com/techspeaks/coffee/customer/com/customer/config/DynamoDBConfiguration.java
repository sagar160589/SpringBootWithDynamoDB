package com.techspeaks.coffee.customer.com.customer.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
This file mentions the dynamo db configuration required to integrate spring boot application with AWS DynamoDB.
Credentials are hardcoded for simplicity in this code. But for security purpose always include them in enviornmental variables, properties file
*/

@Configuration
public class DynamoDBConfiguration {

    @Bean
    public DynamoDBMapper dynamoDBMapper (){
        return new DynamoDBMapper(getDynamoDBObject());
    }

    private AmazonDynamoDB getDynamoDBObject() {

        return AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(
                        "dynamodb.your-region.amazonaws.com",
                        "your-region"
                ))
                .withCredentials(new AWSStaticCredentialsProvider(
                        new BasicAWSCredentials(
                                "Your-access-key",
                                "Your-secret-key"
                        )
                )).build();
    }
}
