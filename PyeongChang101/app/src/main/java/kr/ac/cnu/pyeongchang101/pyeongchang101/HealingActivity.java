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

public class HealingActivity extends AppCompatActivity {
    int jungsun = 0;
    int pyeongchang = 1;
    int gangneung = 0;
    int food = 1;
    int area = 0;
    int item = 0;

    Button jungsunButton;
    Button pyeongchangButton;
    Button gangneungButton;
    Button jungsunButtonBig;
    Button pyeongchangButtonBig;
    Button gangneungButtonBig;
    Button foodButton;
    Button areaButton;
    ImageView bg;

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

    private View 	decorView;
    private int	uiOption;

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

        itemLayout = (RelativeLayout) findViewById(R.id.activity_item);
        stampLayout = (RelativeLayout) findViewById(R.id.activity_stamp);

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

    public void onClickGo(View view) {
        if (false) {

        }
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
