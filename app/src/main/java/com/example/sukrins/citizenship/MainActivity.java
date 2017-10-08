package com.example.sukrins.citizenship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView civicText, n400Text, vocabText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClickButtonListener();
        onClickButtonListener2();
        onClickButtonListener3();

    }

    public void onClickButtonListener(){
        civicText = (TextView) findViewById(R.id.civic_questions);

        civicText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent("com.example.sukrins.citizenship.CivicActivity");

                startActivity(intent);

            }
        });

    }

    public void onClickButtonListener2() {
        n400Text = (TextView) findViewById(R.id.n400_prep);

        n400Text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent("com.example.sukrins.citizenship.N400Activity");

                startActivity(intent);
            }
        });
    }

    public void onClickButtonListener3() {
        vocabText = (TextView) findViewById(R.id.n400_vocab);

        vocabText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent("com.example.sukrins.citizenship.VocabActivity");

                startActivity(intent);
            }
        });
    }
}
