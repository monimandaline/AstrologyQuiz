package com.example.android.astrologyquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.astrologyquiz.MainActivity.score;
import static com.example.android.astrologyquiz.R.id.q01_Answer;

/**
 * Created by Csontos Mónika on 2017. 03. 26..
 */
public class Pop extends Activity {

    @Override
    protected void onCreate (Bundle savedInstanceState)
    { super.onCreate(savedInstanceState);

        setContentView(R.layout.popupwindow);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.6));


        if (MainActivity.score != 0) {
            TextView popup_result  = (TextView) findViewById(R.id.popup_result);
            popup_result.setText(MainActivity.user_name + ", you are amazing!" + "\n" + "Score is: " + MainActivity.score);
        }

        if (MainActivity.score == 0) {
            TextView popup_result  = (TextView) findViewById(R.id.popup_result);
            popup_result.setText("Sorry " + MainActivity.user_name + "\n" + "Your Score is: " + MainActivity.score);

        }


    }

    public void CloseWindow (View v) {
        finish();
    }
}
