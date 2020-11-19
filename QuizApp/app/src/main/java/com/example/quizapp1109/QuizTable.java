package com.example.quizapp1109;

import android.content.Context;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizTable {

    public static String[] problem = {
      "어린이와 유아는 COVID-19 무증상자가 많다:o",                // o
            "비행기 내부는 COVID-19에 감염될 확률이 낮다:o",        // o
            "마른 사람보다 비만인 사람이 COVID-19 에 강하다:x",      // x
            "핸드 드라이기는 COVID-19 를 죽이는데 효과가 있다:x",     // x
            "자외선 램프는 COVID-19 를 죽이는데 효과가 있다:x",      // x
            "체온계로 COVID-19 를 찾을 수 있다:x",                 //x
            "중국에서 오는 우편물들은 안전하다:o",                  // o
            "반려동물들도 COVID-19에 감염될 수 있다:o",           // o
            "식염수로 코를 씻는 것은 COVID-19 예방에 도움이 된다:o"    // x
            // 문제와 정답을 붙여쓰고, 데이터를 받아온 뒤, 파싱을 해서 데이터를 정제.
    };

    public static String setRandomProblem(TextView textView) {
        int n = (int)(Math.random()*9); // 0~8 까지.
        String quiz1 = QuizTable.problem[n];
        String[] problem;
        String answer;
        problem = quiz1.split(":"); // : 를 구분자로 요소를 구분해서 배열로 리턴된 값을 저장한다.
        answer = problem[1];
        textView.setText(problem[0]);
        return answer;
    }

    public static void doOK(Context context, Button button) {
        Toast.makeText(context, "정답입니다 :) \n다음 퀴즈에 도전하세요.", Toast.LENGTH_SHORT).show();
        button.setEnabled(true);
        button.setBackgroundResource(R.drawable.nextbutton);
    }

    public static void doFail(Context context, Button button) {
        Toast.makeText(context, "오답입니다 :) \n다시 퀴즈에 도전하세요.", Toast.LENGTH_SHORT).show();
    }
}
