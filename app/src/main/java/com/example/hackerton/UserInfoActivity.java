package com.example.hackerton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Information;


public class UserInfoActivity extends AppCompatActivity {

    EditText signname,signage,signheight,signweight,signnumber;
    Button storeBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //기입 항목
        signname = findViewById(R.id.signName);
        signage = findViewById(R.id.signAge);
        signheight = findViewById(R.id.signHeight);
        signweight = findViewById(R.id.signWeight);
        signnumber = findViewById(R.id.signNumber);

        Intent intent1 = getIntent();
        String userId = intent1.getStringExtra("userId"); // 사용자 ID 가져오기

        storeBt= findViewById(R.id.storeBt);
        storeBt.setOnClickListener(v->{
            String signName = signname.getText().toString();
            String signAge = signage.getText().toString();
            int age = Integer.parseInt(signAge);
            String signHeight = signheight.getText().toString();
            int height = Integer.parseInt(signHeight);
            String signWeight = signweight.getText().toString();
            int weight = Integer.parseInt(signWeight);
            String signNumber = signnumber.getText().toString();
            int number = Integer.parseInt(signNumber);

            Information model = Information.builder()
                    .name(signName)
                    .age(age)
                    .height(height)
                    .weight(weight)
                    .number(number)
                    .user(userId)
                    .build();

            Amplify.API.mutate(ModelMutation.create(model),
                    response -> Log.i("MyAmplifyApp", "Information with id: " + response.getData().getId()),
                    error -> Log.e("MyAmplifyApp", "Create failed", error));

            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("userId", userId);
            startActivity(intent);
            finish();

        });

    }
}