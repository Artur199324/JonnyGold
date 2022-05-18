package com.game.colorroll.modJg;

import android.app.Activity;
import android.content.Context;


public class SaveJg {

    int saveNumberJg = 0;
    Activity gameActivityJg;
    String saveRecJG;
    String saveJg;

    public Activity getGameActivityJg() {
        return gameActivityJg;
    }

    public void setGameActivityJg(Activity gameActivityJg) {
        this.gameActivityJg = gameActivityJg;

    }

    public String getSaveJg() {
        saveJg = gameActivityJg.getSharedPreferences(getGameActivityJg().getPackageName(), Context.MODE_PRIVATE).getString("ssss","ggg");
        return saveJg;
    }

    public void setSaveJg(String saveJg) {
        this.saveJg = saveJg;
        gameActivityJg.getSharedPreferences(getGameActivityJg().getPackageName(), Context.MODE_PRIVATE).edit().putString("ssss", saveJg).apply();
    }

    public int getSaveNumberJg() {
        saveNumberJg = gameActivityJg.getSharedPreferences(getGameActivityJg().getPackageName(), Context.MODE_PRIVATE).getInt("num", 2);
        return saveNumberJg;
    }

    public void setSaveNumberJg(int saveNumberJg) {
        this.saveNumberJg = saveNumberJg;
        gameActivityJg.getSharedPreferences(getGameActivityJg().getPackageName(), Context.MODE_PRIVATE).edit().putInt("num", saveNumberJg).apply();

    }

    public String getSaveRecJG() {
        saveRecJG = gameActivityJg.getSharedPreferences(getGameActivityJg().getPackageName(), Context.MODE_PRIVATE).getString("rec","0");
        return saveRecJG;
    }

    public void setSaveRecJG(String saveRecJG) {
        this.saveRecJG = saveRecJG;
        gameActivityJg.getSharedPreferences(getGameActivityJg().getPackageName(), Context.MODE_PRIVATE).edit().putString("rec", saveRecJG).apply();
    }
}
