/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicing.mappings;

import bicing.models.Data;
import bicing.models.Station;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author eric_
 */
public class StationMapping {

    public static Document setDataToDocument(Station s) {
        Document doc = new Document("last_updated", s.getLast_updated())
                .append("ttl", s.getTtl())
                .append("data", s.getStations().getStations());
        return doc;
    }

    public static Data getStationFromDocument(Document doc) {
        Data s = new Data();
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

    /*public static Status getStatusFromDocument(Document doc) {
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
    }*/

}
