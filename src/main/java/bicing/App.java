/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicing;

import bicing.mappings.StationMapping;
import bicing.models.Information;
import bicing.models.StationInformation;
import bicing.models.StationStatus;
import bicing.models.Status;
import bicing.utils.LatLongUtils;
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
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author eric_
 */
public class App {

    private static Status status;
    private static Information info;
    private static Scanner sc = new Scanner(System.in);

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

        menu();

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
            status = gson.fromJson(new FileReader("station_status.json"), Status.class);
            if (doc == null) {

                station_status.insertOne(StationMapping.setDataToDocument(status));

            } else {
                int last_upd = doc.getInteger("last_updated");
                station_status.updateOne(eq("last_updated", last_upd), new Document("$set", StationMapping.setDataToDocument(status)));

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

            BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream("station_information.json"), "UTF-8"));
            info = gson.fromJson(bf, Information.class);

            if (doc == null) {
                station_info.insertOne(StationMapping.setDataToDocument(info));

            }

        } catch (NullPointerException | FileNotFoundException | UnsupportedEncodingException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static void menu() {

        int opcion;

        while (true) {
            System.out.println(
                    "\n1. Quantes bicis hi han disponibles en una estació?\n"
                    + "2. Quants llocs hi han disponibles per aparcar a una estació?\n"
                    + "3. Quina és l’estació més propera a mi amb bicis lliures?\n"
                    + "4. Quina és l’estació més propera a mi amb llocs disponibles?\n"
                    + "5. Sortir.");

            System.out.println("Escriu una de les opcions.  (1-5)");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    bicisDispo();

                    break;

                case 2:

                    llocsDispo();

                    break;

                case 3:

                    propLliures(true);

                    break;

                case 4:
                    propLliures(false);
                    break;

                case 5:

                    System.out.println("Fins la pròxima!");
                    System.exit(0);

                    break;

                default:
                    System.out.println("Ho sentim, el número introduït no està dins dels paràmetres.");
            }

        }
    }

    private static void bicisDispo() {
        sc.nextLine();
        System.out.println("Cerca per nom d’estació.");
        String name = (sc.nextLine());

        for (int i = 0; i < info.getStations().getStations().size(); i++) {

            if (info.getStations().getStations().get(i).getName().equals(name)) {
                int id = info.getStations().getStations().get(i).getStation_id();

                if (status.getStations().getStations().get(i).getStation_id() == id) {
                    System.out.println("Bicis disponibles: " + status.getStations().getStations().get(i).getNum_bikes_available());

                }
            }
        }
    }

    private static void llocsDispo() {
        sc.nextLine();
        System.out.println("Cerca per nom d’estació.");
        String name = (sc.nextLine());

        for (int i = 0; i < info.getStations().getStations().size(); i++) {

            if (info.getStations().getStations().get(i).getName().equals(name)) {
                int id = info.getStations().getStations().get(i).getStation_id();

                if (status.getStations().getStations().get(i).getStation_id() == id) {
                    System.out.println("Llocs disponibles: " + status.getStations().getStations().get(i).getNum_docks_available());

                }
            }
        }
    }
    
    //Font: https://www.techiedelight.com/sort-list-of-objects-using-comparator-java/

    private static void propLliures(boolean bicis) {
        sc.nextLine();
        System.out.println("Cerca per localització.");
        System.out.println("Lat: ");
        double lat = sc.nextDouble();
        System.out.println("Long: ");
        double lon = sc.nextDouble();

        ArrayList<StationInformation> todas = new ArrayList<StationInformation>();

        todas.addAll(info.getStations().getStations());

        Collections.sort(todas, new Comparator<StationInformation>() {
            @Override
            public int compare(StationInformation s1, StationInformation s2) {
                double ds1 = LatLongUtils.getDistanceFromLatLongInMeters(lat, lon, s1.getLat(), s1.getLon());
                double ds2 = LatLongUtils.getDistanceFromLatLongInMeters(lat, lon, s2.getLat(), s2.getLon());

                if ((ds1 - ds2) < 0) {
                    return -1;
                } else if ((ds1 - ds2) == 0) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        for (StationInformation s : todas) {
            if (bicis) {
                if (StatusbyId(s.getStation_id()).getNum_bikes_available() > 0) {
                    System.out.println("Estació: " + s.getName());
                    break;
                }
            } else {
                if (StatusbyId(s.getStation_id()).getNum_docks_available() > 0) {
                    System.out.println("Estació: " + s.getName());
                    break;
                }
            }

            System.out.println("No s'ha trobat cap estació.");
        }
    }

    private static StationStatus StatusbyId(int id) {
        for (int i = 0; i < status.getStations().getStations().size(); i++) {
            if (id == status.getStations().getStations().get(i).getStation_id()) {
                return status.getStations().getStations().get(i);
            }
        }
        return null;
    }

}
