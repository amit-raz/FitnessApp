package com.example.fitnessappv2; // וודא ששם החבילה תואם לפרויקט שלך

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    // הגדרת משתנים לרכיבי ה-UI
    private EditText etEmail, etPassword;
    private Button btnLogin;
    private TextView tvSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // דרישה 3: מציאת הרכיבים לפי המזהים שלהם (IDs)
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvSignUp = findViewById(R.id.tvSignUp);

        // דרישה 4: חיבור מאזין ללחיצה על כפתור ההתחברות (Sign in)
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // דרישה 5: קריאת ערכי השדות וניקוי רווחים מיותרים
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                // בדיקה אם אחד השדות ריק
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Logging in...", Toast.LENGTH_SHORT).show();
                    // כאן בהמשך תבוא לוגיקת האימות (Authentication)
                }
            }
        });

        /* דרישה 6: חיבור מאזין ללחיצה על טקסט ההרשמה למעבר ל-RegisterActivity וסגירת המסך
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish(); // סגירת המסך הנוכחי
            }
        }); */
    }
}