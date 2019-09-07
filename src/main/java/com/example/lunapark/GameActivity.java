package com.example.lunapark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static android.app.PendingIntent.getActivity;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    //Constants (Game Settings)
    final int START_TIME = 3;
    final int START_LIVES = 3;
    final int START_SCORE = 0;
    final int WINNING_SCORE = 30;
    final int END_GAME_POINTS = 1;
    final int END_GAME_TIME= 2;
    final int END_GAME_LIVES= 3 ;

    final String END_GAME_SCORE_LBL = "Game Finish! Good Game!";
    final String END_GAME_TIME_LBL = "Time Out! Game Over";
    final String END_GAME_LIVES_LBL = "Game Over! Try Again!";

    private TextView lblName_1,lblName_2;
    private ImageButton btmEndGame;
    private ImageButton[] allFish;
    private TextView[] EndgameAllIndicators;
    private TextView lblNameDetails;

    private Timer timer;
    private int score, correntInt;;
    private int time;
    private int lives;
    private int randomInt;
    private boolean isHit;
    private String playerName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        lblName_1 = (TextView)findViewById(R.id.Game_On);
        lblName_2 = (TextView)findViewById(R.id.lblPlayerName_2);
        lblNameDetails = findViewById(R.id.lbl_score_and_time);

        int i;
        isHit = false;
        this.score = START_SCORE;
        this.time = START_TIME;
        this.lives = START_LIVES;
        this.correntInt = 0;

        allFish = new ImageButton[9];
        visableAllFish();

        for( i = 0 ; i < 9 ; i++)
           allFish[i].setOnClickListener((View.OnClickListener) this);

        //this.lblName_2.setText();
        lblNameDetails.setText("Score: "+score+"  Time: "+time);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        startGame();
                    }
                });
            }
        };
        timer = new Timer();
        timer.schedule(task, 1000);
    }

    private void visableAllFish(){
        allFish[0] = findViewById(R.id.fish_1);
        allFish[1] = findViewById(R.id.fish_2);
        allFish[2] = findViewById(R.id.fish_3);
        allFish[3] = findViewById(R.id.fish_4);
        allFish[4] = findViewById(R.id.fish_5);
        allFish[5] = findViewById(R.id.fish_6);
        allFish[6] = findViewById(R.id.fish_7);
        allFish[7] = findViewById(R.id.fish_8);
        allFish[8] = findViewById(R.id.fish_9);
    }

    private void checkHit(int randomInt){
        if(allFish[randomInt].getVisibility() == View.VISIBLE  && this.isHit == false) {
            this.score++;
            this.isHit = true;
        }
    }

    private void startGame() {

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        randomFish();
                        updateDetail();
                        isHit = false;
                        checkEndGame();
                    }
                });
            }
        };
        timer.scheduleAtFixedRate(task, new Date(), 1000);
    }

    private void randomFish(){
        Random randomGenerator = new Random();
        this.randomInt = randomGenerator.nextInt(9);

        if(correntInt == randomInt)
            this.randomInt = randomGenerator.nextInt(9);


        for(int i = 0 ; i < allFish.length ; i++) allFish[i].setVisibility(View.INVISIBLE);
        allFish[this.randomInt].setVisibility(View.VISIBLE);
    }

    private void updateDetail() { //Need to Insert Score!
        this.time--;
        lblNameDetails.setText("Score: "+score+"  Time: "+time);
    }

    private void checkEndGame(){
        if(this.time <= 0)  {
            this.lblName_1.setText(END_GAME_TIME_LBL);
            endGame(END_GAME_TIME);
        }
        else if (this.lives <= 0) {
            this.lblName_1.setText(END_GAME_LIVES_LBL);
            endGame(END_GAME_LIVES);
        }
        else if(this.score >= 30) {
            this.lblName_1.setText(END_GAME_SCORE_LBL);
            endGame(END_GAME_POINTS);
        }
    }

    private void endGame(int EndGameIndicator){
        visableAllFish();
        lblNameDetails.setVisibility(View.INVISIBLE);
        lblName_2.setText("Score: "+score);
        timer.cancel();

        startActivity(new Intent(this, MainActivity.class));

    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.fish_1:
                checkHit(this.randomInt);
                break;
            case R.id.fish_2:
                checkHit(this.randomInt);
                break;
            case R.id.fish_3:
                checkHit(this.randomInt);
                break;
            case R.id.fish_4:
                checkHit(this.randomInt);
                break;
            case R.id.fish_5:
                checkHit(this.randomInt);
                break;
            case R.id.fish_6:
                checkHit(this.randomInt);
                break;
            case R.id.fish_7:
                checkHit(this.randomInt);
                break;
            case R.id.fish_8:
                checkHit(this.randomInt);
                break;
            case R.id.fish_9:
                checkHit(this.randomInt);
                break;
        }

    }
}
