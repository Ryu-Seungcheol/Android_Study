package com.example.quizapp1109;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.example.quizapp1109.QuizTable.doFail;
import static com.example.quizapp1109.QuizTable.doOK;

public class QuizStep1 extends AppCompatActivity {
    // button 을 제어하기 위해서는 연결을 시켜줘야 한다.
    Button quiz1_next;
    TextView quiz1_problem;
    String[] problem;
    String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_step1);
        quiz1_next = findViewById(R.id.quiz1_next);
        quiz1_next.setEnabled(false);   // 초기에 보여지지 않는다.
//        MediaPlayer.create(this, R.raw.name).start();

        quiz1_problem = findViewById(R.id.quiz1_problem);
        answer = QuizTable.setRandomProblem(quiz1_problem);
//        int n = (int)(Math.random()*9); // 0~8 까지.
//        String quiz1 = QuizTable.problem[n];
//        problem = quiz1.split(":"); // : 를 구분자로 요소를 구분해서 배열로 리턴된 값을 저장한다.
//        answer = problem[1];
//        quiz1_problem.setText(problem[0]);

        /* stringTokenizer 사용
        StringTokenizer str = new StringTokenizer(QuizTable.problem[n], delim: ":");
        while (str.hasMoreTokens()) {
            problem = token.nextToken();
            answer = token.nextToken();
        }
        quiz1_problem.setText(problem);

         */

//        quiz1_problem.setText(QuizTable.problem[n]);

    }

//    public void doOK() {
//        Toast.makeText(getApplicationContext(), "정답입니다 :) \n다음 퀴즈에 도전하세요.", Toast.LENGTH_SHORT).show();
//        quiz1_next.setEnabled(true);
//        quiz1_next.setBackgroundResource(R.drawable.nextbutton);
//    }
//
//    public void doFail() {
//        Toast.makeText(getApplicationContext(), "오답입니다 :) \n다시 퀴즈에 도전하세요.", Toast.LENGTH_SHORT).show();


    public void quiz1_onclick(View view){
        switch (view.getId()) {

            case R.id.quiz1_ok:
                if (answer.equals("o")) {
                   doOK(getApplicationContext(), quiz1_next);
                } else {
                    doFail(getApplicationContext(), quiz1_next);
                }
                break;

            case R.id.quiz1_not:
                if (answer.equals("x")) {
                   doOK(getApplicationContext(), quiz1_next);
                } else {
                    doFail(getApplicationContext(), quiz1_next);
                }
                break;

            case R.id.quiz1_home:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                // main 으로 넘어가기 전에 자신의 하위 stack 을 지운다.
                break;

            case R.id.quiz1_next:   // 퀴즈를 맞혔을 때 활성화. 초기상태는 비활성화.
                Intent intent1 = new Intent(getApplicationContext(), QuizStep2.class);
                startActivity(intent1);
                break;
        }
    }
}