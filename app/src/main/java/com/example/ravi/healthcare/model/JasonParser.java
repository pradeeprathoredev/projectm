package com.example.ravi.healthcare.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import org.json.JSONArray;

import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 27-03-2017.
 */

public class JasonParser {


    public static String getJSON(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object JSONtoObject(String json, Class classs) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(json, classs);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String dateParser(String date) {
        String[] dateToBeParse=date.split("/");
        String parsedDate=dateToBeParse[0]+"-"+dateToBeParse[1]+"-"+dateToBeParse[2];

        return parsedDate;
    }

    public static List<Error> jsonArrayToErrorList(JSONArray jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return  mapper.readValue(String.valueOf(jsonString),
                    TypeFactory.defaultInstance().constructCollectionType(List.class,
                            Error.class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}