package com.example.invisible;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    CheckBox checkBox;
    TextView title;
    Button choiceBt;
    RadioGroup rGroup;
    ImageView resultImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = findViewById(R.id.checkBox);
        title = findViewById(R.id.title);
        choiceBt = findViewById(R.id.choiceBt);
        rGroup = findViewById(R.id.rGroup);
        resultImage = findViewById(R.id.resultImage);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox.isChecked() == true) {
                    // isChecked() : 체크가 되었는지를 파악하는 메서드.
                    // 정보표시
                    title.setVisibility(View.VISIBLE);
                    choiceBt.setVisibility(View.VISIBLE);
                    rGroup.setVisibility(View.VISIBLE);
                    resultImage.setVisibility(View.VISIBLE);
                } else {
                    // 정보표시 제거
                    title.setVisibility(View.INVISIBLE);
                    choiceBt.setVisibility(View.INVISIBLE);
                    rGroup.setVisibility(View.INVISIBLE);
                    resultImage.setVisibility(View.INVISIBLE);
                }
            }
        });

        choiceBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = rGroup.getCheckedRadioButtonId();
                switch (id) {
                    case R.id.dog:
                        resultImage.setImageResource(R.drawable.dog);
                        break;
                    case R.id.cat:
                        resultImage.setImageResource(R.drawable.cat);
                        break;
                    case R.id.hamster:
                        resultImage.setImageResource(R.drawable.mouse);
                        break;
                }
            }
        });
    }
}