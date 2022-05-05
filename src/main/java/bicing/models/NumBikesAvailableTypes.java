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
public class NumBikesAvailableTypes implements Serializable {

    private int mechanical;
    private int ebike;

    public NumBikesAvailableTypes() {
    }

    public NumBikesAvailableTypes(int mechanical, int ebike) {
        this.mechanical = mechanical;
        this.ebike = ebike;
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

    @Override
    public String toString() {
        return "{ mechanical: " + mechanical
                + ", ebike: " + ebike + " }";
    }

}
