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

        getWindow().setLayout((int)(width*.8),(int)(height*.8));

        String ResultTxt = "";

        String user_invocation = getResources().getString(R.string.user_invocation);
        String result_score = getResources().getString(R.string.result_score);

        if (MainActivity.score != 0 & MainActivity.score != 10) {
            ResultTxt = getResources().getString(R.string.result_low);
        }

        if (MainActivity.score == 0) {
            ResultTxt = getResources().getString(R.string.result_zero);
        }


        if (MainActivity.score == 10) {
            ResultTxt = getResources().getString(R.string.result_ten);
        }

        TextView popup_result  = (TextView) findViewById(R.id.popup_result);
        popup_result.setText(user_invocation + " " + MainActivity.user_name + "!" + "\n" + "\n" + ResultTxt + "\n" +  result_score + " " + MainActivity.score + "/10");

    }

    public void CloseWindow (View v) {
        finish();
    }
}
