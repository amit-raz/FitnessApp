package com.example.fitnessappv2; // וודא ששם החבילה תואם לפרויקט שלך

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // מציאת התמונה והפעלת האנימציה
        logo = findViewById(R.id.logo);
        Animation splashAnim = AnimationUtils.loadAnimation(this, R.anim.splash_anim);
        logo.startAnimation(splashAnim);

        // סעיפים 2-5: יצירת ה-Thread עם sleep, try-catch-finally ומעבר ל-LoginActivity
        new Thread() {
            @Override
            public void run() {
                try {
                    sleep(3000); // סעיף 3: המתנה של 3 שניות
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // סעיף 5: מעבר ל-LoginActivity וסגירת המסך
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }.start(); // סעיף 6: הפעלת המסלול (start)
    }
}