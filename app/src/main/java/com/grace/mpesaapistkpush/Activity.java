package com.grace.mpesaapistkpush;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONException;
import java.io.IOException;

public class Activity extends AppCompatActivity {
    EditText Phone, Amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);

        Phone = findViewById(R.id.phone);
        Amount = findViewById(R.id.amount);

        Button Gen = findViewById(R.id.Generate);
        Gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {

                SecondThread secondThread = new SecondThread();
                secondThread.start();
                Toast.makeText(Activity.this, "Could not open Send method", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class SecondThread extends Thread{
        @Override
        public void run() {
            STK stk = new STK();
            Constants constants = new Constants();
           // String phoneNumber = Phone.getText().toString();
           // String amountText = Amount.getText().toString();
            try {
                stk.Send(constants.getPhone(), "1");
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }

        }
}}
