package com.edu.appswbd.practica.uno.convertidor;

import com.google.gson.Gson;
import org.json.JSONObject;
import org.json.XML;

public class Convertir {

    public String convertirToJson(String dato, String forma) {

        if (forma == "JAVA") {
            Gson gson = new Gson();
            String json = gson.toJson(dato);
            return json;
        }
        else {

            JSONObject xmlJSONObj = XML.toJSONObject(dato);
            String json = xmlJSONObj.toString();
            return json ;
         }
    }
}


