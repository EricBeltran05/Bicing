/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicing.controllers;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author eric_
 */
public class MongoConnection {

    private MongoClientURI connectionString;
    private MongoClient mongoClient;

    public MongoConnection(String URI) {
        connectionString = new MongoClientURI(URI);
        mongoClient = new MongoClient(connectionString);
    }

    public MongoClientURI getConnectionString() {
        return connectionString;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public MongoDatabase getMongoDatabase(String bdName) {
        return mongoClient.getDatabase(bdName);
    }
}
