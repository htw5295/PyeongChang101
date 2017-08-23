package kr.ac.cnu.pyeongchang101.pyeongchang101;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by HwangTaeWook on 2017-08-21.
 */

public class SelectModeActivity extends AppCompatActivity {
    int check = 0;
    View prevView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectmode);
        findViewById(R.id.people_2_btn_small).setTag("2");
        findViewById(R.id.people_4_btn_small).setTag("4");
    }

    public void onClickMode(View view) {
        if (check == 0) {
            if (view.getTag().equals("2")) {
                ((Button) view).setBackgroundResource(R.drawable.people_2_btn_big);
            } else {
                ((Button) view).setBackgroundResource(R.drawable.people_4_btn_big);
            }
            prevView = view;
            check = 1;
        } else {
            if (prevView.equals(view)) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                if (view.getTag().equals("2")) {
                    ((Button) view).setBackgroundResource(R.drawable.people_2_btn_big);
                    ((Button) prevView).setBackgroundResource(R.drawable.people_4_btn_small);
                } else {
                    ((Button) prevView).setBackgroundResource(R.drawable.people_2_btn_small);
                    ((Button) view).setBackgroundResource(R.drawable.people_4_btn_big);
                }
                prevView = view;
            }
        }
    }
}
