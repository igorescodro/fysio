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
 * Created by IgorEscodro on 18/12/15.
 */
public class UltrasoundFragment extends Fragment implements CalculatorView,
        View.OnClickListener, TextView.OnEditorActionListener {

    private CalculatorPresenter mPresenter;

    private DecimalEditText mWidthEdit;

    private DecimalEditText mLengthEdit;

    private DecimalEditText mEraEdit;

    private TextView mResultText;

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

    private void calculate() {
        mPresenter.onCalculate(mWidthEdit.getValue(), mLengthEdit.getValue(),
                mEraEdit.getValue());
    }

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
