package kr.ac.cnu.pyeongchang101.pyeongchang101;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by HwangTaeWook on 2017-08-24.
 */

public class MainActivity extends AppCompatActivity {
    int healing = 0;
    int training = 0;
    int alba = 0;

    Button healingButton;
    Button trainingButton;
    Button albaButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        healingButton = (Button) findViewById(R.id.healing_btn);
        trainingButton = (Button) findViewById(R.id.training_btn);
        albaButton = (Button) findViewById(R.id.alba_btn);
    }

    public void onClickHealing(View view) {
        if (healing == 0) {
            healingButton.setBackgroundResource(R.drawable.healing_btn_big);
            trainingButton.setBackgroundResource(R.drawable.training_btn_small);
            albaButton.setBackgroundResource(R.drawable.alba_btn_small);
            healing = 1;
            training = 0;
            alba = 0;
        } else {
            Intent intent = new Intent(this, HealingActivity.class);
            startActivity(intent);
            finish();
        }
    }


    public void onClickTraining(View view) {
        if (training == 0) {
            healingButton.setBackgroundResource(R.drawable.healing_btn_small);
            trainingButton.setBackgroundResource(R.drawable.training_btn_big);
            albaButton.setBackgroundResource(R.drawable.alba_btn_small);
            healing = 0;
            training = 1;
            alba = 0;
        } else {
            Intent intent = new Intent(this, TrainingActivity.class);
            startActivity(intent);
            finish();
        }
    }


    public void onClickAlba(View view) {
        if (alba == 0) {
            healingButton.setBackgroundResource(R.drawable.healing_btn_small);
            trainingButton.setBackgroundResource(R.drawable.training_btn_small);
            albaButton.setBackgroundResource(R.drawable.alba_btn_big);
            healing = 0;
            training = 0;
            alba = 1;
        } else {
            Intent intent = new Intent(this, AlbaActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
