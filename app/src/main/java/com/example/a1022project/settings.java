package com.example.a1022project;

import androidx.appcompat.app.AppCompatActivity;
import com.example.a1022project.game;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class settings extends AppCompatActivity {
    private EditText switchTime;
    private Button setTime;
    private Button back;
    private String setTheTime;
    private long finTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        /* switchTime = findViewById(R.id.switchTime);
        setTime = findViewById(R.id.setTime);
        back = findViewById(R.id.main_menu); */

        //    switchTime.setText(String.valueOf(game.getTimer() / 1000));

        //    setTheTime = switchTime.getText().toString();
        //    finTime = Long.parseLong(setTheTime);

        //    setTime.setOnClickListener(new View.OnClickListener() {
        //        @Override
        //        public void onClick(View view) {
        //            setTimer(finTime);
        //        }
        //    });

        //    back.setOnClickListener(new View.OnClickListener() {
        //        @Override
        //        public void onClick(View view) {
        //            goBack();
        //        }
        //    });
        // }

        //public void setTimer(long time) {
        //    time *= 1000;
        //    game.setTimer(time);
        //}

    /* public void goBack() {
        Intent back = new Intent(this, MainActivity.class);
        startActivity(back);
    } */
    }
}