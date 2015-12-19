package com.escodro.fysio.interactor;

/**
 * Interactor responsible to calculate the recommended time of application of therapeutic ultrasound
 * in the patient.
 *
 * @see <a href="http://www.inmetro.gov.br/painelsetorial/palestras/PalestraFabioBorges.pdf">
 * Inmetro - Aspectos Gerais do Despreparo de Fisioterapeutas para o Manuseio do Ultra-Som
 * Terapêutico (In Portuguese)</a>
 * <p/>
 * Created by IgorEscodro on 15/11/15.
 */
public class UltrasoundInteractor implements CalculatorInteractor {

    /**
     * Constant to represent the maximum time that the therapeutic ultrasound can be applied in the
     * patient.
     */
    private static final int MAX_TIME = 15;

    /**
     * {@inheritDoc}
     * <p/>
     * <b>Override</b><br> The formula is: the patient area to be applied (width * length) divided
     * by the ERA diameter size. <br>Applied to Inmetro rules, there are other rules to the
     * calculation:<br> <ul> <li>The maximum time can not be greater than {@link
     * UltrasoundInteractor#MAX_TIME} minutes .</li> <li>The recommended time can not be less than
     * ERA diameter size.</li> <li>If the value has decimal numbers, it is always rounded to the
     * nearest whole number.</li></ul>
     */
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
