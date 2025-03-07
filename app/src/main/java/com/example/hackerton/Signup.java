package com.example.hackerton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;

public class Signup extends AppCompatActivity {

    TextView back;
    EditText signEmail,signPw,signPw2,CodeCheck;
    Button pwcheck, submit ,CodeCheckbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //뒤로 가기 버튼
        back = findViewById(R.id.back);
        back.setOnClickListener(v -> onBackPressed() );

        //기입 항목
        signEmail = findViewById(R.id.signEmail);
        signPw = findViewById(R.id.signPw);
        signPw2 = findViewById(R.id.signPw2);
        CodeCheck = findViewById(R.id.CodeCheck);

        //비밀번호 확인 버튼
        pwcheck = findViewById(R.id.pwcheckbutton);
        pwcheck.setOnClickListener(v -> {
            if(signPw.getText().toString().equals(signPw2.getText().toString())){
                pwcheck.setText("일치");
            }else{
                Toast.makeText(Signup.this, "비밀번호가 다릅니다.", Toast.LENGTH_LONG).show();
            }
        });



        //코드 전송 버튼

        CodeCheckbt = findViewById(R.id.CodeButton);
        CodeCheckbt.setOnClickListener(v -> {
            String signemail = signEmail.getText().toString();
            String signpw = signPw.getText().toString();
            Amplify.Auth.signUp(
                    signemail,
                    signpw,
                    AuthSignUpOptions.builder()
                            .userAttribute(AuthUserAttributeKey.email(), signemail)
                            .build(),
                    result -> {
                        Log.i("Amplify Auth", "Result: " + result.toString());
                        // 사용자 지정 속성 추가 성공
                    },
                    error -> {
                        Log.e("Amplify Auth", "Sign up failed", error);
                        // 사용자 지정 속성 추가 실패
                    }
            );
        });

        //회원가입 완료 버튼
        submit = findViewById(R.id.storeBt);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String signemail = signEmail.getText().toString();
                String codeCheck = CodeCheck.getText().toString();
                //코드 확인
                Amplify.Auth.confirmSignUp(
                        signemail,
                        codeCheck,
                        result -> {
                            Log.i("Amplify Auth", "Confirm sign-up result: " + result.toString());
                            // 회원가입 확인 성공

                            // 예시: MainActivity로 이동
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                            finish();
                        },
                        error -> {
                            Log.e("Amplify Auth", "Confirm sign-up failed", error);
                            // 회원가입 확인 실패
                        }
                );


                /*
                Login item = Login.builder()
                        .id2(signid)
                        .password(signpw)
                        .name(name)
                        .age(age)
                        .height(height)
                        .weight(weight)
                        .number(number)
                        .build();

                Amplify.DataStore.save(
                        item,
                        success -> Log.i("Amplify", "Saved item: " + success.item().getId()),
                        error -> Log.e("Amplify", "Could not save item to DataStore", error)
                );

                 */
            }
        });


    }
}