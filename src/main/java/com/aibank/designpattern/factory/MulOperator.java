package com.aibank.designpattern.factory;

public class MulOperator extends  Operator {

    @Override
    public float calc(float firstVal, float secondVal) {
        return firstVal * secondVal;
    }

}
