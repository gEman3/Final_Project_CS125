package com.example.lib;
import com.google.gson.*;

public class code {

    public String info;


    // Must use "search/flavor" API
    public static boolean checkName(java.lang.String json, String userInputName) {
        if (userInputName == null) {
            return false;
        }
        JsonParser parser = new JsonParser();
        JsonArray result = parser.parse(json).getAsJsonArray();
        for (JsonElement strain : result) {
            String name = strain.getAsJsonObject().get("name").getAsString();
            if (name.equals(userInputName)) {
                return true;
            }
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