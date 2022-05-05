/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicing.models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author eric_
 */
public class DataStatus implements Serializable {
  
    private ArrayList<StationStatus> stations;

    public DataStatus() {
        this.stations = new ArrayList();
       
    }

    public ArrayList<StationStatus> getStations() {
        return stations;
    }

    public void setStations(ArrayList<StationStatus> stations) {
        this.stations = stations;
    }

    @Override
    public String toString() {
        return "stations{ " + stations;
    }
}
