package com.example.lunapark;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Constants (Game Settings)
    final int START_TIME = 30;
    final int START_LIVES = 3;
    final int START_SCORE = 0;
    final int WINNING_SCORE=30;

    //Variables for views
    private ImageButton[] allFish;
    private TextView lblNameDetails, lblName_1,lblName_2, lblNameStatus;
    private ImageView imgHart;
    private ImageButton btmPlay;

    private Timer timer;
    private int score;
    private int time;
    private int lives;
    private String playerName;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        lblNameDetails = findViewById(R.id.lbl_score_and_time);
        lblName_1 = (TextView)findViewById(R.id.etxtPlayerName);
        lblName_2 = (TextView)findViewById(R.id.lblPlayerName_2);
        btmPlay = findViewById(R.id.play_btn);




        btmPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                arrangeGame();

                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
     //                           startGame();
                            }
                        });
                    }
                };
                timer = new Timer();
                timer.schedule(task, 1000);

            }
        });
    }

    private void arrangeGame() {
        int i;
        this.score = START_SCORE;
        this.time = START_TIME;
        this.lives = START_LIVES;
        this.playerName = "Hello";

        allFish = new ImageButton[9];
        allFish[0] = findViewById(R.id.fish_1);
        allFish[1] = findViewById(R.id.fish_2);
        allFish[2] = findViewById(R.id.fish_3);
        allFish[3] = findViewById(R.id.fish_4);
        allFish[4] = findViewById(R.id.fish_5);
        allFish[5] = findViewById(R.id.fish_6);
        allFish[6] = findViewById(R.id.fish_7);
        allFish[7] = findViewById(R.id.fish_8);
        allFish[8] = findViewById(R.id.fish_9);


/*
        for( i = 0 ; i < 9 ; i++)
            allFish[i].setOnClickListener(this);

        this.lblName_2.setText("hihi");
        lblNameDetails.setText("Score: "+score+"  Time: "+time);
*/

        setContentView(R.layout.activity_game);

    }
    private void checkHit(int i){


    }

    private void startGame() {

    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.fish_1:
                checkHit(0);
                break;
            case R.id.fish_2:
                checkHit(1);
                break;
            case R.id.fish_3:
                checkHit(2);
                break;
            case R.id.fish_4:
                checkHit(3);
                break;
            case R.id.fish_5:
                checkHit(4);
                break;
            case R.id.fish_6:
                checkHit(5);
                break;
            case R.id.fish_7:
                checkHit(6);
                break;
            case R.id.fish_8:
                checkHit(7);
                break;
            case R.id.fish_9:
                checkHit(8);
                break;
        }

    }
}
