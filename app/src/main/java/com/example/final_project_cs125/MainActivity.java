package com.example.final_project_cs125;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import com.android.volley.*;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.*;
import org.json.*;

public class MainActivity extends AppCompatActivity {



    private static final String TAG = "MP3:Main";

    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        queue = Volley.newRequestQueue(this);

        final Button searchButton = findViewById(R.id.button);
        searchButton.setOnClickListener(v -> {
            Log.d(TAG, "Button is pressed");
            saveUserInput();
        });

        final TextInputLayout nameInput;
        nameInput = (TextInputLayout) findViewById(R.id.aSearch);
        String name = nameInput.getEditText().getText().toString();
        nameInput.setErrorEnabled(false);
        nameInput.setError("Cant be blank");

    }

    public void saveUserInput() {
        return;
    }

//    private StringRequest searchNameStringRequest(String nameSearch) {
//        final String API = "&api_key=<<qazoIsI>>";
//        final String NAME_SEARCH = "&q=";
//        final String DATA_SOURCE = "&ds=Standard Reference";
//        final String SORT = "&sort=r";
//        final String URL_PREFIX = "strainapi.evanbusse.com/API_KEY/strains/search/flavor/FLAVOR";
//
//        String url = URL_PREFIX + API + NAME_SEARCH + nameSearch + DATA_SOURCE + SORT;
//
//        // 1st param => type of method (GET/PUT/POST/PATCH/etc)
//        // 2nd param => complete url of the API
//        // 3rd param => Response.Listener -> Success procedure
//        // 4th param => Response.ErrorListener -> Error procedure
//        return new StringRequest(Request.Method.GET, url,
//                new Response.Listener<String>() {
//                    // 3rd param - method onResponse lays the code procedure of success return
//                    // SUCCESS
//                    @Override
//                    public void onResponse(String response) {
//                        // try/catch block for returned JSON data
//                        // see API's documentation for returned format
//                        try {
//                            JSONObject result = new JSONObject(response).getJSONObject("list");
//                            int maxItems = result.getInt("end");
//                            JSONArray resultList = result.getJSONArray("item");
//
////                        ...
//
//                            // catch for the JSON parsing error
//                        } catch (JSONException e) {
//                            return;
//                        }
//                    } // public void onResponse(String response)
//                }, // Response.Listener<String>()
//                new Response.ErrorListener() {
//                    // 4th param - method onErrorResponse lays the code procedure of error return
//                    // ERROR
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        // display a simple message on the screen
//                        return;
//                    }
//                });
//    }

}
