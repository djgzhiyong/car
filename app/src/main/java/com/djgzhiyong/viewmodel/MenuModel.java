package com.djgzhiyong.viewmodel;

/**
 * Created by djgzhiyong on 15/9/2.
 */
public class MenuModel {

    public int icon;

    public String title;

    public String label;

    public MenuModel(String label, String title, int icon) {
        this.label = label;
        this.title = title;
        this.icon = icon;
    }

    public MenuModel() {
    }
}
