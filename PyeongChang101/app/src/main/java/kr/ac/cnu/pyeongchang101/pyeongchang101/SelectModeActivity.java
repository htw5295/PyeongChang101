package kr.ac.cnu.pyeongchang101.pyeongchang101;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by HwangTaeWook on 2017-08-21.
 */

public class SelectModeActivity extends AppCompatActivity {
    int check = 0;
    View prevView;

    private View decorView;
    private int uiOption;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_selectmode);
        findViewById(R.id.people_2_btn_small).setTag("2");
        findViewById(R.id.people_4_btn_small).setTag("4");

        decorView = getWindow().getDecorView();
        uiOption = getWindow().getDecorView().getSystemUiVisibility();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH)
            uiOption |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
            uiOption |= View.SYSTEM_UI_FLAG_FULLSCREEN;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            uiOption |= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        // TODO Auto-generated method stub
        // super.onWindowFocusChanged(hasFocus);

        if (hasFocus) {
            decorView.setSystemUiVisibility(uiOption);
        }
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
                Intent intent = new Intent(this, SelectPlayerActivity.class);
                SharedPreferences sf = getSharedPreferences("startInfo", 0);
                SharedPreferences.Editor editor = sf.edit();//저장하려면 editor가 필요
                if ((view.getTag().equals("2"))) {
                    intent.putExtra("mode", 2);
                    editor.putInt("mode", 2);
                } else {
                    intent.putExtra("mode", 4);
                    editor.putInt("mode", 4);
                }
                editor.commit();
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
