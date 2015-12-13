package com.escodro.fysio.presenter;

import com.escodro.fysio.interactor.CalculatorInteractor;
import com.escodro.fysio.interactor.UltrasoundInteractor;
import com.escodro.fysio.view.CalculatorView;

/**
 * Created by IgorEscodro on 15/11/15.
 */
public class UltrasoundPresenter implements CalculatorPresenter {

    private CalculatorView mCalculatorView;

    private CalculatorInteractor mInteractor;

    public UltrasoundPresenter(CalculatorView view) {
        mCalculatorView = view;
        mInteractor = new UltrasoundInteractor();
    }

    @Override
    public void onCalculate(float width, float length, float era) {
        final float result = mInteractor.calculate(width, length, era);
        mCalculatorView.cleanFields();
        mCalculatorView.showResult(result);
    }
}
