package kr.ac.cnu.pyeongchang101.pyeongchang101;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.tsengvn.typekit.TypekitContextWrapper;

/**
 * Created by HwangTaeWook on 2017-08-20.
 */

public class SelectEventActivity extends AppCompatActivity {
    int check = 0;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_selectevent);
    }

    public void onClickEvent(View view) {
        if (check == 0) {
            ((Button) view).setBackgroundResource(R.drawable.sport_btn_big);
            ((Button) view).setWidth(550);
            ((Button) view).setHeight(550);
            check = 1;
        } else {
            Intent intent = new Intent(this, SelectModeActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
