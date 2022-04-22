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
public class Status implements Serializable {

    private int station_id;
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

    public Status() {
        this.num_bikes_available_types = new ArrayList<>();
    }

    public Status(
            int station_id,
            int num_bikes_available,
            int num_docks_available,
            int last_reported,
            boolean is_charging_station,
            String status,
            int is_installed,
            int is_renting,
            int is_returning,
            int traffic) {
        this.station_id = station_id;
        this.num_bikes_available = num_bikes_available;
        this.num_docks_available = num_docks_available;
        this.last_reported = last_reported;
        this.is_charging_station = is_charging_station;
        this.status = status;
        this.is_installed = is_installed;
        this.is_renting = is_renting;
        this.is_returning = is_returning;
        this.traffic = traffic;
    }

    /**
     * @return the station_id
     */
    public int getStation_id() {
        return station_id;
    }

    /**
     * @param station_id the station_id to set
     */
    public void setStation_id(int station_id) {
        this.station_id = station_id;
    }

    /**
     * @return the num_bikes_available
     */
    public int getNum_bikes_available() {
        return num_bikes_available;
    }

    /**
     * @param num_bikes_available the num_bikes_available to set
     */
    public void setNum_bikes_available(int num_bikes_available) {
        this.num_bikes_available = num_bikes_available;
    }

    /**
     * @return the num_bikes_available_types
     */
    public List getNum_bikes_available_types() {
        return num_bikes_available_types;
    }

    /**
     * @param num_bikes_available_types the num_bikes_available_types to set
     */
    public void setNum_bikes_available_types(List<String> num_bikes_available_types) {
        this.num_bikes_available_types = num_bikes_available_types;
    }

    /**
     * @return the mechanical
     */
    public int getMechanical() {
        return mechanical;
    }

    /**
     * @param mechanical the mechanical to set
     */
    public void setMechanical(int mechanical) {
        this.mechanical = mechanical;
    }

    /**
     * @return the ebike
     */
    public int getEbike() {
        return ebike;
    }

    /**
     * @param ebike the ebike to set
     */
    public void setEbike(int ebike) {
        this.ebike = ebike;
    }

    /**
     * @return the num_docks_available
     */
    public int getNum_docks_available() {
        return num_docks_available;
    }

    /**
     * @param num_docks_available the num_docks_available to set
     */
    public void setNum_docks_available(int num_docks_available) {
        this.num_docks_available = num_docks_available;
    }

    /**
     * @return the last_reported
     */
    public int getLast_reported() {
        return last_reported;
    }

    /**
     * @param last_reported the last_reported to set
     */
    public void setLast_reported(int last_reported) {
        this.last_reported = last_reported;
    }

    /**
     * @return the is_charging_station
     */
    public boolean isIs_charging_station() {
        return is_charging_station;
    }

    /**
     * @param is_charging_station the is_charging_station to set
     */
    public void setIs_charging_station(boolean is_charging_station) {
        this.is_charging_station = is_charging_station;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the is_installed
     */
    public int getIs_installed() {
        return is_installed;
    }

    /**
     * @param is_installed the is_installed to set
     */
    public void setIs_installed(int is_installed) {
        this.is_installed = is_installed;
    }

    /**
     * @return the is_renting
     */
    public int getIs_renting() {
        return is_renting;
    }

    /**
     * @param is_renting the is_renting to set
     */
    public void setIs_renting(int is_renting) {
        this.is_renting = is_renting;
    }

    /**
     * @return the is_returning
     */
    public int getIs_returning() {
        return is_returning;
    }

    /**
     * @param is_returning the is_returning to set
     */
    public void setIs_returning(int is_returning) {
        this.is_returning = is_returning;
    }

    /**
     * @return the traffic
     */
    public int getTraffic() {
        return traffic;
    }

    /**
     * @param traffic the traffic to set
     */
    public void setTraffic(int traffic) {
        this.traffic = traffic;
    }

    @Override
    public String toString() {
        return "Status{ " + status + "}";
    }

}
