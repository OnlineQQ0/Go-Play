package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    TextView text;
    Button t;
    Button t2;
    Button t3;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text = findViewById(R.id.text);

       Button t =  findViewById(R.id.t);
       t.setOnClickListener(this);
       Button t2 = findViewById(R.id.t2);
       t2.setOnClickListener(this);
       Button t3 =  findViewById(R.id.t3);
       t3.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        Intent i;
        Intent i2;
        Intent i3;
        switch (v.getId()) {
            case R.id.t:
                i = new Intent(MainActivity.this, t.class);

                i.putExtra("t", 10);
                startActivity(i);
                finish();
                break;
            case R.id.t2:
                i = new Intent(MainActivity.this, t.class);
                i.putExtra("t", 20);

                startActivity(i);
                finish();
                break;
            case R.id.t3:
                i = new Intent(MainActivity.this, t.class);
                i.putExtra("t", 30);

                startActivity(i);
                finish();
                break;
        }
    }
}