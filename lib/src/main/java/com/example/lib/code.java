package com.example.lib;
import com.google.gson.*;

public class code {
    public static java.lang.String getName(java.lang.String json) {
        if (json == null) {
            return null;
        }
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        JsonObject metaDataObject = result.get("metadata").getAsJsonObject();
        if (metaDataObject.get("format") == null) {
            return null;
        }
        String format = metaDataObject.get("format").getAsString();
        return format;
    }
    public static java.lang.String getRace(java.lang.String json) {
        return null;
    }
    public static java.lang.String getEffect(java.lang.String json) {
        return null;
    }
    public static java.lang.String getFlavor(java.lang.String json) {
        return null;
    }
    public static java.lang.String getAll(java.lang.String json) {
        return null;
    }
}