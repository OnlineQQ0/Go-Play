package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Last extends Activity implements View.OnClickListener{
    TextView textView;
    Button button2;
    Intent intent2;
    Intent intent;
    SharedPreferences sharedPreferences;
    final String SAVED_TEXT = "TEXT";
    final String SAVED_NUM = "NUMBER";
    final String SEC = "NUMBER";
    final String SE = "NUMBER";
    int r =0;
    int at = 0;
    TextView rec;
    TextView top;
    Button sbr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_last);
        super.onCreate(savedInstanceState);

        intent = getIntent();
        Intent intent1 = getIntent();
        int num = Integer.parseInt(intent1.getStringExtra("num"));
        int i = intent.getIntExtra("t", 0);

        textView = findViewById(R.id.textView);

        rec = findViewById(R.id.rec);
        top = findViewById(R.id.top);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);


        textView.setText(String.valueOf(num));
        if(i == 10){
            loadData("val1");
        }
        if(i == 20){
            loadData("val2");
        }
        if(i == 30){
            loadData("val3");
        }
        r = Integer.parseInt(rec.getText().toString());

        if( i == 10 && r<num){
            saveData("val1");
            }

        if( i == 20 && r<num){
            saveData("val2");
        }

        if( i == 30 && r<num){
            saveData("val3");
        }
        }
    void saveData(String nameVal) {
        sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(nameVal, Integer.parseInt(textView.getText().toString()));
        editor.commit();

    }
    void loadData(String nameVal) {
        sharedPreferences = getPreferences(MODE_PRIVATE);
        Integer savedNum = sharedPreferences.getInt(nameVal, 0);
        rec.setText(savedNum.toString());

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button2:
                intent2 = new Intent(Last.this, MainActivity.class);
                startActivity(intent2);
                finish();
                break;

        }
    }
}