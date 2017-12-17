package com.example.mary.smartbutler.entity;

/**
 * 项目名:    SmartButler
 * 包名：     com.example.mary.smartbutler.entity
 * 创建者：   Mary
 * 创建时间:  2017/12/16 22:01
 * 描述：     微信精选的实体类
 */

public class WeChatData {

    //标题
    private  String title;
    //出处
    private String source;
    //图片的url
    private String imgUrl;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String soutce) {
        this.source = soutce;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}
