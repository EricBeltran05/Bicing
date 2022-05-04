/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicing.utils;

/**
 *
 * @author eric_
 */
public class LatLongUtils {
    
    private static final double R = 6371000.0; //Radius of the earth in meters
    
    public static double getDistanceFromLatLongInMeters(
            double lat1,
            double lon1,
            double lat2,
            double lon2
    ) {
      double dLat = Math.toRadians(lat2 - lat1);
      double dLon = Math.toRadians(lon2 - lon1);
      
      double a = Math.sin(dLat/2) * Math.sin(dLat/2) 
              + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) 
              * Math.sin(dLon/2) * Math.sin(dLon/2);
      double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
      return R * c;
    }
}