package com.ssarori.mbti_tmi;

public class itemData {
    private int imgID;
    private String title;

    public itemData(int imgID, String title) {
        this.imgID = imgID;
        this.title = title;
    }

    public int getImgID() {
        return imgID;
    }

    public String getTitle() {
        return title;
    }
}
