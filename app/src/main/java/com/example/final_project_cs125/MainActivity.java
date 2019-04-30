package  com.example.final_project_cs125;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;


import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.final_project_cs125.lib.code;

public class MainActivity extends AppCompatActivity {

    private RequestQueue queue;


    private static final String TAG = "MP3:Main";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        queue = Volley.newRequestQueue(this);

        final Button searchButton = findViewById(R.id.button);
        searchButton.setOnClickListener(v -> {
            Log.d(TAG, "Button is pressed");
            // Instantiate the RequestQueue.
            RequestQueue queue = Volley.newRequestQueue(this);
            String url ="https://strainapi.evanbusse.com/qazoIsI/strains/search/all";

            // Request a string response from the provided URL.
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            saveUserInput();
                            // Display the first 500 characters of the response string.
                            displayInfo(response);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    TextView textview = findViewById(R.id.textView3);
                    textview.setText("That didn't work!");
                }
            });

            // Add the request to the RequestQueue.
            queue.add(stringRequest);
            //displayInfo();
        });
    }


    private String saveUserInput() {
        final TextInputLayout nameInput;
        nameInput = (TextInputLayout) findViewById(R.id.aSearch);
        String name = nameInput.getEditText().getText().toString();
        nameInput.setErrorEnabled(false);
        nameInput.setError("Cant be blank");
        return name;

    }

    public void displayInfo(final String jsonResult) {
        if (code.checkName(jsonResult, saveUserInput())) {
            TextView textView = findViewById(R.id.textView3);
            String name = code.getName(jsonResult, saveUserInput());
            String race = code.getRace(jsonResult, saveUserInput());
            String flavor = code.getFlavor(jsonResult, saveUserInput());
            String positiveEffect = code.getPositiveEffect(jsonResult, saveUserInput());
            String negativeEffect = code.getNegativeEffect(jsonResult, saveUserInput());
            String medicalEffect = code.getMedicalEffect(jsonResult, saveUserInput());

            String all = name + "\n" + race + "\n" + flavor + "\n" + positiveEffect + "\n" + negativeEffect + "\n" + medicalEffect;
            textView.setText(all);
        } else {
            TextView textView = findViewById(R.id.textView3);
            textView.setText("Something went wrong!");
        }
    }
}