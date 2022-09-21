package com.example.tree234;

public class Data {
    private final int id;
    public Data(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void dispData() {
        System.out.print("/" + this.id);
    }
}
