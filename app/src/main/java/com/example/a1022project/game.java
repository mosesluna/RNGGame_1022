package com.example.a1022project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Timer;

public class game extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
    }

    public void startTimer() {
        Timer countdown = new Timer();

    }
}