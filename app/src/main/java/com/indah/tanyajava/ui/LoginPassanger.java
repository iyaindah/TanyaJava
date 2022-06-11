package com.indah.tanyajava.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.indah.tanyajava.R;
import com.indah.tanyajava.api.ApiClient;
import com.indah.tanyajava.api.LoginRequest;
import com.indah.tanyajava.api.LoginResponse;
import com.indah.tanyajava.fragments.ExploreFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPassanger extends AppCompatActivity {

    TextView signUp;
    ImageView buttonBack;
    EditText email, password;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_passanger);

        btnlogin = findViewById(R.id.btnlogin);
        signUp = findViewById(R.id.btnsignup);
        buttonBack = findViewById(R.id.button_back);
        email = findViewById(R.id.edit_txt_email);
        password = findViewById(R.id.edit_txt_password);

        signUp.setOnClickListener(view -> {
            startActivity(new Intent(LoginPassanger.this, SignUpUser.class));
        });

        buttonBack.setOnClickListener(view -> {
            startActivity(new Intent(LoginPassanger.this, SelectTypeUser.class));
        });

        btnlogin.setOnClickListener(view -> {
            if(TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                Toast.makeText(LoginPassanger.this, "Email and Password required", Toast.LENGTH_SHORT).show();
            }else {
                login();
            }
        });

    }

    public void login(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(email.getText().toString());
        loginRequest.setPassword(password.getText().toString());

        Call<LoginResponse> loginResponseCall = ApiClient.getUserService().userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(LoginPassanger.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginPassanger.this, MenuActivity.class));
                } else {
                    Toast.makeText(LoginPassanger.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginPassanger.this, SignUpUser.class));
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginPassanger.this, "Throwable "+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginPassanger.this, SignUpUser.class));
            }
        });
    }
}