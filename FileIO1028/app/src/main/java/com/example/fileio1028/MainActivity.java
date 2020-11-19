package com.example.fileio1028;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.icu.util.Output;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    final String FILE_NAME = "test.txt";
    EditText input;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);
        output = findViewById(R.id.output);
    }

    // 내장메모리에 쓰기
    public void intMemWrite(View view) {
        try {
            FileOutputStream fileOutputStream = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            // 파일 열고 쓰기.(자원) 자원을 쓰면 반드시 반환을 해줘야 한다.
            fileOutputStream.write(input.getText().toString().getBytes());
            /*
                운영체제가 다르면 언어를 처리하는 방식이 다르기 때문에 언어가 깨질 수 있다.
                그런 문제를 해결하기 위해 데이터를 byte 로 변환해서 저장, 읽어온 후 각 운영체제에 맞게 처리하면 깨지지 않는다.
                utf-8 로 코딩이 일반적.
             */


            // 사용한 자원 반환하기.
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    // 내장메모리 읽어오기
    public void intMemRead(View view) {
        try {

            FileInputStream fileInputStream = openFileInput(FILE_NAME);
            byte[] buf = new byte[fileInputStream.available()];
            fileInputStream.read(buf);
            output.setText(new String(buf));
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    // 외장메모리에 쓰기
    public void extMemWrite(View view) {

        String state = Environment.getExternalStorageState();
        // Environment class = 안드로이드의 상태
        if (state.equals(Environment.MEDIA_MOUNTED) == false) {
            Toast.makeText(this, "SD 카드 인식 실패", Toast.LENGTH_SHORT).show();
            return;
        }
        File file = new File(getExternalFilesDir(null), FILE_NAME);
        Log.d("MY_TAG :", "외장 메모리 경로 :" + file.toString());

        try {
            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write(input.getText().toString().getBytes());
            // input 에 입력된 정보를 to String 으로 얻어온 뒤, 그 정보의 byte 정보를 outputStream 인스턴스에 저장.
            outputStream.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    // 외장메모리 읽어오기
    public void extMemRead(View view) {
        String state = Environment.getExternalStorageState();
        // Environment class = 안드로이드의 상태
        if (state.equals(Environment.MEDIA_MOUNTED) == false) {
            Toast.makeText(this, "SD 카드 인식 실패", Toast.LENGTH_SHORT).show();
            return;
        }

        File file = new File(getExternalFilesDir(null), FILE_NAME);
        try {
            InputStream inputStream = new FileInputStream(file);
            byte[] buf = new byte[inputStream.available()];
            // 가용할 수 있는 사이즈를 자동으로 범위 지정.
            inputStream.read(buf);
            output.setText(new String(buf));
            inputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    // raw 메모리 읽어오기
    public void rawMemRead(View view) {
        InputStream inputStream = getResources().openRawResource(R.raw.test);
        // R = res 를 총괄하는 객체
        try {
            byte[] buf = new byte[inputStream.available()];
            inputStream.read(buf);
            output.setText(new String(buf));
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}