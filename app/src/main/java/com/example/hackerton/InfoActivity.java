package com.example.hackerton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;


import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Switch;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.BreakIterator;

public class InfoActivity extends AppCompatActivity {
    ///
    private String URL = "https://search.naver.com/search.naver?where=nexearch&sm=top_sly.hst&fbm=0&acr=1&acq=%EC%9D%B8%EC%B2%9C%EB%82%A0%EC%94%A8&qdt=0&ie=utf8&query=%EC%9D%B8%EC%B2%9C%EB%82%A0%EC%94%A8";
    private boolean isEmpty;
    private boolean isEmpty2;
    private String tem;
    private String tem2;
    private TextView textView;
    ///


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_message:
                    startActivity(new Intent(getApplicationContext(), MessageActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_polar_bear:
                    startActivity(new Intent(getApplicationContext(), PolarBearActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_info:
                    return true;
                case R.id.bottom_profile:
                    startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
            }
            return false;
        });

        textView = findViewById(R.id.weather_info);

        new Thread() {
            @Override
            public void run() {
                try {
                    Document doc = Jsoup.connect(URL).get();    // URL 웹사이트에 있는 html 코드를 가져오기
                    //Log.d("Tag","htmlcode?"+doc);
                    Elements temple = doc.select(".temperature_text");
                    Elements temple2 = doc.select(".summary"); // 가져온 html에서 클래스 이름이 "temperature_text"인 값을 선택하여 가져오기
                    isEmpty = temple.isEmpty(); // 가져온 값이 null인지 체크
                    isEmpty2 = temple2.isEmpty();
                    Log.d("Tag","무란?"+ temple2);
                    //Log.d("Tag", "isNull? : " + temple); // 로그캣 출력
                    Log.d("Tag","씹무란?"+ temple2.get(0).text().substring(14));
                    if (!isEmpty2 && !isEmpty) { // null 값이 아니면 크롤링 실행
                        tem = temple.get(0).text().substring(5); // 크롤링하면 "현재온도30°C"와 같이 가져오기 때문에, 현재온도를 잘라내고 30°C만 추출하는 코드
                        tem2 = temple2.get(0).text().substring(14);
                        Bundle bundle = new Bundle();
                        bundle.putString("temperature", tem); // 추출한 결과값을 bundle에 담아서 메인 스레드로 전달
                        bundle.putString("weather", tem2);
                        Message message = new Message();
                        message.setData(bundle);
                        handler.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public void launchRecycleArea (View v) {
        Switch mySwitch = (Switch) v;
        boolean isChecked = mySwitch.isChecked();

        if (isChecked) {
            startActivity(new Intent(getApplicationContext(), RecycleActivity.class));
        }
        mySwitch.setChecked(!isChecked);
    }

    private Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            Bundle bundle = msg.getData();    // new Thread에서 작업한 결과물 받기
            String temperature = bundle.getString("temperature"); // 받아온 데이터를 변수에 저장
            String temperature2 = bundle.getString("weather"); // 추가 데이터를 변수에 저장
            String text = temperature + "\n" + temperature2; // 온도와 추가 데이터를 연결하여 하나의 문자열로 생성
            textView.setText(text);   // 변수에 저장된 데이터를 textView에 출력
        }
    };
}