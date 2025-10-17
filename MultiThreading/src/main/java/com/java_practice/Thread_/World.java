package com.java_practice.Thread_;

public class World implements Runnable{

    @Override
    public void run() {
        for(; ;){
            System.out.println("world");
        }
    }
}
