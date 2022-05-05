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
public class DataInformation implements Serializable {
  
    private ArrayList<StationInformation> stations;

    public DataInformation() {
        this.stations = new ArrayList();
       
    }

    public ArrayList<StationInformation> getStations() {
        return stations;
    }

    public void setStations(ArrayList<StationInformation> stations) {
        this.stations = stations;
    }

    @Override
    public String toString() {
        return "stations{ " + stations;
    }
}
