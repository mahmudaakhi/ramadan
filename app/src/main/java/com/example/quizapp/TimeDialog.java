package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TimeDialog {

    private Context mContext;
    private Dialog TimerDialog;

    private TextView textviewTimeUP;

    public TimeDialog(Context mContext) {
        this.mContext = mContext;
    }

    public void timerDialog() {


        TimerDialog = new Dialog(mContext);
        TimerDialog.setContentView(R.layout.time_dialog);

        final Button btTimer = (Button) TimerDialog.findViewById(R.id.bt_timer);


        btTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimerDialog.dismiss();
                Intent intent = new Intent(mContext, MainActivity.class);
                mContext.startActivity(intent);


            }
        });

        TimerDialog.show();
        TimerDialog.setCancelable(false);
        TimerDialog.setCanceledOnTouchOutside(false);

        TimerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }
}

