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
    Button submit;
    Integer[] numBtn = {R.id.num1,R.id.num2,R.id.num3,R.id.num4,R.id.num5,R.id.num6,R.id.num7,R.id.num8,R.id.num9,R.id.num10, R.id.num11, R.id.num12}; // 숫자 버튼
    Button[] numButtons = new Button[12];
    String num1;
    String num2; // 클릭되어진 숫자.
    TextView resultText;
    Integer[] res = {R.id.first, R.id.second};
    TextView[] resNum = new TextView[2];
    TextView important;
    EditText edit1, edit2;
    String  res1Input, res2Input; // 실제 결과값이 들어갈 부분.
    int watchResult;
    int i, j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("숫자 맞추기 게임");

        // 1. +, -, *, - 을 지정해주기.
        btnAdd = (Button)findViewById(R.id.plus);
        btnSub = (Button)findViewById(R.id.minus);
        btnMul = (Button)findViewById(R.id.multiply);
        btnDiv = (Button)findViewById(R.id.division);
        resultText = (TextView)findViewById(R.id.result);
        // 숫자 버튼들을 지정, 숫자 버튼들을 눌렀을 때 resNum1, resNum2에 누른 버튼 값으로 변경시켜주기.
        // 손보기..
        for (i = 0; i <numBtn.length; i++) {
            numButtons[i] = (Button) findViewById(numBtn[i]);
        }
        for (i = 0; i <numBtn.length; i++) {
            final int index; //꼭 필요함
            index = i;
            for(j = 0; j < res.length; j++){
                resNum[j] = (TextView) findViewById(res[j]);
            }
            numButtons[index].setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    for(j = 0; j < res.length; j++){
                        final int index2;
                        resNum[0].setText(numButtons[index].getText().toString());
                        numButtons[index].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                resNum[1].setText(numButtons[index].getText().toString());
                            }
                        });
                    }
                }
            });
        }

        // 숫자 입력 후 덧셈을 눌렀을 때
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res1Input = resNum[0].getText().toString();
                res2Input = resNum[1].getText().toString();
                watchResult = Integer.parseInt(res1Input) + Integer.parseInt(res2Input);
                resultText.setText(String.valueOf(watchResult));
            }
        });
        // 숫자 입력 후 뺄셈을 눌렀을 때
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res1Input = resNum[0].getText().toString();
                res2Input = resNum[1].getText().toString();
                watchResult = Integer.parseInt(res1Input) - Integer.parseInt(res2Input);
                resultText.setText(String.valueOf(watchResult));
            }
        });
        // 숫자 입력 후 곱셈을 눌렀을 때
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res1Input = resNum[0].getText().toString();
                res2Input = resNum[1].getText().toString();
                watchResult = Integer.parseInt(res1Input) * Integer.parseInt(res2Input);
                resultText.setText(String.valueOf(watchResult));
            }
        });
        // 숫자 입력 후 나눗셈을 눌렀을 때
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res1Input = resNum[0].getText().toString();
                res2Input = resNum[1].getText().toString();
                watchResult = Integer.parseInt(res1Input) / Integer.parseInt(res2Input);
                resultText.setText(String.valueOf(watchResult));
            }
        });
        // 랜덤 값 가져와서 result에 지정하기.
        int random = (int) (Math.random() * 20) + 1; // 1 ~ 20까지의 랜덤 값 지정.
        important = (TextView)findViewById(R.id.important);
        important.setText(String.valueOf(random));

        submit = (Button) findViewById(R.id.submit);
        // 제출을 클릭했을 때 문제랑 결과같 같으면 true, 다르면 false 출력 (임시로 Toast 출력)
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // String 으로 지정.
//                res1Input = resNum[0].getText().toString();
//                res2Input = resNum[1].getText().toString();
//                watchResult = Integer.parseInt(res1Input) * Integer.parseInt(res2Input);
                String resultInt = resultText.getText().toString();
                String importantInt = important.getText().toString();
                if(Integer.parseInt(resultInt) == Integer.parseInt(importantInt)){
                    Toast.makeText(getApplicationContext(), "성공입니다!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "실패입니다..", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}