package com.example.quizapp1109;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizStep2 extends AppCompatActivity {

    // button 을 제어하기 위해서는 연결을 시켜줘야 한다.
    Button quiz2_next;
    TextView quiz2_problem;
    String[] problem;
    String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_step2);

        quiz2_next = findViewById(R.id.quiz2_next);
        quiz2_next.setEnabled(false);   // 초기에 보여지지 않는다.
//        MediaPlayer.create(this, R.raw.name).start();

        quiz2_problem = findViewById(R.id.quiz2_problem);
        answer = QuizTable.setRandomProblem(quiz2_problem);

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


    public void quiz2_onclick(View view){
        switch (view.getId()) {
            case R.id.quiz2_ok:
                if (answer.equals("o")) {
                   QuizTable.doOK(getApplicationContext(), quiz2_next);
                } else {
                    QuizTable.doFail(getApplicationContext(), quiz2_next);
                }

                break;

            case R.id.quiz2_not:
                if (answer.equals("x")) {
                    QuizTable.doOK(getApplicationContext(), quiz2_next);
                } else {
                    QuizTable.doFail(getApplicationContext(), quiz2_next);
                }
                break;

            case R.id.quiz2_home:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                // main 으로 넘어가기 전에 자신의 하위 stack 을 지운다.
                break;

            case R.id.quiz2_next:   // 퀴즈를 맞혔을 때 활성화. 초기상태는 비활성화.

                break;
        }
    }
}