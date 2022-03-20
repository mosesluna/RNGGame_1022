package com.example.a1022project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button start;
    private Button scores;
    private Button settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.startButton);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGame();
            }
        });

        scores = (Button) findViewById(R.id.scoresButton);
        scores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openScores();
            }
        });

        settings = (Button) findViewById(R.id.settingsButton);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSettings();
            }
        });
    }

    public void openGame() {
        Intent game = new Intent(this, game.class);
        startActivity(game);
    }

    public void openScores() {
        Intent scores = new Intent(this, scores.class);
        startActivity(scores);
    }

    public void openSettings() {
        Intent settings = new Intent(this, settings.class);
        startActivity(settings);
    }
}