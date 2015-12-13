package com.escodro.fysio.interactor;

/**
 * Created by IgorEscodro on 15/11/15.
 */
public class UltrasoundInteractor implements CalculatorInteractor {

    private static final int MAX_TIME = 15;

    @Override
    public float calculate(float width, float length, float era) {
        final float area = width * length;
        float result = (float) Math.ceil(area / era);
        if (result < era) {
            result = era;
        }
        if (result > MAX_TIME) {
            result = MAX_TIME;
        }
        return result;
    }
}
