package com.example.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
public class MainActivity extends AppCompatActivity {

    Button btMainActivityHasil;
    ConstraintLayout trMainActivityFirstRow;
    ConstraintLayout trMainActivitySecondRow;
    ConstraintLayout trMainActivityThirdRow;
    TextView tvMainActivityHasil;
    float result;
    String numberToDisplay = "";
    String lastOperation = "";
    String lastNumber = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initComponent();
        initListener();
        reset();
    }
    void initComponent(){
        btMainActivityHasil = findViewById(R.id.btMainActivityHasil);
        trMainActivityFirstRow = findViewById(R.id.trMainActivityFirstRow);
        trMainActivitySecondRow = findViewById(R.id.trMainActivitySecondRow);
        trMainActivityThirdRow = findViewById(R.id.trMainActivityThirdRow);
        tvMainActivityHasil = findViewById(R.id.tvMainActivityHasil);
    }
    void initListener(){
        for (int i = 0; i < trMainActivityFirstRow.getChildCount(); i++) {
            Button btn = (Button) trMainActivityFirstRow.getChildAt(i);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!btn.getText().toString().equals("C")){
                        addOperation(btn.getText().toString());
                    }else{
                        reset();
                    }

                }
            });
        }
        for (int i = 0; i < trMainActivitySecondRow.getChildCount(); i++) {
            Button btn = (Button) trMainActivitySecondRow.getChildAt(i);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setNumber(btn.getText().toString());

                }
            });
        }
        for (int i = 0; i < trMainActivityThirdRow.getChildCount(); i++) {
            Button btn = (Button) trMainActivityThirdRow.getChildAt(i);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setNumber(btn.getText().toString());
                }
            });
        }
        btMainActivityHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startCalculation();
            }
        });

    }
    void reset(){
        result = 0;
        numberToDisplay = "0.0";
        lastNumber = "0";
        lastOperation = "";
        tvMainActivityHasil.setText(String.valueOf(result));
    }

    void addOperation(String operation){
        String newNumberToDisplay = numberToDisplay + operation;
//        lastOperation = operation;
//
//        switch (operation) {
//            case "+":
//                if (result == 0 || String.valueOf(result).equals(lastNumber)){
//                    result = Float.parseFloat(lastNumber);
//                }else {
//                    result = result + Float.parseFloat(lastNumber);
//                }
//                break;
//            case "-":
//                if (result == 0 || String.valueOf(result).equals(lastNumber)){
//                    result = Float.parseFloat(lastNumber);
//                }else {
//                    result = result - Float.parseFloat(lastNumber);
//                }
//                break;
//            case "x":
//                if (result == 0 || String.valueOf(result).equals(lastNumber)){
//                    result = Float.parseFloat(lastNumber);
//                }else {
//                    result = result * Float.parseFloat(lastNumber);
//                }
//                break;
//            case "/":
//                if (result == 0 || String.valueOf(result).equals(lastNumber)){
//                    result = Float.parseFloat(lastNumber);
//                }else {
//                    result = result / Float.parseFloat(lastNumber);
//                }
//                break;
//
//            default:
//
//        }

        tvMainActivityHasil.setText(newNumberToDisplay);
        numberToDisplay = newNumberToDisplay;

    }

    void setNumber(String number){
        if(numberToDisplay.equals("0.0")){
            numberToDisplay = number;
        }else{
            numberToDisplay = numberToDisplay + number;
        }
        tvMainActivityHasil.setText(numberToDisplay);

        String[] parts = numberToDisplay.split("[x+\\-/]");
        lastNumber = parts[parts.length - 1];
    }

    void startCalculation(){
//        String[] parts = numberToDisplay.split("[x+\\-/]");
//
//        switch (lastOperation) {
//            case "+":
//                if (result == 0 || String.valueOf(result).equals(lastNumber)) {
//                    result = Float.parseFloat(lastNumber);
//                } else {
//                    result = result + Float.parseFloat(lastNumber);
//                }
//                break;
//            case "-":
//                if (result == 0 || String.valueOf(result).equals(lastNumber)) {
//                    result = Float.parseFloat(lastNumber);
//                } else {
//                    result = result - Float.parseFloat(lastNumber);
//                }
//                break;
//            case "x":
//                if (result == 0 || String.valueOf(result).equals(lastNumber)) {
//                    result = Float.parseFloat(lastNumber);
//                } else {
//                    result = result * Float.parseFloat(lastNumber);
//                }
//                break;
//            case "/":
//                if (result == 0 || String.valueOf(result).equals(lastNumber)) {
//                    result = Float.parseFloat(lastNumber);
//                } else {
//                    result = result / Float.parseFloat(lastNumber);
//                }
//                break;
//
//            default:
//
//        }
//        numberToDisplay = String.valueOf(result);
//        lastNumber = numberToDisplay;
        tvMainActivityHasil.setText(String.valueOf(evaluate(numberToDisplay)));
    }
    public static double evaluate(String expression) {
        Expression expr = new ExpressionBuilder(expression).build();
        return expr.evaluate();
    }

}