package kr.ac.cnu.pyeongchang101.pyeongchang101;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.tsengvn.typekit.TypekitContextWrapper;

/**
 * Created by HwangTaeWook on 2017-08-20.
 */

public class SelectEventActivity extends AppCompatActivity {
    int check = 1;
    View prevView;

    private View 	decorView;
    private int	uiOption;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_selectevent);

        prevView = (View) findViewById(R.id.sport_btn_small02);

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

    public void onClickEvent(View view) {
        if (check == 0) {
            changeImageBig(view);
            prevView = view;
            check = 1;
        } else {
            if (prevView.equals(view)) {
                Intent intent = new Intent(this, SelectModeActivity.class);
                startActivity(intent);
                finish();
            } else {
                changeImageBig(view);
                changeImageSmall(prevView);
                prevView = view;
            }
        }
    }

    public void changeImageBig(View view) {
        switch ((String)view.getTag()) {
            case "1":
                view.setBackgroundResource(R.drawable.figureskating_big);
                break;
            case "2":
                view.setBackgroundResource(R.drawable.speedskating_big);
                break;
            case "3":
                view.setBackgroundResource(R.drawable.sport_btn_big);
                break;
            case "4":
                view.setBackgroundResource(R.drawable.curling_big);
                break;
            case "5":
                view.setBackgroundResource(R.drawable.hockey_big);
                break;
        }
    }

    public void changeImageSmall(View view) {
        switch ((String)view.getTag()) {
            case "1":
                view.setBackgroundResource(R.drawable.figureskating_small);
                break;
            case "2":
                view.setBackgroundResource(R.drawable.speedskating_small);
                break;
            case "3":
                view.setBackgroundResource(R.drawable.sport_btn_small);
                break;
            case "4":
                view.setBackgroundResource(R.drawable.curling_small);
                break;
            case "5":
                view.setBackgroundResource(R.drawable.hockey_small);
                break;
        }
    }
}
