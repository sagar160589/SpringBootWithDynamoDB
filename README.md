# SpringBootWithDynamoDB
This application demonstrates integration of a Spring Boot Application with DynamoDB.

# Steps to follow
1.Login to AWS Management Console and create a simple table in DynamoDB- in this case a customer table with partition key as customerId. I haven't added any sort key here. Note the region where you are creating this table
2.Create a user group in IAM - I have created a group as DynamoDBUserGroup and added a permission policy - AmazonDynamoDBFullAccess.
3.Create a user, add that user to above group. At the end download the csv file containing users access key & secret key. This would be used in the application code for DynamoDB configuration.
4.Download the repo here from the github and import it into your favourite IDE. I'm using Intellij IDEA.
5.Configure the region, access key & secret key in DynamoDBConfiguration.java (For simplicity I have used these in code but in real world use enviornmental variables, properties files)
6.Change the port if required in application.properties.
7.Build and run the application (I hae included a Dockerfile, but you can simply run it using mvn spring-boot:run) and test the API endpoints using Postman.
8.Data will be visible in AWS DynamoDB table.
