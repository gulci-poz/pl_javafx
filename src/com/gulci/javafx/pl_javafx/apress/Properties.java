package com.gulci.javafx.pl_javafx.apress;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Properties {
    public static void main(String[] args) {
        IntegerProperty counter  = new SimpleIntegerProperty(1);
        System.out.println("Counter: " + counter.get());

        counter.set(2);
        System.out.println("Counter: " + counter.get());
    }
}
