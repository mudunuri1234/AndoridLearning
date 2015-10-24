package com.example.androidlearning.eventbus;

/**
 * Created by Srinivas
 */
public class FragmentDataEvent {

    private String value;

    public FragmentDataEvent(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
