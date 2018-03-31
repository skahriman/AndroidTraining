package com.example.sefakkahriman.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textview;
    private Operator operator;
    private double doubleNumber;
    private int number1;
    private int number2;
    private String operandType;
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
        if(getResult == false)
            textview.setText("0");
        operator = getOperatorType(view);
        doubleNumber = Double.parseDouble(textview.getText().toString());
        textview.setText("");
    }

    //
    public void clickOnNumber(View view) {
        Button btn = (Button)view;
        if(getResult == true) {
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
            Double doubleNumber2 = Double.parseDouble(textview.getText().toString());
            switch (operator) {
                case ADDITION:
                    result = doubleNumber + doubleNumber2;
                    break;
                case SUBTRACTION:
                    result = doubleNumber - doubleNumber2;
                    break;
                case MULTIPLICATION:
                    result = doubleNumber * doubleNumber2;
                    break;
                case DIVISION:
                    result = doubleNumber / doubleNumber2;
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









