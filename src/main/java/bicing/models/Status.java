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
public class Status implements Serializable{

    private int last_updated;
    private int ttl;
    private DataStatus data;

    public Status() {
    }

    public Status(int last_updated, int ttl, DataStatus data) {
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

    public DataStatus getStations() {
        return data;
    }

    public void setStations(DataStatus data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "last_updated: " + last_updated + ", ttl: " + ttl + ", data: " + data;
    }

}
