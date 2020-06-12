package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView input;
    private TextView output;

    private Button btn_0;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;

    private Button btn_C;
    private Button btn_add;
    private Button btn_sub;
    private Button btn_div;
    private Button btn_equal;
    private Button btn_dot;
    private Button btn_delete;
    private Button btn_mul;

    private static Context context;

    public static Context getContext() {
        return MainActivity.context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.context = getApplicationContext();
        setContentView(R.layout.activity_main);
        initWidget();
    }


    public void initWidget() {
        btn_0=(Button) findViewById(R.id.btn_0);
        btn_1=(Button) findViewById(R.id.btn_1);
        btn_2=(Button) findViewById(R.id.btn_2);
        btn_3=(Button) findViewById(R.id.btn_3);
        btn_4=(Button) findViewById(R.id.btn_4);
        btn_5=(Button) findViewById(R.id.btn_5);
        btn_6=(Button) findViewById(R.id.btn_6);
        btn_7=(Button) findViewById(R.id.btn_7);
        btn_8=(Button) findViewById(R.id.btn_8);
        btn_9 =(Button) findViewById(R.id.btn_9);

        btn_C=(Button) findViewById(R.id.btn_C);
        btn_add=(Button) findViewById(R.id.btn_add);
        btn_sub=(Button) findViewById(R.id.btn_sub);
        btn_delete=(Button) findViewById(R.id.btn_delete);
        btn_dot=(Button) findViewById(R.id.btn_dot);
        btn_div=(Button) findViewById(R.id.btn_div);
        btn_equal=(Button) findViewById(R.id.btn_equal);
        btn_mul = (Button) findViewById(R.id.btn_mul);

        input = (TextView) findViewById(R.id.input);
        output = (TextView) findViewById(R.id.output);


        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);

        btn_C.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_0:
                input.setText(input.getText() + "0");
                break;
            case R.id.btn_1:
                input.setText(input.getText() + "1");
                break;
            case R.id.btn_2:
                input.setText(input.getText() + "2");
                break;
            case R.id.btn_3:
                input.setText(input.getText() + "3");
                break;
            case R.id.btn_4:
                input.setText(input.getText() + "4");
                break;
            case R.id.btn_5:
                input.setText(input.getText() + "5");
                break;
            case R.id.btn_6:
                input.setText(input.getText() + "6");
                break;
            case R.id.btn_7:
                input.setText(input.getText() + "7");
                break;
            case R.id.btn_8:
                input.setText(input.getText() + "8");
                break;
            case R.id.btn_9:
                input.setText(input.getText() + "9");
                break;

            case R.id.btn_C:
                input.setText("");
                output.setText("");
                break;
            case R.id.btn_sub:
                input.setText(input.getText() + "-");
                break;
            case R.id.btn_add:
                input.setText(input.getText() + "+");
                break;
            case R.id.btn_mul:
                input.setText(input.getText() + "x");
                break;
            case R.id.btn_div:
                input.setText(input.getText() + ":");
                break;
            case R.id.btn_dot:
                input.setText(input.getText() + ".");
                break;
            case R.id.btn_delete:
                String s = input.getText().toString();
                int len = s.length();
                s = s.substring(0, len-1);

                input.setText(s);
                break;
            case R.id.btn_equal:
                //process();
                //EvaluateString evaluateString = new EvaluateString();
                double res = EvaluateString.evaluate(input.getText().toString());
                if ((res == Math.floor(res)) && !Double.isInfinite(res)) {
                    // integer type
                    int res_int = (int)res;
                    output.setText(String.valueOf(res_int));
                }
                else {
                    output.setText(String.valueOf(res));
                }
                break;
            default: // = sign
                //process();
        }
    }

}