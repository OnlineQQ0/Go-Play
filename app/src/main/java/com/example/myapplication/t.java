package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class t extends AppCompatActivity implements View.OnClickListener{
    TextView shit;
    TextView textView2;
    Button button;
    Intent intent1;
    Intent intent;


    int screenWidth, screenHeight, buttonWidth, buttonHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t);
        shit = findViewById(R.id.shit);
        textView2 = findViewById(R.id.textView2);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);

        // Получаем экземпляр кнопки и размеры экрана

        screenWidth = getResources().getDisplayMetrics().widthPixels;
        screenHeight = getResources().getDisplayMetrics().heightPixels;
        buttonWidth = button.getWidth();
        buttonHeight = button.getHeight();

        button.setX(0);
        button.setY(0);

        intent = getIntent();
        int i = intent.getIntExtra("t", 0);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                intent1 = new Intent(t.this, Last.class);
                intent1.putExtra("num", shit.getText().toString());
                intent1.putExtra("t", i);
                startActivity(intent1);
                finish();
            }
        }, 1000*i);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                int num = Integer.parseInt(shit.getText().toString());
                num++;
                shit.setText(String.valueOf(num));
                // Генерируем случайные координаты
                int x = (int) ((Math.random() * (screenWidth - buttonWidth - 50)));
                int y = (int) ((Math.random() * (screenHeight - buttonHeight - 100)));

                // Устанавливаем новое положение кнопки
                button.setX(x);
                button.setY(y);
        }

    }
}