package com.escodro.fysio.widget;

import android.content.Context;
import android.text.InputType;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Custom {@link EditText} which only accepts decimal numbers.
 * <p/>
 * Created by IgorEscodro on 22/11/15.
 */
public class DecimalEditText extends EditText {

    /**
     * Default constructor.
     *
     * @param context {@link Context} reference.
     */
    public DecimalEditText(Context context) {
        super(context);
        init();
    }

    /**
     * Default constructor.
     *
     * @param context {@link Context} reference
     * @param attrs   {@link AttributeSet} reference
     */
    public DecimalEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * Default constructor.
     *
     * @param context      {@link Context} reference
     * @param attrs        {@link AttributeSet} reference
     * @param defStyleAttr current theme reference
     */
    public DecimalEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * Initialize the view with custom parameters.
     */
    private void init() {
        setInputType(InputType.TYPE_CLASS_NUMBER
                | InputType.TYPE_NUMBER_FLAG_DECIMAL);
    }

    /**
     * Gets the value from the {@link DecimalEditText}.
     *
     * @return get the value in float format
     */
    public Float getValue() {
        float value = 0;
        try {
            value = Float.parseFloat(getText().toString());
        } catch (NumberFormatException e) {
            //Do nothing.
        }
        return value;
    }

    /**
     * Verfies if the {@link DecimalEditText} is empty.
     *
     * @return <b>true</b> if it is empty, <b>false</b> otherwise
     */
    public boolean isEmpty() {
        return getText().toString().trim().length() == 0;
    }
}
