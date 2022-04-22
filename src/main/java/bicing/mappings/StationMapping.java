/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicing.mappings;

import bicing.models.Station;
import bicing.models.Status;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author eric_
 */
public class StationMapping {

    public static Document setStationToDocument(Station s) {
        Document doc = new Document("station_id", s.getStation_id())
                .append("name", s.getName())
                .append("physical_configuration", s.getPhysical_configuration())
                .append("lat", s.getLat())
                .append("lon", s.getLon())
                .append("altitude", s.getAltitude())
                .append("address", s.getAddress())
                .append("post_code", s.getPost_code())
                .append("capacity", s.getCapacity())
                .append("nearby_distance", s.getNearby_distance());
        return doc;
    }

    public static Document setStatusToDocument(Status st) {
        Document doc = new Document("station_id", st.getStation_id())
                .append("num_bikes_available", st.getNum_bikes_available())
                .append("num_bikes_available_types", Arrays.asList(
                        st.getMechanical(), st.getEbike()))
                .append("num_docks_available", st.getNum_docks_available())
                .append("last_reported", st.getLast_reported())
                .append("is_charging_station", st.isIs_charging_station())
                .append("status", st.getStatus())
                .append("is_installed", st.getIs_installed())
                .append("is_renting", st.getIs_renting())
                .append("is_returning", st.getIs_returning())
                .append("traffic", st.getTraffic());
        return doc;
    }

    public static Station getStationFromDocument(Document doc) {
        Station s = new Station();
        s.setStation_id(doc.getInteger("station_id"));
        s.setName(doc.getString("name"));
        s.setPhysical_configuration(doc.getString("physical_configuration"));
        s.setLat(doc.getDouble("lat"));
        s.setLon(doc.getDouble("lon"));
        s.setAltitude(doc.getInteger("altitude"));
        s.setAddress(doc.getString("address"));
        s.setPost_code(doc.getString("post_code"));
        s.setCapacity(doc.getInteger("capacity"));
        s.setNearby_distance(doc.getInteger("nearby_distance"));
        return s;
    }

    public static Status getStatusFromDocument(Document doc) {
        Status st = new Status();
        st.setStation_id(doc.getInteger("station_id"));
        st.setNum_bikes_available(doc.getInteger("num_bikes_available"));
        List types = (List<?>) doc.get("num_bikes_available_types");
        st.setMechanical((int) types.get(0));
        st.setEbike((int) types.get(1));
        st.setNum_docks_available(doc.getInteger("num_docks_available"));
        st.setLast_reported(doc.getInteger("last_reported"));
        st.setIs_charging_station(doc.getBoolean("is_charging_station"));
        st.setStatus(doc.getString("status"));
        st.setIs_installed(doc.getInteger("is_installed"));
        st.setIs_renting(doc.getInteger("is_renting"));
        st.setIs_returning(doc.getInteger("is_returning"));
        st.setTraffic(doc.getInteger("traffic"));
        return st;
    }

}
