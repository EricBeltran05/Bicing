/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicing;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author eric_
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("NIF of Student to see enrolled subjects: ");
        String id_station = sc.nextLine();
        
        //URI Connexió BBDD
        MongoClientURI connectionString = new MongoClientURI(
                "mongodb://localhost:27017"
        );

        //Creació client (es  a dir, connectem)
        MongoClient mongoClient = new MongoClient(connectionString);

        MongoDatabase bbdd = mongoClient.getDatabase("Bicing");

        //Agafem la coleccio amb la que volem veure els seus documents
        MongoCollection<Document> station = bbdd.getCollection("station_information");
        
        try {
            Document doc = station.find(eq("station_id", id_station)).first();
            List<ObjectId> enrolled = (List<ObjectId>) doc.get(
                    "name"
            );
            if (enrolled != null && !enrolled.isEmpty()) {
                MongoCollection<Document> subjects = bbdd.getCollection(
                        "station_information"
                );
                
                for (ObjectId id: enrolled) {
                    Document sub = subjects.find(eq("_id", id)).first();
                    System.out.println(sub.toJson());
                }
            }
            
            
        } catch (MongoException ex) {
            System.err.println("Excepcio: " + ex.getMessage());
        }
    }

}
