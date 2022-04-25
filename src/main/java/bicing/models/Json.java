/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicing.models;

import bicing.mappings.StationMapping;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eric_
 */
public class Json {

    private int last_updated;
    private int ttl;

    private Station data;

    public Json() {
    }

    public Json(int last_updated, int ttl, Station data) {
        this.last_updated = last_updated;
        this.ttl = ttl;
        this.data = data;
    }

    /**
     * @return the last_updated
     */
    public int getLast_updated() {
        return last_updated;
    }

    /**
     * @param last_updated the last_updated to set
     */
    public void setLast_updated(int last_updated) {
        this.last_updated = last_updated;
    }

    /**
     * @return the ttl
     */
    public int getTtl() {
        return ttl;
    }

    /**
     * @param ttl the ttl to set
     */
    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    /**
     * @return the data
     */
    public Station getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Station data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Last Updated: " + last_updated + ", TTL: " + ttl + ", data: " + data;
    }

}
