package com.droibit.facedetection.entity;

import java.io.Serializable;

/**
 * @author kumagai
 */
public class Cosplayer implements Serializable {

    public final String name;
    public final String option;
    public final String url;
    public final License license;

    public Cosplayer(String name, String option, String url, License license) {
        this.name = name;
        this.option = option;
        this.url = url;
        this.license = license;
    }
}
