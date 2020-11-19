package com.example.extwidget1027;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Chronometer chronometer;
    Button btnStart, btnEnd;
    RadioButton radioCal, radioTime;
    CalendarView calendarView;
    TimePicker timePicker;
    TextView textViewYear, textViewMonth, textViewDay, textViewHour, textViewMinute;
    int selectYear, selectMonth, selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약 설정");

        chronometer = findViewById(R.id.chronometer);
        btnStart = findViewById(R.id.btnStart);
        btnEnd = findViewById(R.id.btnEnd);
        radioCal = findViewById(R.id.radioCal);
        radioTime = findViewById(R.id.radioTime);
        calendarView = findViewById(R.id.calendarView);
        timePicker = findViewById(R.id.timePicker);
        textViewYear = findViewById(R.id.textViewYear);
        textViewMonth = findViewById(R.id.textViewMonth);
        textViewDay = findViewById(R.id.textViewDay);
        textViewHour = findViewById(R.id.textViewHour);
        textViewMinute = findViewById(R.id.textViewMinute);

        calendarView.setVisibility(View.INVISIBLE);
        timePicker.setVisibility(View.INVISIBLE);

        radioTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePicker.setVisibility(View.VISIBLE);
                calendarView.setVisibility(View.INVISIBLE);
            }
        });

        radioCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendarView.setVisibility(View.VISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
            }
        });

        // 타이머 설정
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                // 운영체제로부터 시간에 대한 정보를 가져온다.

                chronometer.start();
                chronometer.setTextColor(Color.BLUE);
            }
        });

        // 날짜, 시간, 정보 가져오기
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.stop();
                chronometer.setTextColor(Color.RED);
                // 문자열로 바꾸는 정석적인 방법
                textViewYear.setText(Integer.toString(selectYear));
                // 문자열로 바꾸는 편리한 방법
                textViewMonth.setText(selectMonth+"");
                textViewDay.setText(selectDay+"");
                textViewHour.setText(Integer.toString(timePicker.getCurrentHour()));
                textViewMinute.setText(Integer.toString(timePicker.getCurrentMinute()));
            }
        });


        // 캘린더 뷰 설정
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectYear = year;
                selectMonth = month + 1;    // 0 부터 시작. 따라서 + 1을 해준다.
                selectDay = dayOfMonth;
            }
        });
    }
}