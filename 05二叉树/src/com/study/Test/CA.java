package com.study.Test;

public class CA extends AA implements IA,IB,IC{


    @Override
    public void testC() {

    }

    public static void main(String[] args) {
        CA ca = new CA();
        ca.testA();
    }

    @Override
    void testAB() {

    }
}
