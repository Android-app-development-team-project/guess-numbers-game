package com.example.game;

import static java.util.Collections.shuffle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button easyButton, hardButton;
    Intent easyIntent, hardIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        easyIntent = new Intent(this, InGameEasy.class);
        hardIntent = new Intent(this, InGameHard.class);
        easyButton = (Button)findViewById(R.id.easyLevel);
        hardButton = (Button)findViewById(R.id.hardLevel);
        easyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // easy모드로 이동.
                startActivity(easyIntent);
            }
        });
        hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // hard 모드로 이동.
                startActivity(hardIntent);
            }
        });
    }
}