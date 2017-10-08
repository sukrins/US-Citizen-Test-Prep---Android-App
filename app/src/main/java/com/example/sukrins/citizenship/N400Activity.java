package com.example.sukrins.citizenship;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;


/**
 * Created by sukrins on 12/4/15.
 */
public class N400Activity extends AppCompatActivity {

    List<N400Question> questionList;
    int score = 0;
    int id = 0;

    N400Question question;
    TextView text;
    RadioButton rb1, rb2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.n400_activity);

        N400Database db = new N400Database(this);
        questionList = db.getAllQuestions();
        question = questionList.get(id);
        text = (TextView) findViewById(R.id.n400_question);
        rb1 = (RadioButton) findViewById(R.id.radio_1);
        rb2 = (RadioButton) findViewById(R.id.radio_2);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_Group);
                RadioButton answer = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());

                if (question.getAnswer().equals(answer.getText())) {
                    score++;
                }

                if(id<30){
                    question = questionList.get(id);
                    viewQuestions();
                }else{
                    Intent intent = new Intent(N400Activity.this,N400Result.class);
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
        text.setText(question.getQuestion());
        rb1.setText(question.getYes());
        rb2.setText(question.getNo());
        id++;
    }


}
