package com.example.mp4_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button_clr;
    private Button button_div;
    private Button button_eq;
    private Button button_pls;
    private Button button_mul;
    private Button button_sub;
    private final char Add = '+';
    private final char Sub = '-';
    private final char Mul = '*';
    private final char Div = '/';
    private final char Eq = 0;
    private TextView Result;
    private TextView Control;
    private double val1 = Double.NaN;
    private double val2;
    private char ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIView();
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Control.setText(Control.getText().toString()+"0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Control.setText(Control.getText().toString()+"1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Control.setText(Control.getText().toString()+"2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Control.setText(Control.getText().toString()+"3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Control.setText(Control.getText().toString()+"4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Control.setText(Control.getText().toString()+"5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Control.setText(Control.getText().toString()+"6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Control.setText(Control.getText().toString()+"7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Control.setText(Control.getText().toString()+"8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Control.setText(Control.getText().toString()+"9");
            }
        });
        button_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = Sub;
                Result.setText(String.valueOf(val1) + "-");
                Control.setText(null);
            }
        });

        button_pls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = Add;
                Result.setText(String.valueOf(val1) + "+");
                Control.setText(null);
            }
        });

        button_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = Mul;
                Result.setText(String.valueOf(val1) + "*");
                Control.setText(null);
            }
        });

        button_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = Div;
                Result.setText(String.valueOf(val1) + "/");
                Control.setText(null);
            }
        });

        button_eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = Eq;
                Result.setText(Result.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                // 5 + 4 = 9
                Control.setText(null);
            }
        });

        button_clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Control.getText().length() > 0){
                    CharSequence name = Control.getText().toString();
                    Control.setText(name.subSequence(0, name.length()-1));
                }
                else{
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    Control.setText(null);
                    Result.setText(null);
                }
            }
        });

    }

    private void setupUIView(){
        button0 = (Button)findViewById(R.id.button0);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        button7 = (Button)findViewById(R.id.button7);
        button8 = (Button)findViewById(R.id.button8);
        button9 = (Button)findViewById(R.id.button9);
        button_clr = (Button)findViewById(R.id.button_clr);
        button_div = (Button)findViewById(R.id.button_div);
        button_eq = (Button)findViewById(R.id.button_eq);
        button_pls = (Button)findViewById(R.id.button_pls);
        button_mul = (Button)findViewById(R.id.button_mul);
        button_sub = (Button)findViewById(R.id.button_sub);
        Result = (TextView)findViewById(R.id.Result);
        Control = (TextView)findViewById(R.id.Control);
    }
    private void compute(){
        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(Control.getText().toString());

            switch(ACTION){
                case Add:
                    val1 = val1 + val2;
                    break;
                case Sub:
                    val1 = val1 - val2;
                    break;
                case Mul:
                    val1 = val1 * val2;
                    break;
                case Div:
                    val1 = val1 / val2;
                    break;
                case Eq:
                    break;
            }
        }
        else{
            val1 = Double.parseDouble(Control.getText().toString());
        }
    }
}
