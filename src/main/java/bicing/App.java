/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicing;

import bicing.mappings.StationMapping;
import bicing.models.Information;
import bicing.models.Json;
import bicing.models.Station;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import org.bson.Document;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import static com.mongodb.client.model.Filters.eq;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        System.out.println("Station id: ");
        String _id = "6262af70ba5576d88b9f5a44";

        //File f = new File(getClass().getResource("/resources/station_information.json").getFile());
        //URL url = App.class.getClass().getResource("/resources/station_information.json");
        //URI Connexió BBDD
        MongoClientURI connectionString = new MongoClientURI(
                "mongodb://localhost:27017"
        );

        //Creació client (es  a dir, connectem)
        MongoClient mongoClient = new MongoClient(connectionString);

        MongoDatabase bbdd = mongoClient.getDatabase("Bicing");

        //Agafem la coleccio amb la que volem veure els seus documents
        MongoCollection<Document> station = bbdd.getCollection("station_information");

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try {
            
            Document doc = station.find().first();

            Information stationJSON = gson.fromJson(new FileReader("station_information.json"), Information.class);

            Station a = gson.fromJson(new FileReader("station_information.json"), Station.class);

            
            
            Json j = gson.fromJson(new FileReader("station_information.json"), Json.class);

            System.out.println(j);
            
            station.insertOne(StationMapping.setStationToDocument(j));

            //station.insertOne(StationMapping.setStationToDocument(stationJSON));
            //System.out.println(StationMapping.setStationToDocument(stationJSON));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
