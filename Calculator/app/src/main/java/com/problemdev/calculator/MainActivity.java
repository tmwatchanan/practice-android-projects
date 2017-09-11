package com.problemdev.calculator;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText1;
    EditText editText2;
    TextView tvResult;
    Button btnCalculate;
    RadioGroup rgOperation;
    RadioButton rbSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v == btnCalculate) {
            int value1 = 0;
            int value2 = 0;
            int result = 0;

            try {
                value1 = Integer.parseInt(editText1.getText().toString());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            try {
                value2 = Integer.parseInt(editText2.getText().toString());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            rgOperation = (RadioGroup) findViewById(R.id.rgOperation);
            switch (rgOperation.getCheckedRadioButtonId()) {
                case R.id.rbPlus:
                    result = value1 + value2;
                    break;
                case R.id.rbMinus:
                    result = value1 - value2;
                    break;
                case R.id.rbMultiply:
                    result = value1 * value2;
                    break;
                case R.id.rbDivide:
                    result = value1 / value2;
                    break;
            }
            tvResult.setText(String.valueOf(result));
        }
    }
}
}
