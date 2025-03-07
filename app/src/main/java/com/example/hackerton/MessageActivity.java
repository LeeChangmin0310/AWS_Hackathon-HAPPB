package com.example.hackerton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);


        TextView chatroom1 = findViewById(R.id.chatroom1);
        TextView chatroom2 = findViewById(R.id.chatroom2);
        TextView chatroom3 = findViewById(R.id.chatroom3);
        TextView chatroom4 = findViewById(R.id.chatroom4);
        TextView chatroom5 = findViewById(R.id.chatroom5);

        // 각 채팅방의 정보를 설정합니다.
        chatroom1.setText("00.01.26\n안녕 하세요?\n읽지 않은 메시지: 2");
        chatroom2.setText("lee_h.j\n구매가능할까요?\n읽지 않은 메시지: 1");
        chatroom3.setText("i_bright_man\n배송완료했습니다!\n읽지 않은 메시지: 0");
        chatroom4.setText("minjonyyy\n아쉽게도 팔렸어요\n읽지 않은 메시지: 3");
        chatroom5.setText("y_jin\n이거 에눌가능한가요?\n읽지 않은 메시지: 0");
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_message);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_message:
                    return true;
                case R.id.bottom_polar_bear:
                    startActivity(new Intent(getApplicationContext(), PolarBearActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_info:
                    startActivity(new Intent(getApplicationContext(), InfoActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_profile:
                    startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
            }
            return false;
        });
    }
}

