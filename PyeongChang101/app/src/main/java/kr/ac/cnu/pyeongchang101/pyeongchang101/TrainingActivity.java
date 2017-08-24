package kr.ac.cnu.pyeongchang101.pyeongchang101;

import android.content.Intent;
import android.os.Build;
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
    Button concentrationBigButton;
    Button speedBigButton;

    private View 	decorView;
    private int	uiOption;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_training);

        concentrationButton = (Button) findViewById(R.id.concentration_btn);
        speedButton = (Button) findViewById(R.id.speed_btn);
        concentrationBigButton = (Button) findViewById(R.id.concentration_btn_big);
        speedBigButton = (Button) findViewById(R.id.speed_btn_big);

        decorView = getWindow().getDecorView();
        uiOption = getWindow().getDecorView().getSystemUiVisibility();
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH )
            uiOption |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN )
            uiOption |= View.SYSTEM_UI_FLAG_FULLSCREEN;
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT )
            uiOption |= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        // TODO Auto-generated method stub
        // super.onWindowFocusChanged(hasFocus);

        if( hasFocus ) {
            decorView.setSystemUiVisibility( uiOption );
        }
    }

    public void onClickConcentration(View view) {
        if (concentration == 0) {
            concentrationButton.setVisibility(View.INVISIBLE);
            concentrationBigButton.setVisibility(View.VISIBLE);
            speedButton.setVisibility(View.VISIBLE);
            speedBigButton.setVisibility(View.INVISIBLE);
            concentration = 1;
            speed = 0;
        } else {

        }
    }

    public void onClickSpeed(View view) {
        if (speed == 0) {
            concentrationButton.setVisibility(View.VISIBLE);
            concentrationBigButton.setVisibility(View.INVISIBLE);
            speedButton.setVisibility(View.INVISIBLE);
            speedBigButton.setVisibility(View.VISIBLE);
            concentration = 0;
            speed = 1;
        } else {

        }
    }

    public void onClickHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
