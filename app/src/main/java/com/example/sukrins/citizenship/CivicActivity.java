package com.example.sukrins.citizenship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.util.List;

public class CivicActivity extends AppCompatActivity {

    List<CivicQuestion> newList;
    int score = 0;
    int id = 0;

    CivicQuestion cQuestion;
    TextView textV;
    RadioButton r1, r2, r3, r4;
    Button cButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.civic_activity);

        CivicDatabase db = new CivicDatabase(this);
        newList = db.getAllQuestions();
        cQuestion = newList.get(id);
        textV = (TextView) findViewById(R.id.civicTextView1);
        r1 = (RadioButton) findViewById(R.id.civicRadio1);
        r2 = (RadioButton) findViewById(R.id.civicRadio2);
        r3 = (RadioButton) findViewById(R.id.civicRadio3);
        r4 = (RadioButton) findViewById(R.id.civicRadio4);
        cButton = (Button) findViewById(R.id.civicButton);

        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.civicRadioGroup);
                RadioButton answer = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());

                if (cQuestion.getAnswer().equals(answer.getText())) {
                    score++;
                }

                if(id<30){
                    cQuestion = newList.get(id);
                    viewQuestions();
                }else{
                    Intent intent = new Intent(CivicActivity.this,CivicResult.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("score", score);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                }

            }
        });


    }

    private void viewQuestions() {
        textV.setText(cQuestion.getQuestion());
        r1.setText(cQuestion.getA());
        r2.setText(cQuestion.getB());
        r3.setText(cQuestion.getC());
        r4.setText(cQuestion.getD());

        id++;
    }

}
