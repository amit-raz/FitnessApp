package com.example.fitnessappv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin;
    private TextView tvSignUp;

    private String registeredUsername = "";
    private String registeredPassword = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvSignUp = findViewById(R.id.tvSignUp);

        // קריאת הפרטים שהגיעו מ-RegisterActivity
        Intent intent = getIntent();
        if (intent != null) {
            String userExtra = intent.getStringExtra("username");
            String passExtra = intent.getStringExtra("password");

            // בדיקה שהפרטים שהגיעו אינם null ואינם ריקים
            if (userExtra != null && !userExtra.isEmpty()) {
                registeredUsername = userExtra;
            }
            if (passExtra != null && !passExtra.isEmpty()) {
                registeredPassword = passExtra;
            }
        }

        // בדיקה בלחיצה על כפתור הכניסה
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputEmail = etEmail.getText().toString().trim();
                String inputPassword = etPassword.getText().toString().trim();

                // בדיקת שדות ריקים
                if (inputEmail.isEmpty()) {
                    etEmail.setError("Please enter your username/email");
                    return;
                }
                if (inputPassword.isEmpty()) {
                    etPassword.setError("Please enter your password");
                    return;
                }

                // בדיקה אם המשתמש נרשם מראש
                if (registeredUsername.isEmpty() || registeredPassword.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "No registered account found. Please sign up first.", Toast.LENGTH_LONG).show();
                    return;
                }

                // השוואת הקלט לפרטים שנרשמו באמצעות equals()
                if (inputEmail.equals(registeredUsername) && inputPassword.equals(registeredPassword)) {
                    Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    // כאן ניתן לעבור למסך הראשי בעתיד (MainActivity)
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // מעבר למסך ההרשמה
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSignUp = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intentSignUp);
                finish();
            }
        });
    }
}