package com.escodro.fysio.widget;

import android.content.Context;
import android.text.InputType;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by IgorEscodro on 22/11/15.
 */
public class DecimalEditText extends EditText {

    public DecimalEditText(Context context) {
        super(context);
        init();
    }

    public DecimalEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DecimalEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
    }

    public Float getValue() {
        float value = -1;
        try {
            value = Float.parseFloat(getText().toString());
        } catch (NumberFormatException e) {
            //Do nothing.
        }
        return value;
    }

    public boolean isEmpty() {
        return getText().toString().trim().length() == 0;
    }
}
