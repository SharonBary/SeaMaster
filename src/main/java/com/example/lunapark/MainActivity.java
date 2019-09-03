package com.example.lunapark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity  {

    //Variables for views
    private TextView  lblName_1, lblNameStatus;
    private ImageView imgHart;
    private ImageButton btmPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        lblName_1 = (TextView)findViewById(R.id.etxtPlayerName);

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
               // timer = new Timer();
               // timer.schedule(task, 1000);

            }
        });
    }

    private void arrangeGame() {
        startActivity(new Intent(this, GameActivity.class));
    }

}
