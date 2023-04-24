package com.example.dreamcatch.factory;

import java.util.Date;
import java.util.List;

public class Results {

    int value;
    String data;

    public Results(int value, String data) {
        this.value = value;
        this.data = data;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
