package kr.ac.cnu.pyeongchang101.pyeongchang101;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by HwangTaeWook on 2017-08-24.
 */

public class MainActivity extends AppCompatActivity {
    int healing = 0;
    int training = 0;
    int alba = 0;
    int item = 0;

    Button healingButton;
    Button trainingButton;
    Button albaButton;
    Button healingButtonBig;
    Button trainingButtonBig;
    Button albaButtonBig;

    RelativeLayout itemLayout;

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

    private View 	decorView;
    private int	uiOption;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        healingButton = (Button) findViewById(R.id.healing_btn);
        trainingButton = (Button) findViewById(R.id.training_btn);
        albaButton = (Button) findViewById(R.id.alba_btn);
        healingButtonBig = (Button) findViewById(R.id.healing_btn_big);
        trainingButtonBig = (Button) findViewById(R.id.training_btn_big);
        albaButtonBig = (Button) findViewById(R.id.alba_btn_big);

        itemLayout = (RelativeLayout) findViewById(R.id.activity_item);

        item01Button = (Button) findViewById(R.id.item01);
        item02Button = (Button) findViewById(R.id.item02);
        item03Button = (Button) findViewById(R.id.item03);
        item04Button = (Button) findViewById(R.id.item04);

        itemPopup01 = (ImageView) findViewById(R.id.item_popup01);
        itemPopup04 = (ImageView) findViewById(R.id.item_popup04);

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

    public void onClickHealing(View view) {
        if (healing == 0) {
            healingButton.setVisibility(View.INVISIBLE);
            trainingButton.setVisibility(View.VISIBLE);
            albaButton.setVisibility(View.VISIBLE);
            healingButtonBig.setVisibility(View.VISIBLE);
            trainingButtonBig.setVisibility(View.INVISIBLE);
            albaButtonBig.setVisibility(View.INVISIBLE);
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
            healingButton.setVisibility(View.VISIBLE);
            trainingButton.setVisibility(View.INVISIBLE);
            albaButton.setVisibility(View.VISIBLE);
            healingButtonBig.setVisibility(View.INVISIBLE);
            trainingButtonBig.setVisibility(View.VISIBLE);
            albaButtonBig.setVisibility(View.INVISIBLE);
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
            healingButton.setVisibility(View.VISIBLE);
            trainingButton.setVisibility(View.VISIBLE);
            albaButton.setVisibility(View.INVISIBLE);
            healingButtonBig.setVisibility(View.INVISIBLE);
            trainingButtonBig.setVisibility(View.INVISIBLE);
            albaButtonBig.setVisibility(View.VISIBLE);
            healing = 0;
            training = 0;
            alba = 1;
        } else {
            Intent intent = new Intent(this, AlbaActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void onClickItem(View view) {
        if (item == 0) {
            itemLayout.setVisibility(View.VISIBLE);
            item = 1;
        } else {
            itemLayout.setVisibility(View.INVISIBLE);
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
}
