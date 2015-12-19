package com.escodro.fysio.view;

/**
 * Interface to be implemented to handle all the visual operations done by the presenter. It
 * contains all methods related to the calculation flow.
 * <p/>
 * Created by IgorEscodro on 14/11/15.
 */
public interface CalculatorView {

    /**
     * Method to update the result in the component.
     *
     * @param result calculation result to be set in the component
     */
    void showResult(float result);

    /**
     * Method to clean the field used in the previous calculation.
     */
    void cleanFields();
}
