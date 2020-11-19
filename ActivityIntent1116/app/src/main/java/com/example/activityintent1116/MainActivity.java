package com.example.activityintent1116;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    Button voteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Vote Draw");

        int voteCount[] = new int[9];   // 투표 정보 저장
        ImageView imageView[] = new ImageView[9];   // 그림 갯수
        int imageId[] = {
                R.id.im1, R.id.im2, R.id.im3, R.id.im4, R.id.im5, R.id.im6, R.id.im7, R.id.im8,
                R.id.im9
        };  // findViewById() 를 for 문으로 돌리기 위한 배열. 이미지 정보

        String imagName[] = {   // 이미지 이름
                "독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀", "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두 자매", "피아노 레슨", "피아노 앞의 소녀들", "해변에서"
        };

        for (int i = 0; i < imageId.length; i++) {  // 이렇게 코드로 반복되는 메소드를 정의하거나, 디자인툴에서 onClick 속성에 메소드를 지정해준다.
            final int index = i;    // 상수이지만, 한 사이클당 하나의 index 변수가 만들어진다. 총 0~8까지의 각 값을 가지는 9개의 변수가 만들어진다.
            imageView[index] = findViewById(imageId[index]);
            imageView[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[index]++;
                    Toast.makeText(MainActivity.this, imagName[index] + " : 총 투표수 " + voteCount[index], Toast.LENGTH_SHORT).show();
                }
            });
        }

        voteBtn = findViewById(R.id.voteBtn);
        voteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VoteResult.class);
                intent.putExtra("VOTE_COUNT", voteCount);    // 투표 정보를 넘겨준다.
                intent.putExtra("IMG_NAME", imagName);       // 그림 이름을 넘겨준다.
                startActivity(intent);
            }
        });
    }
}