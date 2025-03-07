package com.example.hackerton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Information;


public class LoginActivity extends AppCompatActivity {

    private boolean isInformationExists = false;
    Button loginbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView signButton = findViewById(R.id.signButton);
        //회원가입 페이지로 이동
        signButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, Signup.class);
            startActivity(intent);
        });

        EditText editID = findViewById(R.id.editID);
        EditText editPassword = findViewById(R.id.editPassword);

        //로그인
        Amplify.Auth.signOut( signOutResult -> {Log.i("Amplify Auth", "out");});

        // 로그인 버튼 클릭시
        loginbutton = findViewById(R.id.loginbutton);
        loginbutton.setOnClickListener(v -> {


            String editid = editID.getText().toString();
            String editpassword = editPassword.getText().toString();

            Amplify.API.query(
                    ModelQuery.list(Information.class),
                    response -> {
                        for (Information information : response.getData()) {
                            // 각 정보에 대한 작업을 수행합니다.
                            String user = information.getUser();
                            Log.i("Amplify API", user);
                            if (information.getUser().equals(editid)) {
                                isInformationExists = true;
                                Log.i("Amplify API", "true");
                                break;
                            }
                        }
                    },
                    error -> {
                        // 쿼리 실패 시 오류 처리를 수행합니다.
                        Log.e("Amplify API", "Query failed", error);
                    }
            );

            Amplify.Auth.signIn(
                    editid,
                    editpassword,
                    result -> {
                        Log.i("Amplify Auth", result.isSignedIn() ? "Sign in succeeded" : "Sign in not complete");
                        // 로그인 성공 시 실행할 작업을 여기에 추가
                        if (result.isSignedIn()) {
                            if (isInformationExists) {
                                Log.i("Amplify API", "true1");
                                // Information 데이터가 존재하는 경우
                                Intent intent1 = new Intent(this, MainActivity.class);
                                intent1.putExtra("userId", editid);
                                startActivity(intent1);
                            } else {
                                // Information 데이터가 존재하지 않는 경우
                                Intent intent = new Intent(this, UserInfoActivity.class);
                                intent.putExtra("userId", editid);
                                startActivity(intent);
                            }


                        }
                    },
                    error -> Log.e("Amplify Auth", error.toString())
            );


            /*
            Amplify.DataStore.query(
                    Login.class,
                    items -> {
                        while (items.hasNext()) {
                            Login item = items.next();
                            Log.i("Amplify", "Id " + item.getId2());
                            Log.i("Amplify", "Id " + item.getPassword());
                            Log.i("Amplify", "Id " + editid);
                            Log.i("Amplify", "Id " + editpassword);

                            if(editid.equals(item.getId2()) && editpassword.equals(item.getPassword())) {
                                Intent intent = new Intent(this, HomeActivity.class);
                                startActivity(intent);
                                Log.i("ss", "ss ");
                            }
                        }
                    },
                    failure -> Log.e("Amplify", "Could not query DataStore", failure)
            );
            */
        });


    }
}