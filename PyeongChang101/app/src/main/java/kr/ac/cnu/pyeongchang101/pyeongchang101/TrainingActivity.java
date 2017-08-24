package kr.ac.cnu.pyeongchang101.pyeongchang101;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by HwangTaeWook on 2017-08-24.
 */

public class TrainingActivity extends AppCompatActivity {
    int concentration = 0;
    int speed = 0;

    Button concentrationButton;
    Button speedButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_training);

        concentrationButton = (Button) findViewById(R.id.concentration_btn);
        speedButton = (Button) findViewById(R.id.speed_btn);
    }

    public void onClickConcentration(View view) {
        if (concentration == 0) {
            concentrationButton.setBackgroundResource(R.drawable.selected_concentration_btn);
            speedButton.setBackgroundResource(R.drawable.unselected_speed_btn);
            concentration = 1;
            speed = 0;
        } else {

        }
    }

    public void onClickSpeed(View view) {
        if (speed == 0) {
            concentrationButton.setBackgroundResource(R.drawable.unselected_concentration_btn);
            speedButton.setBackgroundResource(R.drawable.selected_speed_btn);
            concentration = 0;
            speed = 1;
        } else {

        }
    }
}
