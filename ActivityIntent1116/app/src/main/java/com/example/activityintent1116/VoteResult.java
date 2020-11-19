package com.example.activityintent1116;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class VoteResult extends AppCompatActivity {

    Button exitVote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_result);
        setTitle("Vote Draw Result");

        Intent intent = getIntent();
        int[] count = intent.getIntArrayExtra("VOTE_COUNT");
        String[] name = intent.getStringArrayExtra("IMG_NAME");

        TextView[] tv = new TextView[name.length];
        RatingBar[] rb = new RatingBar[count.length];

        Integer[] tvId = {  // 명화 이름
                R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9
        };

        Integer[] rvId = {  // 투표 갯수
                R.id.rb1, R.id.rb2, R.id.rb3, R.id.rb4, R.id.rb5, R.id.rb6, R.id.rb7, R.id.rb8, R.id.rb9
        };

        for (int i = 0; i < count.length; i++) {
            final int index = i;
            tv[index] = findViewById(tvId[index]);
            rb[index] = findViewById(rvId[index]);

            tv[index].setText(name[index]);
            rb[index].setRating((float)count[index]);
        }

        exitVote = findViewById(R.id.exitVote);
        exitVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}