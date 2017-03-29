package com.example.android.astrologyquiz;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import static android.R.attr.value;
import static com.example.android.astrologyquiz.R.id.q01_Answer;
import static com.example.android.astrologyquiz.R.id.q02_answer;
import static com.example.android.astrologyquiz.R.id.q03_Answer_a;
import static com.example.android.astrologyquiz.R.id.q03_Answer_b;
import static com.example.android.astrologyquiz.R.id.q03_Answer_c;
import static com.example.android.astrologyquiz.R.id.q05_btn_1;
import static com.example.android.astrologyquiz.R.id.q05_btn_3;
import static com.example.android.astrologyquiz.R.id.q06_Answer;
import static com.example.android.astrologyquiz.R.id.q06_btn_1;
import static com.example.android.astrologyquiz.R.id.q06_btn_2;
import static com.example.android.astrologyquiz.R.id.q06_btn_4;
import static com.example.android.astrologyquiz.R.id.q07_Answer;
import static com.example.android.astrologyquiz.R.id.resultTxt_01;
import static com.example.android.astrologyquiz.R.id.resultTxt_02;
import static com.example.android.astrologyquiz.R.id.resultTxt_07;
import static com.example.android.astrologyquiz.R.string.correctanswer;
import static com.example.android.astrologyquiz.R.string.question_02;
import static com.example.android.astrologyquiz.R.string.wronganswer;

public class MainActivity extends AppCompatActivity {
    public static int score = 0;
    public static String user_name = "";

    public static boolean result_on_screen = false;

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        setContentView(R.layout.activity_main);


        Log.v("MainActivity", "rotate: " + result_on_screen);
        Log.v("MainActivity", "Score: " + score);
        Log.v("MainActivity", "User name: " + user_name);

        //** Initialize UI ** //

            //** Result Text hide
            TextView resultTxt_01 = (TextView) findViewById(R.id.resultTxt_01);
            resultTxt_01.setVisibility(View.GONE);

            TextView resultTxt_02 = (TextView) findViewById(R.id.resultTxt_02);
            resultTxt_02.setVisibility(View.GONE);

            TextView resultTxt_03 = (TextView) findViewById(R.id.resultTxt_03);
            resultTxt_03.setVisibility(View.GONE);

            TextView resultTxt_04 = (TextView) findViewById(R.id.resultTxt_04);
            resultTxt_04.setVisibility(View.GONE);

            TextView resultTxt_05 = (TextView) findViewById(R.id.resultTxt_05);
            resultTxt_05.setVisibility(View.GONE);

            TextView resultTxt_06 = (TextView) findViewById(R.id.resultTxt_06);
            resultTxt_06.setVisibility(View.GONE);

            TextView resultTxt_07 = (TextView) findViewById(R.id.resultTxt_07);
            resultTxt_07.setVisibility(View.GONE);

            TextView resultTxt_08 = (TextView) findViewById(R.id.resultTxt_08);
            resultTxt_08.setVisibility(View.GONE);

            TextView resultTxt_09 = (TextView) findViewById(R.id.resultTxt_09);
            resultTxt_09.setVisibility(View.GONE);


            TextView resultTxt_10 = (TextView) findViewById(R.id.resultTxt_10);
            resultTxt_10.setVisibility(View.GONE);

            //** Reset button visibility setting ("Try again!")**//
            Button btnReset = (Button) findViewById(R.id.reset);
            btnReset.setVisibility(View.GONE);

            //** Submit button - calculate result **//
            Button btnSubmit = (Button) findViewById(R.id.submit_sign);
            btnSubmit.setVisibility(View.VISIBLE);

        Log.v("MainActivity", "Calculate? " + result_on_screen);
            if (result_on_screen) {
                Log.v("MainActivity", "Rotating calculate refresh");
                calculateResult();
            }


        ;
        //** End of Initialize UI ** //


        btnSubmit.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             ButtonAnimation(v);
                                             Log.v("MainActivity", "Submit Button Press");
                                             calculateResult();
                                         }
                                     }
        );

        //** Submit button, calculate result **//
        btnReset.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             ButtonAnimation(v);
                                             Log.v("MainActivity", "Reset Button Press");
                                             // restart quiz
                                             result_on_screen = false;
                                             finish();
                                             startActivity(getIntent());
                                         }
                                     }
        );

    }


    public void Answer04_Click_RadioGroup_Simulation (View v)
    {   RadioButton q04_btn_1 = (RadioButton)findViewById(R.id.q04_btn_1);
        RadioButton q04_btn_3 = (RadioButton)findViewById(R.id.q04_btn_3);
        RadioButton q04_btn_4 = (RadioButton)findViewById(R.id.q04_btn_4);
        RadioButton q04_Answer = (RadioButton)findViewById(R.id.q04_Answer);

        switch (v.getId()) {
            case R.id.q04_btn_1:
                q04_btn_3.setChecked(false);
                q04_btn_4.setChecked(false);
                q04_Answer.setChecked(false);
                break;
            case R.id.q04_btn_3:
                q04_btn_1.setChecked(false);
                q04_btn_4.setChecked(false);
                q04_Answer.setChecked(false);
                break;
            case R.id.q04_btn_4:
                q04_btn_1.setChecked(false);
                q04_btn_3.setChecked(false);
                q04_Answer.setChecked(false);
                break;
            case R.id.q04_Answer:
                q04_btn_1.setChecked(false);
                q04_btn_3.setChecked(false);
                q04_btn_4.setChecked(false);
                break;
        }


    }

    public void Answer05_Click_RadioGroup_Simulation (View v)
    {   RadioButton q05_btn_1 = (RadioButton)findViewById(R.id.q05_btn_1);
        RadioButton q05_btn_2 = (RadioButton)findViewById(R.id.q05_btn_2);
        RadioButton q05_btn_3 = (RadioButton)findViewById(R.id.q05_btn_3);
        RadioButton q05_Answer = (RadioButton)findViewById(R.id.q05_Answer);

        switch (v.getId()) {
            case R.id.q05_btn_1:
                q05_btn_2.setChecked(false);
                q05_btn_3.setChecked(false);
                q05_Answer.setChecked(false);
                break;
            case R.id.q05_btn_2:
                q05_btn_1.setChecked(false);
                q05_btn_3.setChecked(false);
                q05_Answer.setChecked(false);
                break;
            case R.id.q05_btn_3:
                q05_btn_1.setChecked(false);
                q05_btn_2.setChecked(false);
                q05_Answer.setChecked(false);
                break;
            case R.id.q05_Answer:
                q05_btn_1.setChecked(false);
                q05_btn_2.setChecked(false);
                q05_btn_3.setChecked(false);
                break;
        }

    }

    public void Answer06_Click_RadioGroup_Simulation (View v)
    {   RadioButton q06_btn_1 = (RadioButton)findViewById(R.id.q06_btn_1);
        RadioButton q06_btn_2 = (RadioButton)findViewById(R.id.q06_btn_2);
        RadioButton q06_btn_4 = (RadioButton)findViewById(R.id.q06_btn_4);
        RadioButton q06_Answer = (RadioButton)findViewById(R.id.q06_Answer);

        switch (v.getId()) {
            case R.id.q06_btn_1:
                q06_btn_2.setChecked(false);
                q06_btn_4.setChecked(false);
                q06_Answer.setChecked(false);
                break;
            case R.id.q06_btn_2:
                q06_btn_1.setChecked(false);
                q06_btn_4.setChecked(false);
                q06_Answer.setChecked(false);
                break;
            case R.id.q06_btn_4:
                q06_btn_1.setChecked(false);
                q06_btn_2.setChecked(false);
                q06_Answer.setChecked(false);
                break;
            case R.id.q06_Answer:
                q06_btn_1.setChecked(false);
                q06_btn_2.setChecked(false);
                q06_btn_4.setChecked(false);
                break;
        }

    }

    public void Answer07_Click_RadioGroup_Simulation (View v)
    {   RadioButton q07_Answer = (RadioButton)findViewById(R.id.q07_Answer);
        RadioButton q07_btn_2 = (RadioButton)findViewById(R.id.q07_btn_2);
        RadioButton q07_btn_3 = (RadioButton)findViewById(R.id.q07_btn_3);
        RadioButton q07_btn_4 = (RadioButton)findViewById(R.id.q07_btn_4);

        switch (v.getId()) {
            case R.id.q07_btn_2:
                q07_btn_3.setChecked(false);
                q07_btn_4.setChecked(false);
                q07_Answer.setChecked(false);
                break;
            case R.id.q07_btn_3:
                q07_btn_2.setChecked(false);
                q07_btn_4.setChecked(false);
                q07_Answer.setChecked(false);
                break;
            case R.id.q07_btn_4:
                q07_btn_3.setChecked(false);
                q07_btn_2.setChecked(false);
                q07_Answer.setChecked(false);
                break;
            case R.id.q07_Answer:
                q07_btn_3.setChecked(false);
                q07_btn_2.setChecked(false);
                q07_btn_4.setChecked(false);
                break;
        }

    }



    public void ButtonAnimation(View v) {

        final Animation animTranslate = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        final Animation animScale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        final Animation animRotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);

        AnimationSet sets = new AnimationSet(false);
        sets.addAnimation(animTranslate);
        sets.addAnimation(animAlpha);
        sets.addAnimation(animRotate);
        sets.addAnimation(animScale);
        v.startAnimation(sets);
    }

    public void calculateResult() {
        score = 0;
        Log.v("MainActivity", "CalculateResult - begin");

        //** Submit button visibility setting **//
            Button btnSubmit = (Button) findViewById(R.id.submit_sign);
            btnSubmit.setVisibility(View.GONE);

        // Question 01 Checking

            RadioButton q01_Answer = (RadioButton) findViewById(R.id.q01_Answer);
            RadioButton q01_btn_2 = (RadioButton)findViewById(R.id.q01_btn_2);
            RadioButton q01_btn_3 = (RadioButton)findViewById(R.id.q01_btn_3);
            RadioButton q01_btn_4 = (RadioButton)findViewById(R.id.q01_btn_4);

            boolean question_01_ok = q01_Answer.isChecked();
            TextView resultTxt_01 = (TextView) findViewById(R.id.resultTxt_01);
            resultTxt_01.setVisibility(View.VISIBLE);

            if (question_01_ok) {
                Log.v("MainActivity", "CalculateResult - q1 ok");
                score += 1;
                resultTxt_01.setText(getString(R.string.correctanswer));
            }
            else
            {
                resultTxt_01.setText(getString(R.string.wronganswer));
            }

            // Question 01 - Correct and wrong answers

            q01_Answer.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.correct, 0);
            q01_Answer.refreshDrawableState();

            q01_btn_2.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.wrong, 0);
            q01_btn_2.refreshDrawableState();

            q01_btn_3.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.wrong, 0);
            q01_btn_3.refreshDrawableState();

            q01_btn_4.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.wrong, 0);
            q01_btn_4.refreshDrawableState();


        // Question 02 Checking

            EditText question_02 = (EditText) findViewById(R.id.q02_answer);
            String question_02_Answer = question_02.getText().toString();
            String correctAnswer = getResources().getString(R.string.q02_answer_text);

            TextView resultTxt_02 = (TextView) findViewById(R.id.resultTxt_02);
            resultTxt_02.setVisibility(View.VISIBLE);

            if (question_02_Answer.equals(correctAnswer)) {
                score += 1;
                resultTxt_02.setText(getString(R.string.correctanswer));
                question_02.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.correct, 0);
            }
            else
            {
                resultTxt_02.setText(getString(R.string.wronganswer_02_gemini));
                question_02.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.wrong, 0);
            }


        // Question 03 Checking

            CheckBox q03_Answer_a = (CheckBox) findViewById(R.id.q03_Answer_a);
            boolean q03_Answer_a_chk = q03_Answer_a.isChecked();

            CheckBox q03_Answer_b = (CheckBox) findViewById(R.id.q03_Answer_b);
            boolean q03_Answer_b_chk = q03_Answer_b.isChecked();

            CheckBox q03_Answer_c = (CheckBox) findViewById(R.id.q03_Answer_c);
            boolean q03_Answer_c_chk = q03_Answer_c.isChecked();

            CheckBox q03_Answer_d = (CheckBox) findViewById(R.id.q03_Answer_d);
            boolean q03_Answer_d_chk = q03_Answer_d.isChecked();

            TextView resultTxt_03 = (TextView) findViewById(R.id.resultTxt_03);
            resultTxt_03.setVisibility(View.VISIBLE);
            resultTxt_03.setText(getString(R.string.wronganswer));

             if (!(q03_Answer_b_chk  || q03_Answer_d_chk )) {

                 if ((q03_Answer_a_chk  || q03_Answer_c_chk )) {
                     score += 1;
                     resultTxt_03.setText(getString(R.string.correctanswer));
                     Log.v("MainActivity", "CalculateResult checkbox!!!!");
                 }

                }

            // Question 03 - Correct and wrong answers

            q03_Answer_a.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.correct, 0);
            q03_Answer_a.refreshDrawableState();

            q03_Answer_b.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.wrong, 0);
            q03_Answer_b.refreshDrawableState();

            q03_Answer_c.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.correct, 0);
            q03_Answer_c.refreshDrawableState();

            q03_Answer_d.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.wrong, 0);
            q03_Answer_d.refreshDrawableState();



        // Question 04 Checking
            RadioButton q04_Answer = (RadioButton) findViewById(R.id.q04_Answer);
            RadioButton q04_btn_1 = (RadioButton) (RadioButton)findViewById(R.id.q04_btn_1);
            RadioButton q04_btn_3 = (RadioButton) (RadioButton)findViewById(R.id.q04_btn_3);
            RadioButton q04_btn_4 = (RadioButton) (RadioButton)findViewById(R.id.q04_btn_4);
            boolean question_04_ok = q04_Answer.isChecked();

            TextView resultTxt_04 = (TextView) findViewById(R.id.resultTxt_04);
            resultTxt_04.setVisibility(View.VISIBLE);

            if (question_04_ok) {
                Log.v("MainActivity", "CalculateResult - q4 ok");
                score += 1;

                resultTxt_04.setText(getString(R.string.correctanswer));

            } else {
                resultTxt_04.setText(getString(R.string.wronganswer));
            }

            // Question 04 - Correct and wrong answers
            q04_btn_1.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.wrong, 0);
            q04_btn_1.refreshDrawableState();

            q04_Answer.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.correct, 0);
            q04_Answer.refreshDrawableState();

            q04_btn_3.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.wrong, 0);
            q04_btn_3.refreshDrawableState();

            q04_btn_4.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.wrong, 0);
            q04_btn_4.refreshDrawableState();


        // Question 05 Checking
            RadioButton q05_btn_1 = (RadioButton) (RadioButton)findViewById(R.id.q05_btn_1);
            RadioButton q05_btn_2 = (RadioButton) (RadioButton)findViewById(R.id.q05_btn_2);
            RadioButton q05_btn_3 = (RadioButton) (RadioButton)findViewById(R.id.q05_btn_3);

            RadioButton q05_Answer = (RadioButton) findViewById(R.id.q05_Answer);
            boolean question_05_ok = q05_Answer.isChecked();

            TextView resultTxt_05 = (TextView) findViewById(R.id.resultTxt_05);
            resultTxt_05.setVisibility(View.VISIBLE);

            if (question_05_ok) {
                Log.v("MainActivity", "CalculateResult - q5 ok");
                score += 1;
                resultTxt_05.setText(getString(R.string.correctanswer));
            }
            else
            {
                resultTxt_05.setText(getString(R.string.wronganswer));
            }

            // Question 05 - Correct and wrong answers
            q05_btn_1.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.wrong, 0);
            q05_btn_1.refreshDrawableState();

            q05_Answer.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.correct, 0);
            q05_Answer.refreshDrawableState();

            q05_btn_2.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.wrong, 0);
            q05_btn_2.refreshDrawableState();

            q05_btn_3.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.wrong, 0);
            q05_btn_3.refreshDrawableState();


        // Question 06 Checking

            RadioButton q06_btn_1 = (RadioButton) (RadioButton)findViewById(R.id.q06_btn_1);
            RadioButton q06_btn_2 = (RadioButton) (RadioButton)findViewById(R.id.q06_btn_2);
            RadioButton q06_btn_4 = (RadioButton) (RadioButton)findViewById(R.id.q06_btn_4);
            RadioButton q06_Answer = (RadioButton) findViewById(R.id.q06_Answer);
            boolean question_06_ok = q06_Answer.isChecked();

            TextView resultTxt_06 = (TextView) findViewById(R.id.resultTxt_06);
            resultTxt_06.setVisibility(View.VISIBLE);

            if (question_06_ok) {
                Log.v("MainActivity", "CalculateResult - q6 ok");
                score += 1;
                resultTxt_06.setText(getString(R.string.correctanswer));
            }
            else
            {
                resultTxt_06.setText(getString(R.string.wronganswer));
            }

            // Question 06 - Correct and wrong answers
            q06_btn_1.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.wrong, 0);
            q06_btn_1.refreshDrawableState();

            q06_Answer.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.correct, 0);
            q06_Answer.refreshDrawableState();

            q06_btn_2.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.wrong, 0);
            q06_btn_2.refreshDrawableState();

            q06_btn_4.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.wrong, 0);
            q06_btn_4.refreshDrawableState();

        // Question 07 Checking

            RadioButton q07_btn_2 = (RadioButton) (RadioButton)findViewById(R.id.q07_btn_2);
            RadioButton q07_btn_3 = (RadioButton) (RadioButton)findViewById(R.id.q07_btn_3);
            RadioButton q07_btn_4 = (RadioButton) (RadioButton)findViewById(R.id.q07_btn_4);
            RadioButton q07_Answer = (RadioButton) findViewById(R.id.q07_Answer);
            boolean question_07_ok = q07_Answer.isChecked();

            TextView resultTxt_07 = (TextView) findViewById(R.id.resultTxt_07);
            resultTxt_07.setVisibility(View.VISIBLE);

            if (question_07_ok) {
                Log.v("MainActivity", "CalculateResult - q7 ok");
                score += 1;
                resultTxt_07.setText(getString(R.string.correctanswer));
            }
            else
            {
                resultTxt_07.setText(getString(R.string.wronganswer));
            }

            // Question 07 - Correct and wrong answers

            q07_Answer.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.correct, 0);
            q07_Answer.refreshDrawableState();

            q07_btn_2.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.wrong, 0);
            q07_btn_2.refreshDrawableState();

            q07_btn_3.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.wrong, 0);
            q07_btn_3.refreshDrawableState();

            q07_btn_4.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.wrong, 0);
            q07_btn_4.refreshDrawableState();


        // Question 08 Checking

            RadioButton q08_Answer = (RadioButton) findViewById(R.id.q08_Answer);
            RadioButton q08_btn_2 = (RadioButton)findViewById(R.id.q08_btn_2);
            RadioButton q08_btn_3 = (RadioButton)findViewById(R.id.q08_btn_3);
            RadioButton q08_btn_4 = (RadioButton)findViewById(R.id.q08_btn_4);

            boolean question_08_ok = q08_Answer.isChecked();
            TextView resultTxt_08 = (TextView) findViewById(R.id.resultTxt_08);
            resultTxt_08.setVisibility(View.VISIBLE);

            if (question_08_ok) {
                Log.v("MainActivity", "CalculateResult - q8 ok");
                score += 1;
                resultTxt_08.setText(getString(R.string.correctanswer));
            }
            else
            {
                resultTxt_08.setText(getString(R.string.wronganswer));
            }

            // Question 08 - Correct and wrong answers

            q08_Answer.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.correct, 0);
            q08_Answer.refreshDrawableState();

            q08_btn_2.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.wrong, 0);
            q08_btn_2.refreshDrawableState();

            q08_btn_3.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.wrong, 0);
            q08_btn_3.refreshDrawableState();

            q08_btn_4.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.wrong, 0);
            q08_btn_4.refreshDrawableState();

        // Question 09 Checking

            CheckBox q09_Answer_a = (CheckBox) findViewById(R.id.q09_Answer_a);
            boolean q09_Answer_a_chk = q09_Answer_a.isChecked();

            CheckBox q09_Answer_b = (CheckBox) findViewById(R.id.q09_Answer_b);
            boolean q09_Answer_b_chk = q09_Answer_b.isChecked();

            CheckBox q09_Answer_c = (CheckBox) findViewById(R.id.q09_Answer_c);
            boolean q09_Answer_c_chk = q09_Answer_c.isChecked();

            CheckBox q09_Answer_d = (CheckBox) findViewById(R.id.q09_Answer_d);
            boolean q09_Answer_d_chk = q09_Answer_d.isChecked();

            TextView resultTxt_09 = (TextView) findViewById(R.id.resultTxt_09);
            resultTxt_09.setVisibility(View.VISIBLE);
            resultTxt_09.setText(getString(R.string.wronganswer));

            if (!(q09_Answer_c_chk  || q09_Answer_d_chk )) {

                if ((q09_Answer_a_chk  || q09_Answer_b_chk )) {
                    score += 1;
                    resultTxt_09.setText(getString(R.string.correctanswer));
                    Log.v("MainActivity", "CalculateResult checkbox!!!!");
                }

            }

            // Question 09 - Correct and wrong answers

            q09_Answer_a.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.correct, 0);
            q09_Answer_a.refreshDrawableState();

            q09_Answer_b.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.correct, 0);
            q09_Answer_b.refreshDrawableState();

            q09_Answer_c.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.wrong, 0);
            q09_Answer_c.refreshDrawableState();

            q09_Answer_d.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.wrong, 0);
            q09_Answer_d.refreshDrawableState();



        // Question 10 Checking

            RadioButton q10_btn_1 = (RadioButton) findViewById(R.id.q10_btn_1);
            RadioButton q10_btn_2 = (RadioButton)findViewById(R.id.q10_btn_2);
            RadioButton q10_Answer = (RadioButton)findViewById(R.id.q10_Answer);
            RadioButton q10_btn_4 = (RadioButton)findViewById(R.id.q10_btn_4);

            boolean question_10_ok = q10_Answer.isChecked();
            TextView resultTxt_10 = (TextView) findViewById(R.id.resultTxt_10);
            resultTxt_10.setVisibility(View.VISIBLE);

            if (question_10_ok) {
                Log.v("MainActivity", "CalculateResult - q10 ok");
                score += 1;
                resultTxt_10.setText(getString(R.string.correctanswer));
            }
            else
            {
                resultTxt_10.setText(getString(R.string.wronganswer));
            }

            // Question 10 - Correct and wrong answers

            q10_Answer.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.correct, 0);
            q10_Answer.refreshDrawableState();

            q10_btn_1.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.wrong, 0);
            q10_btn_1.refreshDrawableState();

            q10_btn_2.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.wrong, 0);
            q10_btn_2.refreshDrawableState();

            q10_btn_4.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.wrong, 0);
            q10_btn_4.refreshDrawableState();


        //************************************************************************************************************
        // Show result on screen

        if (!result_on_screen) {
            EditText user_name_et = (EditText) findViewById(R.id.user_name);
            user_name = user_name_et.getText().toString();

            startActivity(new Intent(MainActivity.this, Pop.class));
        }

        result_on_screen = true;

        Button btnReset = (Button) findViewById(R.id.reset);
        btnReset.setVisibility(View.VISIBLE);

            //RadioGroup q01_rg = (RadioGroup) findViewById(R.id.q01_radiogroup);
            //for (int i = 0; i < q01_rg.getChildCount(); i++) {
            //    q01_rg.getChildAt(i).setEnabled(false);
            //}

            //Toast.makeText(this, user_name + ", you are amazing! Score is: " + score, Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onSaveInstanceState(Bundle savedState) {
        super.onSaveInstanceState(savedState);
        // Save the values of the variables here
        savedState.putInt("score", score);
        savedState.putString("user_name", user_name);
        savedState.putBoolean("result_on_screen", result_on_screen);

        Log.v("MainActivity", "onSaveInstanceState, score: " + score + " result_on_screen: " + result_on_screen);

   }

    @Override
    protected void onRestoreInstanceState(Bundle savedState) {
        super.onRestoreInstanceState(savedState);
        // Restore the values of the variables here
        score = savedState.getInt("score");
        user_name = savedState.getString("user_name");
        result_on_screen = savedState.getBoolean("result_on_screen");
        Log.v("MainActivity", "onRestoreInstanceState, score: " + score + " result_on_screen: " + result_on_screen);
    }




}


