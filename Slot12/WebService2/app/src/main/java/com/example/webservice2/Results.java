package com.example.webservice2;

import com.google.gson.annotations.SerializedName;

class Results {
    @SerializedName("title")
    private String title;

    @SerializedName("body")
    private String body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Results(String title, String body) {
        this.title = title;
        this.body = body;
    }

    @Override
    public String toString() {
        return "title: " + title + "\n" +
                "body: " + body + "\n"+
                "----------------------";
    }
}