package com.example.meterstoinches;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView result;
    private EditText text;
    private EditText rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        result = (TextView) findViewById(R.id.result);
    //    result.setTextColor(Color.WHITE);
        text = (EditText) findViewById(R.id.editText);
  //      text.setTextColor(Color.WHITE);
//        rate.setTextColor(Color.WHITE);
        rate = (EditText) findViewById(R.id.rate);
        button.setText(R.string.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view){
                calculate(view);
            }
        });
    }

    public void calculate(View view){
        String enteredText;
        enteredText = text.getText().toString();
        if(enteredText.isEmpty()){
            result.setText(R.string.error_message);
            result.setTextColor(Color.RED);
            result.setTextSize(16);
        }else {
            result.setTextColor(Color.WHITE);
            double yuan = Double.parseDouble(enteredText) * Double.parseDouble(rate.getText().toString());
            enteredText = Double.toString(yuan);
            result.setText(enteredText);
            result.setTextSize(36);
            result.setVisibility(View.VISIBLE);
            //button.setVisibility(View.INVISIBLE);
            rate.setText("");
            text.setText("");
        }
    }
}