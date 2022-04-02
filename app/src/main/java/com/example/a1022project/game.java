package com.example.a1022project;

import androidx.appcompat.app.AppCompatActivity;
import com.example.a1022project.settings;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class game extends AppCompatActivity {
    private TextView timer;
    private TextView letKnowText;
    private TextView numText;
    private EditText guesser;
    private Button guessPrompt;
    private Button mainMenu;
    private Button startRetry;
    private static long timeLeft = 4000;
    private int guessNum = (int) Math.floor(Math.random() * 10);
    private static int level = 1;
    private String tellPlayer;
    private String playerGuess;
    private int guessFin;
    private static int levelFin = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        startGame();
    }

    //Runs the timer for the game
    public void runTimer() {
        timer = findViewById(R.id.textViewTimer);
        letKnowText = findViewById(R.id.textViewText);
        numText = findViewById(R.id.textViewNumber);
        guessPrompt = findViewById(R.id.button);

        timer.setVisibility(View.VISIBLE);
        letKnowText.setText("The number is: ");
        numText.setVisibility(View.VISIBLE);

        CountDownTimer countDown = new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long l) {
                timeLeft = l;
                updateTimer();
            }

            @Override
            public void onFinish() {
                timer.setVisibility(View.GONE);
                letKnowText.setText("");
                numText.setVisibility(View.GONE);

                tellPlayer = "What was the number?";
                letKnowText.setText(tellPlayer);
                guesser.setVisibility(View.VISIBLE);
                guesser.setFocusable(true);
                guessPrompt.setVisibility(View.VISIBLE);
                guessPrompt.setFocusable(true);
            }
        }.start();
    }

    //Updates the seconds left of the timer
    public void updateTimer() {
        int seconds = (int) timeLeft / 1000;

        String timerText = "Time Left: " + seconds;

        timer.setText(timerText);
    }

    //Makes the number harder to guess
    public int harderNum() {
        int addRanNum = (int) Math.floor(Math.random() * 10);

        guessNum *= 10;
        guessNum += addRanNum;

        return guessNum;
    }

    //Starts the game
    public void startGame() {
        letKnowText = findViewById(R.id.textViewText);
        numText = findViewById(R.id.textViewNumber);
        guesser = findViewById(R.id.numInput);
        guessPrompt = findViewById(R.id.button);
        mainMenu = findViewById(R.id.main);
        startRetry = findViewById(R.id.retry);

        mainMenu.setVisibility(View.GONE);
        startRetry.setVisibility(View.GONE);

        tellPlayer = "The number is: ";
        letKnowText.setText(tellPlayer);

        runTimer();
        if(level == 1) {
            numText.setText(String.valueOf(guessNum));
        }
        else if(level > 1) {
            harderNum();
            numText.setText(String.valueOf(guessNum));
        }
    }

    //Checks if the player's guess is right and if not, ends game
    public void guessNum(View view) throws InterruptedException {
        letKnowText = findViewById(R.id.textViewText);
        guesser = findViewById(R.id.numInput);
        guessPrompt = findViewById(R.id.button);
        mainMenu = findViewById(R.id.main);
        startRetry = findViewById(R.id.retry);

        playerGuess = guesser.getText().toString();
        if(isInteger(playerGuess) == true) {
            guessFin = Integer.parseInt(playerGuess);
        }

        if(guessFin == guessNum) {
            tellPlayer = "Good Job!\nNow " + level + " Numbers";
            letKnowText.setText(tellPlayer);
            guesser.setText("");

            Thread.sleep(1000);
            guesser.setVisibility(View.GONE);
            guesser.setFocusable(false);
            guessPrompt.setVisibility(View.GONE);
            guessPrompt.setFocusable(false);

            level++;
            timeLeft = 4000;
            startGame();
        }

        else {
            Thread.sleep(1000);
            letKnowText.setText("Nice Try!\nSCORE: " + level);
            guesser.setVisibility(View.GONE);
            guesser.setFocusable(false);
            guesser.setText("");
            guessPrompt.setVisibility(View.GONE);
            guessPrompt.setFocusable(false);

            mainMenu.setVisibility(View.VISIBLE);
            startRetry.setVisibility(View.VISIBLE);

            if(levelFin < level) {
                level = levelFin;
                setHighScore();
            }

            mainMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openMain();
                }
            });

            startRetry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    guesser.setText("");
                    guessNum = (int) Math.floor(Math.random() * 10);
                    level = 1;
                    timeLeft = 4000;

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    startGame();
                }
            });
        }
    }

    public void openMain() {
        Intent mainMenu = new Intent(this, MainActivity.class);
        startActivity(mainMenu);
    }

    public boolean isInteger(String playerGuess) {
        try {
            Integer.parseInt(playerGuess);
        }
        catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public static void setTimer(long time) {
        timeLeft = time;
    }

    public static long getTimer() {
        timeLeft = timeLeft / 1000;
        return timeLeft;
    }

    public static int getHighScore() {
        return levelFin;
    }

    public void setHighScore() {
        levelFin = level;
    }

}