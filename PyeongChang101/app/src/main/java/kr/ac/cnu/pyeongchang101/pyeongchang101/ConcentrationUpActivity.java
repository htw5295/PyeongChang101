package kr.ac.cnu.pyeongchang101.pyeongchang101;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by HwangTaeWook on 2017-08-25.
 */

public class ConcentrationUpActivity extends AppCompatActivity {
    Handler handler;
    int check = 0;

    RelativeLayout.LayoutParams layoutParams;

    Button happyButton;
    Button sleepButton;
    Button normalButton;
    Button upsetButton;
    Button tiredButton;

    int item = 0;

    RelativeLayout itemLayout;
    RelativeLayout stampLayout;

    int item01 = 1;
    int item02 = 0;
    int item03 = 0;
    int item04 = 0;

    Button item01Button;
    Button item02Button;
    Button item03Button;
    Button item04Button;

    ImageView itemPopup01;
    ImageView itemPopup04;

    private View decorView;
    private int uiOption;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_concentrationup);

        //layoutParams = (RelativeLayout.LayoutParams) findViewById(R.id.concentration_field).getLayoutParams();
        happyButton = (Button) findViewById(R.id.concentration_face_happy);
        sleepButton = (Button) findViewById(R.id.concentration_face_sleep);
        normalButton = (Button) findViewById(R.id.concentration_face_normal);
        upsetButton = (Button) findViewById(R.id.concentration_face_upset);
        tiredButton = (Button) findViewById(R.id.concentration_face_tired);

        itemLayout = (RelativeLayout) findViewById(R.id.activity_item);
        stampLayout = (RelativeLayout) findViewById(R.id.activity_stamp);

        item01Button = (Button) findViewById(R.id.item01);
        item02Button = (Button) findViewById(R.id.item02);
        item03Button = (Button) findViewById(R.id.item03);
        item04Button = (Button) findViewById(R.id.item04);

        itemPopup01 = (ImageView) findViewById(R.id.item_popup01);
        itemPopup04 = (ImageView) findViewById(R.id.item_popup04);

//        decorView = getWindow().getDecorView();
//        uiOption = getWindow().getDecorView().getSystemUiVisibility();
//        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH )
//            uiOption |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
//        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN )
//            uiOption |= View.SYSTEM_UI_FLAG_FULLSCREEN;
//        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT )
//            uiOption |= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
    }

//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        // TODO Auto-generated method stub
//        // super.onWindowFocusChanged(hasFocus);
//
//        if( hasFocus ) {
//            decorView.setSystemUiVisibility( uiOption );
//        }
//    }

    public void onClickConcentrationUpStart(View view) {
        findViewById(R.id.concentration_popup).setVisibility(View.INVISIBLE);
        findViewById(R.id.concentration_black).setVisibility(View.INVISIBLE);

        new Thread(new MoveButtonRunnable(happyButton)).start();
        new Thread(new MoveButtonRunnable(sleepButton)).start();
        new Thread(new MoveButtonRunnable(normalButton)).start();
        new Thread(new MoveButtonRunnable(upsetButton)).start();
        new Thread(new MoveButtonRunnable(tiredButton)).start();
    }

    class MoveButtonRunnable implements Runnable {
        Button button;

        public MoveButtonRunnable(Button button) {
            this.button = button;
        }

        @Override
        public void run() {
            android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
            for (int i = 0; i < 60; i++) {
                try {
                    Thread.sleep(((int)(Math.random() * 5) + 10) * 100);
                    final int finalI = i;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            RelativeLayout.LayoutParams temp = new RelativeLayout.LayoutParams(240, 350);
                            temp.topMargin = (int) (Math.random() * 350);
                            temp.leftMargin = (int) (Math.random() * 1850);
                            button.setLayoutParams(temp);
                            button.setVisibility(View.VISIBLE);

                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onClickCorrect(View view) {
        view.setVisibility(View.INVISIBLE);
        check++;
    }

    public void onClickWrong(View view) {
        view.setVisibility(View.INVISIBLE);
        check -= 5;
    }

    public void onClickHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void onClickItem(View view) {
        if (item == 0) {
            itemLayout.setVisibility(View.VISIBLE);
            item = 1;
        } else {
            itemLayout.setVisibility(View.INVISIBLE);
            stampLayout.setVisibility(View.INVISIBLE);
            item = 0;
        }
    }

    public void onClickItem01(View view) {
        if (item01 == 0) {
            itemPopup01.setVisibility(View.VISIBLE);
            itemPopup04.setVisibility(View.INVISIBLE);

            item01Button.setBackgroundResource(R.drawable.seleted_item1);
            item02Button.setBackgroundResource(R.drawable.unseleted_item2);
            item03Button.setBackgroundResource(R.drawable.unseleted_item3);
            item04Button.setBackgroundResource(R.drawable.unseleted_item4);

            item01 = 1;
            item02 = 0;
            item03 = 0;
            item04 = 0;
        }
    }

    public void onClickItem02(View view) {
        if (item02 == 0) {
            item01Button.setBackgroundResource(R.drawable.unseleted_item1);
            item02Button.setBackgroundResource(R.drawable.seleted_item2);
            item03Button.setBackgroundResource(R.drawable.unseleted_item3);
            item04Button.setBackgroundResource(R.drawable.unseleted_item4);

            item01 = 0;
            item02 = 1;
            item03 = 0;
            item04 = 0;
        }
    }

    public void onClickItem03(View view) {
        if (item03 == 0) {
            item01Button.setBackgroundResource(R.drawable.unseleted_item1);
            item02Button.setBackgroundResource(R.drawable.unseleted_item2);
            item03Button.setBackgroundResource(R.drawable.seleted_item3);
            item04Button.setBackgroundResource(R.drawable.unseleted_item4);

            item01 = 0;
            item02 = 0;
            item03 = 1;
            item04 = 0;
        }
    }

    public void onClickItem04(View view) {
        if (item04 == 0) {
            itemPopup01.setVisibility(View.INVISIBLE);
            itemPopup04.setVisibility(View.VISIBLE);

            item01Button.setBackgroundResource(R.drawable.unseleted_item1);
            item02Button.setBackgroundResource(R.drawable.unseleted_item2);
            item03Button.setBackgroundResource(R.drawable.unseleted_item3);
            item04Button.setBackgroundResource(R.drawable.seleted_item4);

            item01 = 0;
            item02 = 0;
            item03 = 0;
            item04 = 1;
        }
    }

    public void onClickStamp(View view) {
        stampLayout.setVisibility(View.VISIBLE);
        itemLayout.setVisibility(View.INVISIBLE);
    }

    public void onClickItemBox(View view) {
        stampLayout.setVisibility(View.INVISIBLE);
        itemLayout.setVisibility(View.VISIBLE);
    }
}
