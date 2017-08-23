package kr.ac.cnu.pyeongchang101.pyeongchang101;

/**
 * Created by HwangTaeWook on 2017-08-24.
 */

public class Item {
    String name;
    int gender;
    int check;

    public Item(String name, int gender, int check) {
        this.name = name;
        this.gender = gender;
        this.check = check;
    }

    public String getName() {
        return name;
    }

    public int getGender() {
        return gender;
    }

    public int getCheck() {
        return check;
    }
}
