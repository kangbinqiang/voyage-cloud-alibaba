package com.voyage.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GCDemo {

    public static void main(String[] args) throws InterruptedException {
        List<Object> list = new ArrayList<>();
        while (true) {
            TimeUnit.SECONDS.sleep(2);
            list.add(new Object());
        }
    }
}
