package com.escodro.fysio.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.escodro.fysio.R;
import com.escodro.fysio.presenter.CalculatorPresenter;
import com.escodro.fysio.presenter.CalculatorPresenterImpl;
import com.escodro.fysio.view.CalculatorView;

import java.text.MessageFormat;

/**
 * Created by IgorEscodro on 14/11/15.
 */
public class CalculatorActivity extends AppCompatActivity implements CalculatorView,
        View.OnClickListener {

    private CalculatorPresenter mPresenter;

    private EditText mWidthEdit;

    private EditText mLengthEdit;

    private EditText mEraEdit;

    private TextView mResultText;

    private float mWidth;

    private float mLength;

    private float mEra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_main);
        mPresenter = new CalculatorPresenterImpl(this);
        initComponents();
    }

    private void initComponents() {
        mWidthEdit = (EditText) findViewById(R.id.edt_width);
        mLengthEdit = (EditText) findViewById(R.id.edt_length);
        mEraEdit = (EditText) findViewById(R.id.edt_era);
        mResultText = (TextView) findViewById(R.id.txt_result);

        final Button calculateButton = (Button) findViewById(R.id.btn_calculate);
        calculateButton.setOnClickListener(this);
    }

    private boolean verifyFields() {
        return !isEmpty(mWidthEdit) && !isEmpty(mLengthEdit) && !isEmpty(mEraEdit);
    }

    private boolean isEmpty(EditText editText) {
        return editText.getText().toString().trim().length() == 0;
    }

    private void updateValues() {
        mWidth = Float.parseFloat(mWidthEdit.getText().toString());
        mLength = Float.parseFloat(mLengthEdit.getText().toString());
        mEra = Float.parseFloat(mEraEdit.getText().toString());
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
                    updateValues();
                    mPresenter.onCalculate(mWidth, mLength, mEra);
                }
                break;
        }
    }
}
