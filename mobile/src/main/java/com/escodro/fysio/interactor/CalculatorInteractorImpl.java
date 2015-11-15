package com.escodro.fysio.interactor;

/**
 * Created by IgorEscodro on 15/11/15.
 */
public class CalculatorInteractorImpl implements CalculatorInteractor {

    @Override
    public float calculate(float width, float length, float era) {
        final float area = width * length;
        float result = area / era;
        return result > 15 ? 15 : result;
    }
}
