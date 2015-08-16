package com.droibit.facedetection.entity;

/**
 * @auther kumagai
 */
public enum License {
    BY_2_1("http://creativecommons.org/licenses/by/2.1/jp/"),
    BY_ND_2_1("http://creativecommons.org/licenses/by-nd/2.1/jp/"),
    BY_ND_3_0("http://creativecommons.org/licenses/by-nd/3.0/deed.ja"),
    BY_SA_2_1("http://creativecommons.org/licenses/by-sa/2.1/jp/");


    License(String url) {
        this.url = url;
    }
    public final String url;
}
