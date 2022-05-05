/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicing;

import bicing.mappings.StationMapping;
import bicing.models.Information;
import bicing.models.Status;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.FileNotFoundException;
import org.bson.Document;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Properties;
import com.google.gson.Gson;
import static com.mongodb.client.model.Filters.eq;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author eric_
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Properties defaultProps = new Properties();
        InputStream in = App.class.getClassLoader()
                .getResourceAsStream("defaultProperties.txt");
        try {
            defaultProps.load(in);
            downloadFile(defaultProps.getProperty("url"));

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

        loadInfo();
        updateStatus();

    }

    private static void downloadFile(String url) {

        try {
            InputStream is = new URL(url).openStream();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(is, Charset.forName("UTF-8"))
            );
            String line;
            FileWriter flux = new FileWriter("station_status.json");
            BufferedWriter file = new BufferedWriter(flux);

            while ((line = reader.readLine()) != null) {
                file.write(line);
                file.newLine();

            }

            file.close();
            is.close();

        } catch (MalformedURLException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

    }

    private static void updateStatus() {

        //URI Connexió BBDD
        MongoClientURI connectionString = new MongoClientURI(
                "mongodb://localhost:27017"
        );

        MongoClient mongoClient = new MongoClient(connectionString);

        MongoDatabase bbdd = mongoClient.getDatabase("Bicing");

        MongoCollection<Document> station_status = bbdd.getCollection("station_status");

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        try {

            Document doc = station_status.find().first();
            Status status_api = gson.fromJson(new FileReader("station_status.json"), Status.class);
            if (doc == null) {

                station_status.insertOne(StationMapping.setDataToDocument(status_api));

            } else {
                int last_upd = doc.getInteger("last_updated");
                station_status.updateOne(eq("last_updated", last_upd), new Document("$set", StationMapping.setDataToDocument(status_api)));

            }
        } catch (NullPointerException | FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static void loadInfo() {
        //URI Connexió BBDD
        MongoClientURI connectionString = new MongoClientURI(
                "mongodb://localhost:27017"
        );

        MongoClient mongoClient = new MongoClient(connectionString);

        MongoDatabase bbdd = mongoClient.getDatabase("Bicing");

        MongoCollection<Document> station_info = bbdd.getCollection("station_information");

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        try {

            Document doc = station_info.find().first();

            Information s_info = gson.fromJson(new FileReader("station_information.json"), Information.class);

            if (doc == null) {
                station_info.insertOne(StationMapping.setDataToDocument(s_info));

            }

        } catch (NullPointerException | FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
