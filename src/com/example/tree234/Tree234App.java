package com.example.tree234;

import com.example.tree234.bootstrap.Tree234Bootstrap;

public class Tree234App {
    public static void main(String[] args) {
        Tree234 tree234 = new Tree234();

        Tree234Bootstrap bootstrap = new Tree234Bootstrap(tree234);

        bootstrap.insert10Elements();

        tree234.display(DisplayFormats.ORDER);
    }
}

