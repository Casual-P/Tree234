package com.example.tree234.bootstrap;

import com.example.tree234.Data;
import com.example.tree234.Tree234;

public class Tree234Bootstrap {

    private final Tree234 tree234;

    public Tree234Bootstrap(Tree234 tree234) {
        this.tree234 = tree234;
    }

    public void insert10Elements() {
        tree234.insert(new Data(50));
        tree234.insert(new Data(100));
        tree234.insert(new Data(150));
        tree234.insert(new Data(15));
        tree234.insert(new Data(30));
        tree234.insert(new Data(60));
        tree234.insert(new Data(40));
        tree234.insert(new Data(10));
        tree234.insert(new Data(5));
    }
}
