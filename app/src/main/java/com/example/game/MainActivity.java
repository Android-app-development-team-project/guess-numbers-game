package com.example.game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    ButtonClick buttonClick;
    Button btnAdd, btnSub, btnMul, btnDiv; // +, -, *, / 버튼
    Integer[] numBtn = {R.id.num1,R.id.num2,R.id.num3,R.id.num4,R.id.num5,R.id.num6,R.id.num7,R.id.num8,R.id.num9,R.id.num10,R.id.num11,R.id.num12}; // 숫자 버튼
    int num1;
    int num2; // 클릭되어진 숫자.
    TextView result;
    TextView resNum1;
    TextView resNum2; // 결과 text, 첫 번째 누른 숫자 text, 두 번째 누른 숫자 text
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("숫자 맞추기 게임");

        // 연산 기능을 해주는 로직. (+, -, *, /)

        // 1. +, -, *, - 을 지정해주기.
        resNum1 = (TextView)findViewById(R.id.first);
        resNum2 = (TextView)findViewById(R.id.second);
        btnAdd = (Button)findViewById(R.id.plus);
        btnSub = (Button)findViewById(R.id.minus);
        btnMul = (Button)findViewById(R.id.multiply);
        btnDiv = (Button)findViewById(R.id.division);

        result = (TextView)findViewById(R.id.result);

        // + 버튼을 눌렀을 때
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Integer.parseInt(resNum1.getText().toString());
                num2 = Integer.parseInt(resNum2.getText().toString());
//                result = num1 + num2;
                result.setText("계산결과 : ");
            }
        });
//        btnAdd.setOnTouchListener(new View.OnTouchListener(){
//            public boolean onTouch(View arg0, MotionEvent arg1){
//                num1 = Integer.parseInt(resNum1.getText().toString());
//                num2 = Integer.parseInt(resNum2.getText().toString());
////                result = num1 + num2;
//                result.setText("계산결과 : " + result.toString());
//                return false;
//            }
//        });

        // mainActivity에 숫자판이 나오도록 설정.
        fragmentManager = getSupportFragmentManager();
        buttonClick = new ButtonClick();

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.buttonClick, buttonClick, "btnClick");
        ft.commitAllowingStateLoss();
    }
}