package com.example.a1022project;

import androidx.appcompat.app.AppCompatActivity;
import com.example.a1022project.game;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class scores extends AppCompatActivity {
    private TextView highScore;
    private int score;
    private String finalSay;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scores);

    /*    back = findViewById(R.id.main_menu);
        highScore = findViewById(R.id.high_score);
        score = game.getHighScore();
        finalSay = "High Score:\n" + score;

        highScore.setText(finalSay);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
            }
        });
    }

    public void goBack() {
        Intent back = new Intent(this, MainActivity.class);
        startActivity(back);
    } */
    }
}