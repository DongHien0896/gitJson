package com.example.dong.apigit;

import java.io.Serializable;

public class DataOfGit implements Serializable {

    private String mName;
    private String mFullName;
    private String mUrl;

    public DataOfGit() {
    }

    public DataOfGit(String name, String fullName, String url) {
        this.mName = name;
        this.mFullName = fullName;
        this.mUrl = url;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        this.mFullName = fullName;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        this.mUrl = url;
    }

}
