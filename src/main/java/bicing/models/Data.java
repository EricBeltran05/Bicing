/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicing.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eric_
 */
public class Data implements Serializable {

    //Information
    private List stations;
    private int station_id;
    private String name;
    private String physical_configuration;
    private Double lat;
    private Double lon;
    private int altitude;
    private String address;
    private String post_code;
    private int capacity;
    private int nearby_distance;

    //Status
    private int num_bikes_available;
    private List<String> num_bikes_available_types;
    private int mechanical;
    private int ebike;
    private int num_docks_available;
    private int last_reported;
    private boolean is_charging_station;
    private String status;
    private int is_installed;
    private int is_renting;
    private int is_returning;
    private int traffic;

    public Data() {
        this.stations = new ArrayList<>();
    }

    public Data(
            int station_id,
            String name,
            String physical_configuration,
            Double lat,
            Double lon,
            int altitude,
            String address,
            String post_code,
            int capacity,
            int nearby_distance) {

        this.station_id = station_id;
        this.name = name;
        this.physical_configuration = physical_configuration;
        this.lat = lat;
        this.lon = lon;
        this.altitude = altitude;
        this.address = address;
        this.post_code = post_code;
        this.capacity = capacity;
        this.nearby_distance = nearby_distance;
    }

    public Data(
            int num_bikes_available,
            List<String> num_bikes_available_types,
            int mechanical,
            int ebike,
            int num_docks_available,
            int last_reported,
            boolean is_charging_station,
            String status,
            int is_installed,
            int is_renting,
            int is_returning,
            int traffic) {

        this.num_bikes_available = num_bikes_available;
        this.num_bikes_available_types = num_bikes_available_types;
        this.mechanical = mechanical;
        this.ebike = ebike;
        this.num_docks_available = num_docks_available;
        this.last_reported = last_reported;
        this.is_charging_station = is_charging_station;
        this.status = status;
        this.is_installed = is_installed;
        this.is_renting = is_renting;
        this.is_returning = is_returning;
        this.traffic = traffic;
    }
    
    //Information

    public List getStations() {
        return stations;
    }

    public void setStations(List stations) {
        this.stations = stations;
    }

    public int getStation_id() {
        return station_id;
    }

    public void setStation_id(int station_id) {
        this.station_id = station_id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the physical_configuration
     */
    public String getPhysical_configuration() {
        return physical_configuration;
    }

    /**
     * @param physical_configuration the physical_configuration to set
     */
    public void setPhysical_configuration(String physical_configuration) {
        this.physical_configuration = physical_configuration;
    }

    /**
     * @return the lat
     */
    public Double getLat() {
        return lat;
    }

    /**
     * @param lat the lat to set
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     * @return the lon
     */
    public Double getLon() {
        return lon;
    }

    /**
     * @param lon the lon to set
     */
    public void setLon(Double lon) {
        this.lon = lon;
    }

    /**
     * @return the altitude
     */
    public int getAltitude() {
        return altitude;
    }

    /**
     * @param altitude the altitude to set
     */
    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the post_code
     */
    public String getPost_code() {
        return post_code;
    }

    /**
     * @param post_code the post_code to set
     */
    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * @return the nearby_distance
     */
    public int getNearby_distance() {
        return nearby_distance;
    }

    /**
     * @param nearby_distance the nearby_distance to set
     */
    public void setNearby_distance(int nearby_distance) {
        this.nearby_distance = nearby_distance;
    }
    
    //Status

    public int getNum_bikes_available() {
        return num_bikes_available;
    }

    public void setNum_bikes_available(int num_bikes_available) {
        this.num_bikes_available = num_bikes_available;
    }

    public List<String> getNum_bikes_available_types() {
        return num_bikes_available_types;
    }

    public void setNum_bikes_available_types(List<String> num_bikes_available_types) {
        this.num_bikes_available_types = num_bikes_available_types;
    }

    public int getMechanical() {
        return mechanical;
    }

    public void setMechanical(int mechanical) {
        this.mechanical = mechanical;
    }

    public int getEbike() {
        return ebike;
    }

    public void setEbike(int ebike) {
        this.ebike = ebike;
    }

    public int getNum_docks_available() {
        return num_docks_available;
    }

    public void setNum_docks_available(int num_docks_available) {
        this.num_docks_available = num_docks_available;
    }

    public int getLast_reported() {
        return last_reported;
    }

    public void setLast_reported(int last_reported) {
        this.last_reported = last_reported;
    }

    public boolean isIs_charging_station() {
        return is_charging_station;
    }

    public void setIs_charging_station(boolean is_charging_station) {
        this.is_charging_station = is_charging_station;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIs_installed() {
        return is_installed;
    }

    public void setIs_installed(int is_installed) {
        this.is_installed = is_installed;
    }

    public int getIs_renting() {
        return is_renting;
    }

    public void setIs_renting(int is_renting) {
        this.is_renting = is_renting;
    }

    public int getIs_returning() {
        return is_returning;
    }

    public void setIs_returning(int is_returning) {
        this.is_returning = is_returning;
    }

    public int getTraffic() {
        return traffic;
    }

    public void setTraffic(int traffic) {
        this.traffic = traffic;
    }
    
    

    @Override
    public String toString() {
        return "stations{ " + stations;
        //return station_id + " " + name + " " + physical_configuration + " " + lat + " " + lon + " " + altitude + " " + address + " " + post_code + " " + capacity + " " + nearby_distance + " ";
    }
}
