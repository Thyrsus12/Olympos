package com.project.olympos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    boolean firstTime;
    TextView tvWelcome;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //Get isFirstTime
        firstTime = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("firstTime", true);

        if (firstTime) {
            //Lunch Name Request
            Intent intent = new Intent(Welcome.this, NameRequest.class);
            overridePendingTransition(0, 0);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        } else {
            //Get name and lunch main
            name = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                    .getString("UserName", "");
            openApp(true);
        }

        tvWelcome = findViewById(R.id.tvWelcome);
        tvWelcome.setText("Bienvenido a Olympos " + name);

    }

    private void openApp(boolean locationPermission) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Welcome.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        }, 2000);
    }
}