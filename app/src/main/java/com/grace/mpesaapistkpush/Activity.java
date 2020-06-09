package com.grace.mpesaapistkpush;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;

public class Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);

        Button Gen = findViewById(R.id.Generate);

        Gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Auth auth = new Auth();
                try {
                    TextView View = findViewById(R.id.view);
                    View.setText(auth.genToken());
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
