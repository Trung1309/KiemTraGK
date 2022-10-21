package com.example.tonghop;

import android.app.Activity;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Progress_Animation extends Animation {
    private Activity activity;
    private ProgressBar progressBar;
    private TextView txt;
    private float from, to;

    public Progress_Animation(Activity activity, ProgressBar progressBar, TextView txt, float from, float to) {
        this.activity = activity;
        this.progressBar = progressBar;
        this.txt = txt;
        this.from = from;
        this.to = to;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        float value = from + (to - from) * interpolatedTime;
        progressBar.setProgress((int) value);
        txt.setText((int) value+ "%");
        if (value == to){
            activity.startActivity(new Intent(activity,DangNhap_Activity.class));
            activity.finish();
        }
    }
}
