package com.example.lib;
import com.google.gson.*;

public class code {
    public static int getIDUsingName(java.lang.String json, String userInputName) {
        if (userInputName == null) {
            return 0;
        }
        JsonParser parser = new JsonParser();
        JsonArray result = parser.parse(json).getAsJsonArray();
        for (JsonElement strain : result) {
            String name = strain.getAsJsonObject().get("name").getAsString();
            if (name.equals(userInputName)) {
                return strain.getAsJsonObject().get("id").getAsInt();
            }
        }
        return 0;
    }
    public static java.lang.String getRace(java.lang.String json, String race) {
        return null;
    }
    public static java.lang.String getEffect(java.lang.String json, String effect) {
        return null;
    }
    public static java.lang.String getFlavor(java.lang.String json, String flavor) {
        return null;
    }
    public static java.lang.String getAll(java.lang.String json) {
        return null;
    }
}