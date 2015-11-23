package com.escodro.fysio.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.escodro.fysio.R;
import com.escodro.fysio.presenter.CalculatorPresenter;
import com.escodro.fysio.presenter.CalculatorPresenterImpl;
import com.escodro.fysio.view.CalculatorView;
import com.escodro.fysio.widget.DecimalEditText;

import java.text.MessageFormat;

/**
 * Created by IgorEscodro on 14/11/15.
 */
public class CalculatorActivity extends AppCompatActivity implements CalculatorView,
        View.OnClickListener {

    private CalculatorPresenter mPresenter;

    private DecimalEditText mWidthEdit;

    private DecimalEditText mLengthEdit;

    private DecimalEditText mEraEdit;

    private TextView mResultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_ultrasound);
        mPresenter = new CalculatorPresenterImpl(this);
        initComponents();
    }

    private void initComponents() {
        mWidthEdit = (DecimalEditText) findViewById(R.id.edt_width);
        mLengthEdit = (DecimalEditText) findViewById(R.id.edt_length);
        mEraEdit = (DecimalEditText) findViewById(R.id.edt_era);
        mResultText = (TextView) findViewById(R.id.txt_result);

        final Button calculateButton = (Button) findViewById(R.id.btn_calculate);
        calculateButton.setOnClickListener(this);
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
                    mPresenter.onCalculate(mWidthEdit.getValue(), mLengthEdit.getValue(),
                            mEraEdit.getValue());
                }
                break;
        }
    }
}
