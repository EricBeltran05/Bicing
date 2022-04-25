/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicing.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eric_
 */
public class Station {

    private List<Information> stations;
    private List<Status> statusList;

    public Station() {
        stations = new ArrayList<>();
        statusList = new ArrayList<>();
    }

    /**
     * @return the stations
     */
    public List<Information> getInformation() {
        return stations;
    }

    /**
     * @param information the stations to set
     */
    public void setInformation(List<Information> information) {
        this.stations = information;
    }

    /**
     * @return the status
     */
    public List<Status> getStatusList() {
        return statusList;
    }

    /**
     * @param statusList the status to set
     */
    public void setStatusList(List<Status> statusList) {
        this.statusList = statusList;
    }

    @Override
    public String toString() {
        return "Stations: " + stations;
    }

}
