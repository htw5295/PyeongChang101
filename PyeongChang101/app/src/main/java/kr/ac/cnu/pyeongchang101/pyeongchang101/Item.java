package kr.ac.cnu.pyeongchang101.pyeongchang101;

/**
 * Created by HwangTaeWook on 2017-08-24.
 */

public class Item {
    String name;
    int gender;
    int check;
    int stamina;
    int strength;
    int speed;
    int mental;

    public Item(String name, int gender, int check, int stamina, int strength, int speed, int mental) {
        this.name = name;
        this.gender = gender;
        this.check = check;
        this.stamina = stamina;
        this.strength = strength;
        this.speed = speed;
        this.mental = mental;
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

    public int getStamina() {
        return stamina;
    }

    public int getStrength() {
        return strength;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMental() {
        return mental;
    }
}
