package com.smaplerecyclerviewapp;

import java.io.Serializable;

/**
 * Created by user on 18/12/17.
 */

class DataModel implements Serializable {
    public String name;
    public String description;
    public boolean isClick;

    public DataModel(String name, String description, boolean isClick) {
        this.name = name;
        this.description = description;
        this.isClick = isClick;
    }
}
