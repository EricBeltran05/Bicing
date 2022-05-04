/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicing.mappings;

import bicing.models.Data;
import bicing.models.Json;
import bicing.models.StationInformation;
import bicing.models.StationStatus;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 *
 * @author eric_
 */
public class StationMapping {

    public static Document setDataToDocument(Json s) {

        Document doc = new Document("last_updated", s.getLast_updated())
                .append("ttl", s.getTtl())
                .append("data", s.getStations().getStations());

        return doc;
    }

    /*Arrays.asList(
                        s.getStations().getStation_id(),
                        s.getStations().getName(),
                        s.getStations().getPhysical_configuration(),
                        s.getStations().getLat(),
                        s.getStations().getLon(),
                        s.getStations().getAltitude(),
                        s.getStations().getAddress(),
                        s.getStations().getPost_code(),
                        s.getStations().getCapacity(),
                        s.getStations().getNearby_distance())*/
 /*public static Document setDataToDocument(Json s) {
        Document doc = new Document("last_updated", s.getLast_updated())
                .append("ttl", s.getTtl())
                .append("data", s.getStations().getStations());
        return doc;
    }*/
    public static StationInformation getStationFromDocument(Document doc) {
        StationInformation s = new StationInformation();
        s.setStation_id(doc.getInteger("station_id"));
        s.setName(doc.getString("name"));
        s.setPhysical_configuration(doc.getString("physical_configuration"));
        s.setLat(doc.getDouble("lat"));
        s.setLon(doc.getDouble("lon"));
        s.setAltitude(doc.getDouble("altitude"));
        s.setAddress(doc.getString("address"));
        s.setPost_code(doc.getString("post_code"));
        s.setCapacity(doc.getInteger("capacity"));
        s.setNearby_distance(doc.getDouble("nearby_distance"));
        return s;
    }

    public static StationStatus getStatusFromDocument(Document doc) {

        StationStatus s = new StationStatus();

        /*s.setStations(obj);

        for(){
            
        }*/
        List<Data> a = new ArrayList();

        //a.add(doc.get("data"));
        List stations = (List<?>) doc.get("data");

        System.out.println("OOOOOOOOOOOOOO " + a);

        s.setStation_id((int) stations.get(0));
        s.setNum_bikes_available((int) stations.get(1));

        //s.setNum_bikes_available_types((List) stations.get(2));

        List types = (List<?>) stations.subList(0, 1);
        s.getNum_bikes_available_types().setMechanical((int) types.get(0));
        s.getNum_bikes_available_types().setEbike((int) types.get(1));

        s.setNum_docks_available((int) stations.get(3));
        s.setLast_reported((int) stations.get(4));
        s.setIs_charging_station((boolean) stations.get(5));
        s.setStatus((String) stations.get(6));
        s.setIs_installed((int) stations.get(7));
        s.setIs_renting((int) stations.get(8));
        s.setIs_returning((int) stations.get(9));
        s.setTraffic((int) stations.get(10));

        return s;
    }

}
