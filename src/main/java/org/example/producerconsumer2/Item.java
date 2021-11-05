package org.example.producerconsumer2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Item {

    private int data;

    public void process() {
        System.out.println("Processing data: " + data);
    }
}
