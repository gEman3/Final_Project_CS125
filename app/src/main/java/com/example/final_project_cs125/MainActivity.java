package com.example.final_project_cs125;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {



    private static final String TAG = "MP3:Main";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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

    public boolean isEmpty() {
        //are 3 boxes empty and 1 box full;
        return true;
    }
}
