package com.example.myhello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    // ** [ 1. 위젯(뷰)를 제어하기 위한 변수 선언. (위젯과 연결할 변수를 선언.) ] **
    Button ok, cancle, submitt;
    TextView output;
    EditText input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // R = res folder
        // layout = res 폴더 밑의 layout folder
        // activity_main = layout folder 안의 xml 파일

        // setContentView() = Design 된 layout 과(activity_main) 소스코드 를 결합하는 메서드.
        // iOS 로 치면 main_StoryBoard 와 swift 파일을 결합시키는 것.


        // ** [ 2. 변수와 위젯을 연결 ] : findViewById(R.id.아이디) 메서드 **
        ok = findViewById(R.id.OK_Button);
        cancle = findViewById(R.id.Cancle_Button);
        submitt = findViewById(R.id.submit);

        input = findViewById(R.id.input);
        output = findViewById(R.id.output);


        // ** [ 3. 변수를 통해서 위젯을 제어 ] **
        // 터치시 실행할 메서드.
        ok.setOnClickListener(new View.OnClickListener() {  // View(인터페이스) 의 추상메서드 = OnClickListener() 이므로, 구현해줘야 한다.
            @Override
            public void onClick(View v) {
                // 팝업창 = toast
                Toast.makeText(MainActivity.this, "OK 버튼 클릭", Toast.LENGTH_SHORT).show();
                output.setText("Hi");

            }
        });

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Cancle 버튼 클릭", Toast.LENGTH_SHORT).show();
                output.setText("Bye");
            }
        });

        submitt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                output.setText("입력하신 정보는 " + str + " 입니다.");
            }
        });
    }
}