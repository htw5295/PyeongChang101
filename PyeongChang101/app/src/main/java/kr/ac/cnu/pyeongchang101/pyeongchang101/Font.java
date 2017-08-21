package kr.ac.cnu.pyeongchang101.pyeongchang101;

import android.app.Application;

import com.tsengvn.typekit.Typekit;

/**
 * Created by HwangTaeWook on 2017-08-21.
 */

public class Font extends Application {

    public void onCreate() {
        super.onCreate();

        Typekit.getInstance()
                .addNormal(Typekit.createFromAsset(this, "fonts/NanumBarunGothic.ttf"))
                .addBold(Typekit.createFromAsset(this, "fonts/NanumBarunGothicBold.ttf"));
    }
}
