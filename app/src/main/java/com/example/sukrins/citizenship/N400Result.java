package com.example.sukrins.citizenship;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by sukrins on 12/5/15.
 */
public class N400Result extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.n400_result);
        RatingBar bar = (RatingBar) findViewById(R.id.theRatingBar);
        bar.setNumStars(5);
        bar.setStepSize(0.01f);

        TextView text = (TextView) findViewById(R.id.theTextResult);
        ImageView image = (ImageView) findViewById(R.id.imageResult);

        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("score");

        double finalScore = (((((double)score)*10)/30)/2);

        System.out.println("Final Score: " + finalScore);

        bar.setRating(Float.parseFloat(String.valueOf(finalScore)));

        if(finalScore >= 5.0){
            text.setText("You did amazing!. You got a perfect score.");
            image.setImageResource(R.drawable.perfect);
        }else if(finalScore > 4.0){
            text.setText("You did great. You got "+ score + " out of 30 questions correct.");
            image.setImageResource(R.drawable.great);
        }else if(finalScore > 3.0){
            text.setText("You did good. You got "+ score + " out of 30 questions correct.");
            image.setImageResource(R.drawable.good);
        }else if(finalScore > 2.0){
            text.setText("You did okay. You only got " + score + " out of 30 questions correct.");
            image.setImageResource(R.drawable.okay);
        }else if(finalScore > 1.0){
            text.setText("You did not do very well. You only got " + score + " out of 30 questions correct.");
            image.setImageResource(R.drawable.bad);
        }else{
            text.setText("You got " + score + " out of 30 questions correct.");
            image.setImageResource(R.drawable.sigh);

        }

          }
}
