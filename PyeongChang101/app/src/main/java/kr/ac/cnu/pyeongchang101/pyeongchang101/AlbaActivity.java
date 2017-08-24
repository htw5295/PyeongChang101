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

public class AlbaActivity extends AppCompatActivity {
    int puzzle = 0;

    Button puzzleButton;
    Button puzzleButtonBig;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_alba);

        puzzleButton = (Button) findViewById(R.id.puzzle_btn);
        puzzleButtonBig = (Button) findViewById(R.id.puzzle_btn_big);
    }

    public void onClickPuzzle(View view) {
        if (puzzle == 0) {
            puzzleButton.setVisibility(View.INVISIBLE);
            puzzleButtonBig.setVisibility(View.VISIBLE);
            puzzle = 1;
        } else {

        }
    }

    public void onClickHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
