package com.example.final_project_cs125.lib;

import com.google.gson.*;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public final class code {

    public String info;


    // Must use "search/all" API
    public static boolean checkName(java.lang.String json, String userInputName) {
        if (userInputName == null) {
            return false;
        }
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        if (result.getAsJsonObject(userInputName).getAsString() != null) {
            return true;
        }
        return false;
    }


    // Must use "search/all" API
    public static String getName(java.lang.String json, String userInputName) {
        String name = userInputName;
        return name;
    }

    public static String getRace(java.lang.String json, String userInputName) {
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        JsonObject metadata = result.getAsJsonObject(userInputName);
        String race = metadata.get("race").getAsString();
        return race;
    }

    public static String getFlavor(java.lang.String json, String userInputName) {
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        JsonObject metadata = result.getAsJsonObject(userInputName);
        JsonArray flavors = metadata.get("flavors").getAsJsonArray();
        String flavor = "";

        for (JsonElement flavorIndividual : flavors) {
            flavor = flavorIndividual.getAsString() + ", " + flavor;
        }

        return flavor;
    }

    public static String getPositiveEffect(java.lang.String json, String userInputName) {
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        JsonObject metadata = result.getAsJsonObject(userInputName);
        String positiveEffect = "";
        JsonArray positiveEffects = metadata.getAsJsonObject("effects").getAsJsonArray("positive");

        for (JsonElement effectIndividual : positiveEffects) {
            positiveEffect = effectIndividual.getAsString() + ", " + positiveEffect;
        }

        return positiveEffect;
    }

    public static String getNegativeEffect(java.lang.String json, String userInputName) {
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        JsonObject metadata = result.getAsJsonObject(userInputName);
        String negativeEffect = "";
        JsonArray negativeEffects = metadata.getAsJsonObject("effects").getAsJsonArray("negative");

        for (JsonElement effectIndividual : negativeEffects) {
            negativeEffect = effectIndividual.getAsString() + ", " + negativeEffect;
        }

        return negativeEffect;
    }

    public static String getMedicalEffect(java.lang.String json, String userInputName) {
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        JsonObject metadata = result.getAsJsonObject(userInputName);
        String medicalEffect = "";
        JsonArray medicalEffects = metadata.getAsJsonObject("effects").getAsJsonArray("medical");

        for (JsonElement effectIndividual : medicalEffects) {
            medicalEffect = effectIndividual.getAsString() + ", " + medicalEffect;
        }

        return medicalEffect;
    }
}