package com.example.mastermind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash_Activity extends AppCompatActivity {
    private static final int SPLASH_DISPLAY_LENGTH = 1500;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                Splash_Activity.this.startActivity(new Intent(Splash_Activity.this, MainActivity.class));
                Splash_Activity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}