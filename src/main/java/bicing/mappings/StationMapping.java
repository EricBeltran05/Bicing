/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicing.mappings;

import bicing.models.Data;
import bicing.models.Station;
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

    public static Station getStatusFromDocument(Document doc) {
        Station s = new Station();

        s.setLast_updated(doc.getInteger("last_updated"));
        s.setTtl(doc.getInteger("ttl"));

        List data = (List<?>) doc.get("data");

        System.out.println("VEAMOS EL DOC " + doc);
        System.out.println("ANTES DEL SET " + s.getStations());

//        s.getStations().setStations(data);
        System.out.println("IIIIIIIIIIIIIIIIIII " + s);

        Data st = new Data();

        //s.setStations(doc.get("data"));
        //List<Data> ds = new ArrayList(Arrays.asList(st));
        List stations = (List<?>) doc.get("stations");

        System.out.println("OOOOOOOOOOOOOO " + stations);

        st.setStation_id((int) stations.get(0));
        st.setNum_bikes_available((int) stations.get(1));

        st.setNum_bikes_available_types((List) stations.get(2));

        List types = (List<?>) stations.subList(0, 1);
        st.setMechanical((int) types.get(0));
        st.setEbike((int) types.get(1));

        st.setNum_docks_available((int) stations.get(3));
        st.setLast_reported((int) stations.get(4));
        st.setIs_charging_station((boolean) stations.get(5));
        st.setStatus((String) stations.get(6));
        st.setIs_installed((int) stations.get(7));
        st.setIs_renting((int) stations.get(8));
        st.setIs_returning((int) stations.get(9));
        st.setTraffic((int) stations.get(10));

        s.setStations(st);

        return s;
    }

}
