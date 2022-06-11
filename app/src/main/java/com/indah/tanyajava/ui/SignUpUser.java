package com.indah.tanyajava.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.indah.tanyajava.R;
import com.indah.tanyajava.api.ApiClient;
import com.indah.tanyajava.api.SignUpRequest;
import com.indah.tanyajava.api.SignUpResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpUser extends AppCompatActivity {

    ImageView buttonBack;
    Button btnSignup;
    TextView btnSignin;
    EditText username, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_user);

        buttonBack = findViewById(R.id.button_back);
        btnSignup = findViewById(R.id.btnsignup);
        btnSignin = findViewById(R.id.btnsignin);
        username = findViewById(R.id.edit_txt_username);
        email = findViewById(R.id.edit_txt_email);
        password = findViewById(R.id.edit_txt_password);

        buttonBack.setOnClickListener(view -> {
            startActivity(new Intent(SignUpUser.this, SelectTypeUser.class));
        });
        btnSignup.setOnClickListener(view -> {
            if( TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                Toast.makeText(SignUpUser.this, "Username, Email and Password required", Toast.LENGTH_SHORT).show();
            }else {
                signup();
            }
        });
        btnSignin.setOnClickListener(view -> {
            startActivity(new Intent(SignUpUser.this, SelectTypeUser.class));
        });
    }

    public void signup(){
        SignUpRequest signUpRequest = new SignUpRequest();
        signUpRequest.setUsername(username.getText().toString());
        signUpRequest.setEmail(email.getText().toString());
        signUpRequest.setPassword(password.getText().toString());

        Call<SignUpResponse> registerResponseCall = ApiClient.getUserService().userRegister(signUpRequest);
        registerResponseCall.enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(SignUpUser.this, "Signup Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUpUser.this, SelectTypeUser.class));
                } else {
                    Toast.makeText(SignUpUser.this, "Signup Failed", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUpUser.this, SignUpUser.class));
                }
            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                Toast.makeText(SignUpUser.this, "Throwable "+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SignUpUser.this, SignUpUser.class));
            }
        });
    }
}