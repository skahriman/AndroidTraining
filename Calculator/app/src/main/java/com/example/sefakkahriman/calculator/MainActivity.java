package com.example.sefakkahriman.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textview;
    private Operator operator;
    private double doubleNumber;
    private double result;
    private boolean getResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = findViewById(R.id.textView);
    }

    public void cClick(View view) {
        textview.setText("");
    }

    public enum Operator {
        ADDITION, SUBTRACTION, DIVISION, MULTIPLICATION
    }



    public Operator getOperatorType(View view){
        Button btn = (Button)view;
        String str = btn.getText().toString();

        switch (str) {
            case "+":
                return Operator.ADDITION;
            case "-":
                return Operator.SUBTRACTION;
            case "x":
                return Operator.MULTIPLICATION;
            case "%":
                return Operator.DIVISION;
            default:
                return null;
        }
    }

    public void clickOnOperator(View view){
        if(getResult)
            textview.setText("0");
        operator = getOperatorType(view);
        doubleNumber = Double.parseDouble(textview.getText().toString());
        textview.setText("");
    }

    //
    public void clickOnNumber(View view) {
        Button btn = (Button)view;
        if(getResult) {
            cClick(view);
            getResult = false;
        }

        if(textview.getText().toString().equals(""))
            textview.setText(btn.getText().toString());
        else
            textview.setText(textview.getText().toString() + btn.getText().toString());

    }

    public void clickOnEquals(View view) {
        if(!(textview.getText().toString().equals(""))){
            Double nextNumber = Double.parseDouble(textview.getText().toString());
            switch (operator) {
                case ADDITION:
                    result = doubleNumber + nextNumber;
                    break;
                case SUBTRACTION:
                    result = doubleNumber - nextNumber;
                    break;
                case MULTIPLICATION:
                    result = doubleNumber * nextNumber;
                    break;
                case DIVISION:
                    result = doubleNumber / nextNumber;
                    break;
                default:
                    System.out.println("error");

            }
            textview.setText(Double.toString(result));
            doubleNumber = result;
            getResult = true;
        }
    }

}









