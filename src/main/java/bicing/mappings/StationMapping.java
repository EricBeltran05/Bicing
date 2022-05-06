/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicing.mappings;

import bicing.models.Information;
import bicing.models.Status;
import com.google.gson.Gson;
import org.bson.Document;

/**
 *
 * @author eric_
 */
public class StationMapping {

    public static Document setDataToDocument(Information i) {

        Gson gson = new Gson();
        String root = gson.toJson(i);

        return Document.parse(root);
    }

    public static Document setDataToDocument(Status s) {

        Gson gson = new Gson();
        String root = gson.toJson(s);

        return Document.parse(root);
    }

    public static Status getDataFromDocument(Status s) {
        
        return s;
    }

}
