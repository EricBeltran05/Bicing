/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicing.models;

import java.io.Serializable;

/**
 *
 * @author eric_
 */
public class StationInformation implements Serializable {

    private int station_id;

    //Info
    private String name;
    private String physical_configuration;
    private double lat;
    private double lon;
    private double altitude;
    private String address;
    private String post_code;
    private int capacity;
    private double nearby_distance;

    public StationInformation() {

    }

    public StationInformation(
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
    public Double getAltitude() {
        return altitude;
    }

    /**
     * @param altitude the altitude to set
     */
    public void setAltitude(Double altitude) {
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
    public Double getNearby_distance() {
        return nearby_distance;
    }

    /**
     * @param nearby_distance the nearby_distance to set
     */
    public void setNearby_distance(Double nearby_distance) {
        this.nearby_distance = nearby_distance;
    }

    @Override
    public String toString() {
        return "Station{ " + "station_id: " + station_id
                + ", name: " + name
                + ", physical_configuration: " + physical_configuration
                + ", lat: " + lat
                + ", lon: " + lon
                + ", altitude: " + altitude
                + ", address: " + address
                + ", post_code: " + post_code
                + ", capacity: " + capacity
                + ", nearby_distance: " + nearby_distance + " }";
    }

}
