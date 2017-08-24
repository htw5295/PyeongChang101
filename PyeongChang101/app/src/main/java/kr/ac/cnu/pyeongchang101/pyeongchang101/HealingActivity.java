package kr.ac.cnu.pyeongchang101.pyeongchang101;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by HwangTaeWook on 2017-08-24.
 */

public class HealingActivity extends AppCompatActivity {
    int jungsun = 0;
    int pyeongchang = 1;
    int gangneung = 0;
    int food = 1;
    int area = 0;

    Button jungsunButton;
    Button pyeongchangButton;
    Button gangneungButton;
    Button jungsunButtonBig;
    Button pyeongchangButtonBig;
    Button gangneungButtonBig;
    Button foodButton;
    Button areaButton;
    ImageView bg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_healing);

        jungsunButton = (Button) findViewById(R.id.jungsun_btn);
        pyeongchangButton = (Button) findViewById(R.id.pyeongchang_btn);
        gangneungButton = (Button) findViewById(R.id.gangneung_btn);
        jungsunButtonBig = (Button) findViewById(R.id.jungsun_btn_big);
        pyeongchangButtonBig = (Button) findViewById(R.id.pyeongchang_btn_big);
        gangneungButtonBig = (Button) findViewById(R.id.gangneung_btn_big);
        foodButton = (Button) findViewById(R.id.food_btn);
        areaButton = (Button) findViewById(R.id.area_btn);
        bg = (ImageView) findViewById(R.id.bg_04);
    }

    public void onClickJungsun(View view) {
        if (jungsun == 0) {
            jungsunButton.setVisibility(View.INVISIBLE);
            pyeongchangButton.setVisibility(View.VISIBLE);
            gangneungButton.setVisibility(View.VISIBLE);
            jungsunButtonBig.setVisibility(View.VISIBLE);
            pyeongchangButtonBig.setVisibility(View.INVISIBLE);
            gangneungButtonBig.setVisibility(View.INVISIBLE);
            jungsun = 1;
            pyeongchang = 0;
            gangneung = 0;
        }
    }

    public void onClickPyeongchang(View view) {
        if (pyeongchang == 0) {
            jungsunButton.setVisibility(View.VISIBLE);
            pyeongchangButton.setVisibility(View.INVISIBLE);
            gangneungButton.setVisibility(View.VISIBLE);
            jungsunButtonBig.setVisibility(View.INVISIBLE);
            pyeongchangButtonBig.setVisibility(View.VISIBLE);
            gangneungButtonBig.setVisibility(View.INVISIBLE);
            jungsun = 0;
            pyeongchang = 1;
            gangneung = 0;
        }
    }

    public void onClickGangneung(View view) {
        if (gangneung == 0) {
            jungsunButton.setVisibility(View.VISIBLE);
            pyeongchangButton.setVisibility(View.VISIBLE);
            gangneungButton.setVisibility(View.INVISIBLE);
            jungsunButtonBig.setVisibility(View.INVISIBLE);
            pyeongchangButtonBig.setVisibility(View.INVISIBLE);
            gangneungButtonBig.setVisibility(View.VISIBLE);
            jungsun = 0;
            pyeongchang = 0;
            gangneung = 1;
        }
    }

    public void onClickFood(View view) {
        if (food == 0) {
            foodButton.setBackgroundResource(R.drawable.selected_food_btn);
            areaButton.setBackgroundResource(R.drawable.unselected_area_btn);
            bg.setImageResource(R.drawable.bg_05);
            food = 1;
            area = 0;
        }
    }

    public void onClickArea(View view) {
        if (area == 0) {
            foodButton.setBackgroundResource(R.drawable.unselected_food_btn);
            areaButton.setBackgroundResource(R.drawable.selected_area_btn);
            bg.setImageResource(R.drawable.bg_06);
            food = 0;
            area = 1;
        }
    }

    public void onClickHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
