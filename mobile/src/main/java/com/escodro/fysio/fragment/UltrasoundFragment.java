package com.escodro.fysio.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.TextView;

import com.escodro.fysio.R;
import com.escodro.fysio.presenter.CalculatorPresenter;
import com.escodro.fysio.presenter.UltrasoundPresenter;
import com.escodro.fysio.view.CalculatorView;
import com.escodro.fysio.widget.DecimalEditText;

import java.text.MessageFormat;

/**
 * {@link Fragment} responsible to handle the view part of the Ultrasound formula.
 * <p/>
 * Created by IgorEscodro on 18/12/15.
 */
public class UltrasoundFragment extends Fragment implements CalculatorView,
        View.OnClickListener, TextView.OnEditorActionListener {

    /**
     * {@link CalculatorPresenter} reference.
     */
    private CalculatorPresenter mPresenter;

    /**
     * {@link DecimalEditText} containing the width value.
     */
    private DecimalEditText mWidthEdit;

    /**
     * {@link DecimalEditText} containing the length value.
     */
    private DecimalEditText mLengthEdit;

    /**
     * {@link DecimalEditText} containing the ERA radius value.
     */
    private DecimalEditText mEraEdit;

    /**
     * {@link TextView} to show the result.
     */
    private TextView mResultText;

    /**
     * Creates and returns new instance of {@link UltrasoundFragment}.
     *
     * @return new instance of {@link UltrasoundFragment}
     */
    public static UltrasoundFragment newInstance() {
        return new UltrasoundFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ultrasound, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initComponents(view);
    }

    /**
     * Initialize all view components.
     */
    private void initComponents(View view) {
        mPresenter = new UltrasoundPresenter(this);
        mWidthEdit = (DecimalEditText) view.findViewById(R.id.edt_width);
        mLengthEdit = (DecimalEditText) view.findViewById(R.id.edt_length);
        mEraEdit = (DecimalEditText) view.findViewById(R.id.edt_era);
        mResultText = (TextView) view.findViewById(R.id.txt_result);
        final Button calculateButton = (Button) view.findViewById(R.id.btn_calculate);

        mEraEdit.setOnEditorActionListener(this);
        calculateButton.setOnClickListener(this);
    }

    /**
     * Calls the {@link CalculatorPresenter} to calculate the recommended time of application of
     * ultrasound based on the given values.
     */
    private void calculate() {
        mPresenter.onCalculate(mWidthEdit.getValue(), mLengthEdit.getValue(),
                mEraEdit.getValue());
    }

    /**
     * Verify if all the fields are correctly filled.
     *
     * @return <b>true</b> if all fields are correctly filled, <b>false</b> otherwise.
     */
    private boolean verifyFields() {
        return !mWidthEdit.isEmpty() && !mLengthEdit.isEmpty() && !mEraEdit.isEmpty();
    }

    @Override
    public void showResult(float result) {
        final String time = String.format("%.2f", result);
        final String text = getString(R.string.calculator_button_result);
        final String message = MessageFormat.format(text, time);
        mResultText.setText(String.valueOf(message));
    }

    @Override
    public void cleanFields() {
        mWidthEdit.setText("");
        mLengthEdit.setText("");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_calculate:
                if (verifyFields()) {
                    calculate();
                }
                break;
        }
    }

    @Override
    public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
        boolean result = false;
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            calculate();
            result = true;
        }
        return result;
    }
}
