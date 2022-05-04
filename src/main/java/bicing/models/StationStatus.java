/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicing.models;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author eric_
 */
public class StationStatus implements Serializable {

    //Status
    private int station_id;
    private int num_bikes_available;
    private NumBikesAvailableTypes num_bikes_available_types;
    private int num_docks_available;
    private int last_reported;
    private boolean is_charging_station;
    private String status;
    private int is_installed;
    private int is_renting;
    private int is_returning;
    private Object traffic;

    public StationStatus() {
    }

    public StationStatus(int station_id,
            int num_bikes_available,
            NumBikesAvailableTypes num_bikes_available_types,
            int num_docks_available,
            int last_reported,
            boolean is_charging_station,
            String status,
            int is_installed,
            int is_renting,
            int is_returning,
            Object traffic) {
        this.station_id = station_id;
        this.num_bikes_available = num_bikes_available;
        this.num_bikes_available_types = num_bikes_available_types;
        this.num_docks_available = num_docks_available;
        this.last_reported = last_reported;
        this.is_charging_station = is_charging_station;
        this.status = status;
        this.is_installed = is_installed;
        this.is_renting = is_renting;
        this.is_returning = is_returning;
        this.traffic = traffic;
    }

    public int getStation_id() {
        return station_id;
    }

    public void setStation_id(int station_id) {
        this.station_id = station_id;
    }

    public int getNum_bikes_available() {
        return num_bikes_available;
    }

    public void setNum_bikes_available(int num_bikes_available) {
        this.num_bikes_available = num_bikes_available;
    }

    public NumBikesAvailableTypes getNum_bikes_available_types() {
        return num_bikes_available_types;
    }

    public void setNum_bikes_available_types(NumBikesAvailableTypes num_bikes_available_types) {
        this.num_bikes_available_types = num_bikes_available_types;
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

    public Object getTraffic() {
        return traffic;
    }

    public void setTraffic(Object traffic) {
        this.traffic = traffic;
    }
    
    

}
