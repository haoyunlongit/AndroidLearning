package com.hyl.activity;

import java.io.Serializable;

public class User implements Serializable {
    public int Id;
    public String name;

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
