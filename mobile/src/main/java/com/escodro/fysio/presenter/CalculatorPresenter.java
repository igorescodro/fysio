package com.escodro.fysio.presenter;

/**
 * Presenter responsible to handle the interaction between the <i>view</i> and the
 * <i>interactor</i>.
 * <p/>
 * Created by IgorEscodro on 14/11/15.
 */
public interface CalculatorPresenter {

    /**
     * Method to get the result value from the <i>interactor</i> and set in the <i>view</i>.
     *
     * @param width  patient width size.
     * @param length patient length size.
     * @param era    ERA diameter
     */
    void onCalculate(float width, float length, float era);
}
