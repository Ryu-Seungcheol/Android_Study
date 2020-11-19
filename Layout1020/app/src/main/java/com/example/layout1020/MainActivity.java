package com.example.layout1020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    EditText result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculayout);

        result = findViewById(R.id.result);

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String resultText = result.getText().toString();
//                StringTokenizer tk = new StringTokenizer(resultText, "AC|+/-|%|/|x|-|+|=|.", true);
//                Log.d("result : ", String.valueOf(tk));
            }
        });
    }


    public void onClickBtn(View v) {
        int id = v.getId();
        // ID의 값을 확인하는 Log.
        Log.d("id의 값 : ", String.valueOf(id));
        switch (id) {
            case R.id.btnAC:    // AC
                Toast.makeText(this,"AC 클릭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnPM:    // +/-
                Toast.makeText(this,"+/- 클릭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnPER:   // %
                Toast.makeText(this,"% 클릭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnDiv:   // /
                Toast.makeText(this,"/ 클릭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnMulti:  // *
                Toast.makeText(this,"x 클릭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSub:   // -
                Toast.makeText(this,"- 클릭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnPlus:  // +
                Toast.makeText(this,"+ 클릭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnDoubleZero:  // 00
                Toast.makeText(this,"00 클릭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnZero:  // 0
                Toast.makeText(this,"0 클릭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn1:     // 1
                Toast.makeText(this,"1 클릭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn2:     // 2
                Toast.makeText(this,"2 클릭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn3:     // 3
                Toast.makeText(this,"3 클릭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn4:     // 4
                Toast.makeText(this,"4 클릭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn5:     // 5
                Toast.makeText(this,"5 클릭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn6:     // 6
                Toast.makeText(this,"6 클릭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn7:     // 7
                Toast.makeText(this,"7 클릭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn8:     // 8
                Toast.makeText(this,"8 클릭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn9:     // 9
                Toast.makeText(this,"9 클릭", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}