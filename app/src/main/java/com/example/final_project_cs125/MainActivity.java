package com.example.final_project_cs125;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.final_project_cs125.lib.code;

public class MainActivity extends AppCompatActivity {

    private RequestQueue requestQueue;


    private static final String TAG = "MP3:Main";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestQueue = Volley.newRequestQueue(this);

        final Button searchButton = findViewById(R.id.button);
        searchButton.setOnClickListener(v -> {
            Log.d(TAG, "Button is pressed");
            saveUserInput();
            displayInfo();
        });
    }


    public String saveUserInput() {
        final TextInputLayout nameInput;
        nameInput = (TextInputLayout) findViewById(R.id.aSearch);
        String name = nameInput.getEditText().getText().toString();
        nameInput.setErrorEnabled(false);
        nameInput.setError("Cant be blank");
        return name;
    }

    public void displayInfo(final String jsonResult) {
        TextView textView = findViewById(R.id.textView3);
        if (code.checkName(jsonResult, saveUserInput()) == true) {
            String name = code.getName(jsonResult, saveUserInput());
            String race = code.getRace(jsonResult, saveUserInput());
            String flavor = code.getFlavor(jsonResult, saveUserInput());
            String positiveEffect = code.getPositiveEffect(jsonResult, saveUserInput());
            String negativeEffect = code.getNegativeEffect(jsonResult, saveUserInput());
            String medicalEffect = code.getMedicalEffect(jsonResult, saveUserInput());

            String all = name + "\n" + race + "\n" + flavor + "\n" + positiveEffect + "\n" + negativeEffect + "\n" + medicalEffect;
            textView.setText(all);
        }
    }

}
