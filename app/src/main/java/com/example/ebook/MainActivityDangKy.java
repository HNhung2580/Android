package com.example.ebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivityDangKy extends AppCompatActivity {

    EditText edtLastname, edtFirstName ,edtEmailSignUp, edtPassSignUp;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dang_ky);

        edtFirstName = (EditText) findViewById(R.id.editFirstName);
        edtLastname = (EditText) findViewById(R.id.editLastName);
        edtEmailSignUp = (EditText) findViewById(R.id.editTextEmailSignUp);
        edtPassSignUp = (EditText) findViewById(R.id.editTextPassSignUp);

        btnSignUp = (Button) findViewById(R.id.buttonSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmailSignUp.getText().toString();
                String password = edtPassSignUp.getText().toString();
                String lastname = edtLastname.getText().toString();
                String firstname = edtFirstName.getText().toString();

                Intent intent4 = new Intent();
                intent4.putExtra("LastName",lastname);
                intent4.putExtra("FirstName", firstname);
                intent4.putExtra("UserEmailSignUp",email);
                intent4.putExtra("UserPassSignUp", password);
                setResult(RESULT_OK, intent4);

                if(lastname.length() == 0 || firstname.length() == 0 || email.length() == 0 || password.length() == 0){
                    Toast.makeText(MainActivityDangKy.this,"Not have enough information to create your account !", Toast.LENGTH_SHORT).show();
                }
                 else Toast.makeText(MainActivityDangKy.this, "You have signed up successfully!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}