package com.example.ebook;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.ybq.android.spinkit.style.RotatingPlane;
import com.github.ybq.android.spinkit.style.WanderingCubes;
import com.github.ybq.android.spinkit.style.Wave;

public class MainActivity extends AppCompatActivity {
    EditText edtEmail, edtPass;
    Button btnDnhap, btnDki;
    String Tendangnhap, Matkhau;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        edtEmail = (EditText) findViewById(R.id.editTextEmail);
        edtPass = (EditText) findViewById(R.id.editTextPass);

        btnDnhap = (Button) findViewById(R.id.buttonSignIn);
        btnDki = (Button) findViewById(R.id.buttonSignUp);

        //SignIn
        btnDnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtPass.getText().length() != 0 && edtEmail.getText().length() != 0){
                    if(edtPass.getText().toString().equals(Matkhau) && edtEmail.getText().toString().equals(Tendangnhap)){
                        Toast.makeText(MainActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(MainActivity.this, ActivityTrungGian.class);
                        startActivity(intent2);
                    }
                    else Toast.makeText(MainActivity.this, "The email or password you entered was incorrect!", Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(MainActivity.this, "Email and password cannot be empty!", Toast.LENGTH_SHORT).show();
            }



        });

        //SignUp
        btnDki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, MainActivityDangKy.class);
                startActivityForResult(intent1, 123456789);
            }
        });

        progressBar.setIndeterminateDrawable(new WanderingCubes());

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK && requestCode == 123456789 &&data != null){
            Tendangnhap = data.getStringExtra("UserEmailSignUp");
            Matkhau = data.getStringExtra("UserPassSignUp");
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


}