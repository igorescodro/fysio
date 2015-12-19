package com.escodro.fysio.presenter;

import com.escodro.fysio.fragment.UltrasoundFragment;
import com.escodro.fysio.interactor.CalculatorInteractor;
import com.escodro.fysio.interactor.UltrasoundInteractor;
import com.escodro.fysio.view.CalculatorView;

/**
 * Presenter responsible to handle the interaction between the <i>view</i> ({@link
 * UltrasoundFragment}) and the <i>interactor</i> ({@link UltrasoundInteractor}).
 * <p/>
 * Created by IgorEscodro on 15/11/15.
 */
public class UltrasoundPresenter implements CalculatorPresenter {

    /**
     * {@link CalculatorView} reference.
     */
    private CalculatorView mCalculatorView;

    /**
     * {@link CalculatorInteractor} reference.
     */
    private CalculatorInteractor mInteractor;

    /**
     * Creates a new instance of {@link UltrasoundPresenter}.
     *
     * @param view {@link CalculatorView} reference
     */
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
