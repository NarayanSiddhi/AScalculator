package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText txtValue;
    String operatorValue;
    Boolean isNewOperation = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtValue = (EditText) findViewById(R.id.calc);
        txtValue.setShowSoftInputOnFocus(false);
        txtValue.setSingleLine(false);
    }

    public void numberClick(View view) {
        if (isNewOperation) {
            isNewOperation = false;
            txtValue.setText("");
        }
        String value = txtValue.getText().toString();

        if (view.getId() == R.id.numzero) {
            value += 0;
        }else if (view.getId() == R.id.numdoublezero) {
            value += 0;
            value += 0;
        } else if (view.getId() == R.id.numone) {
            value += 1;
        } else if (view.getId() == R.id.numtwo) {
            value += 2;
        } else if (view.getId() == R.id.numthree) {
            value += 3;
        } else if (view.getId() == R.id.numfour) {
            value += 4;
        } else if (view.getId() == R.id.numfive) {
            value += 5;
        } else if (view.getId() == R.id.numsix) {
            value += 6;
        } else if (view.getId() == R.id.numseven) {
            value += 7;
        } else if (view.getId() == R.id.numeight) {
            value += 8;
        } else if (view.getId() == R.id.numnine) {
            value += 9;
        } else if (view.getId() == R.id.dot) {
            value += ".";
        }
        txtValue.setText(value);
    }

    public void operatorClick(View view) {
        String value = txtValue.getText().toString();
        if (view.getId() == R.id.add) {
            operatorValue = "+";
            value += "+";
        } else if (view.getId() == R.id.minus) {
            operatorValue = "-";
            value += "-";
        } else if (view.getId() == R.id.multiply) {
            operatorValue = "*";
            value += "*";
        } else if (view.getId() == R.id.Divide) {
            operatorValue = "/";
            value += "/";
        } else if (view.getId() == R.id.DivByhundred) {
            operatorValue = "%";
            value += "%";
        }
        txtValue.setText(value);
    }

    public void clearButton(View view) {
        txtValue.setText("");
    }

    public void equalsClick(View view) {
        String value = txtValue.getText().toString();
        Double calculatedValue = 0.0;
        String[] separated;
        switch (operatorValue) {
            case "+":
                separated = value.split("\\+");
                calculatedValue = Double.parseDouble(separated[0]) + Double.parseDouble(separated[1]);
                break;

            case "-":
                separated = value.split("-");
                calculatedValue = Double.parseDouble(separated[0]) - Double.parseDouble(separated[1]);
                break;

            case "*":
                separated = value.split("\\*");
                calculatedValue = Double.parseDouble(separated[0]) * Double.parseDouble(separated[1]);
                break;

            case "/":
                separated = value.split("/");
                calculatedValue = Double.parseDouble(separated[0]) / Double.parseDouble(separated[1]);
                break;

            case "%":
                separated = value.split("%");
                calculatedValue = Double.parseDouble(separated[0]) / 100;
                break;
        }

        String finalValue = String.format("%.2f", calculatedValue);

        txtValue.setText(value + "\n" + finalValue);

        if((calculatedValue %1)==0){}
        else txtValue.setText(value +"\n"+ finalValue);

        isNewOperation = true;
    }
}