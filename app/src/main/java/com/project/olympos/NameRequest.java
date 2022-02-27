package com.project.olympos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NameRequest extends AppCompatActivity {

    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_request);

        et = findViewById(R.id.etNameRequest);
    }

    public void lunchWelcomeScreen(View view) {
        String name = et.getText().toString();
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("firstTime", false).commit();
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putString("UserName", name).commit();
        Intent intent = new Intent(NameRequest.this, Welcome.class);
        startActivity(intent);
    }
}