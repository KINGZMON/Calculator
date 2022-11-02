package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);
    }

    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display.setSelection(cursorPos+1);
    }

    //------------Numbers onClick--------------//
    public void zeroBTN(View view){
        updateText("0");
    }

    public void oneBTN(View view){
        updateText("1");
    }

    public void twoBTN(View view){
        updateText("2");
    }

    public void threeBTN(View view){
        updateText("3");
    }

    public void fourBTN(View view){
        updateText("4");
    }

    public void fiveBTN(View view){
        updateText("5");
    }

    public void sixBTN(View view){
        updateText("6");
    }

    public void sevenBTN(View view){
        updateText("7");
    }

    public void eightBTN(View view){
        updateText("8");
    }

    public void nineBTN(View view){
        updateText("9");
    }
    //------------Numbers onClick end--------------//


    //------------Other Buttons--------------//
    public void backspaceBTN(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if(cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }
    }

    public void expBTN(View view){
        updateText("^(");
        int cursorPos = display.getSelectionStart();
        display.setSelection(cursorPos+1);
    }

    public void clearBTN(View view){
        display.setText("");
    }

    public void bracketStartBTN(View view){
        updateText("(");
    }

    public void bracketEndBTN(View view){
        updateText(")");
    }

    public void divideBTN(View view){
        updateText("÷");
    }

    public void modulusBTN(View view){
        updateText("Mod");
        int cursorPos = display.getSelectionStart();
        display.setSelection(cursorPos+2);
    }

    public void multiplyBTN(View view){
        updateText("×");
    }

    public void sqrRootBTN(View view){
        updateText("√");
    }

    public void minusBTN(View view){
        updateText("-");
    }

    public void addBTN(View view){
        updateText("+");
    }

    public void plusMinusBTN(View view){
        updateText("(-");
        int cursorPos = display.getSelectionStart();
        display.setSelection(cursorPos+1);

    }

    public void decimalBTN(View view){
        updateText(".");
    }

    public void equalsBTN(View view){
        String userExp = display.getText().toString();

        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("×", "*");
        userExp = userExp.replaceAll("Mod", "#");

        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }
    //------------Other Buttons End--------------//

}