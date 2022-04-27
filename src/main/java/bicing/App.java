/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicing;

import bicing.mappings.StationMapping;
import bicing.models.Station;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.FileNotFoundException;
import org.bson.Document;
import com.google.gson.GsonBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        MongoCollection<Document> station_info = bbdd.getCollection("station_information");
        MongoCollection<Document> station_status = bbdd.getCollection("station_status");

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try {

            Station s_info = gson.fromJson(new FileReader("station_information.json"), Station.class);
            station_info.insertOne(StationMapping.setDataToDocument(s_info));

            Station s_status = gson.fromJson(new FileReader("station_status.json"), Station.class);
            station_status.insertOne(StationMapping.setDataToDocument(s_status));

            //station.insertOne(StationMapping.setStationToDocument(j));
            //station.insertOne(StationMapping.setStationToDocument(s.getStations()));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

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

}
