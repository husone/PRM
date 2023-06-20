package com.example.webservice;

import com.google.gson.annotations.SerializedName;

class Results {
    @SerializedName("name")
    private String superName;

    public Results(String name) {
        this.superName = name;
    }

    public String getName() {
        return superName;
    }
}