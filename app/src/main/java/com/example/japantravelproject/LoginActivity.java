package com.example.japantravelproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;  // 파이어 베이스 인증
    private DatabaseReference mDatabaseRef; // 실시간 데이터 베이스
    private EditText mEtEmail, mEtPwd;
    private Button mBtnRegister;
    private Button mBtnLogin;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference();

        mEtEmail = findViewById(R.id.et_email);
        mEtPwd = findViewById(R.id.et_pwd);
        mBtnRegister = findViewById(R.id.btn_register);
        mBtnLogin = findViewById(R.id.btn_login);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strEmail = mEtEmail.getText().toString();
                String strPwd = mEtPwd.getText().toString();

                mFirebaseAuth.signInWithEmailAndPassword(strEmail, strPwd).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                             @Override
                             public void onComplete(@NonNull Task<AuthResult> task) {
                                 if (task.isSuccessful()) {
                                     //로그인 성공
                                     Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                     startActivity(intent);
                                     finish();
                                 } else {
                                     Toast.makeText(LoginActivity.this, "로그인 실패", Toast.LENGTH_SHORT).show();
                                 }
                            }
                        }
                );
            }
        });
        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
