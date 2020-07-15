package com.hyl.serializablelearning;

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

    private void writeObject(java.io.ObjectOutputStream out) {

    }

}
