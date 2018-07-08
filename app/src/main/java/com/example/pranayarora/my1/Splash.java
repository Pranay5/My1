package com.example.pranayarora.my1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Splash extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2,b3,b4;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tv = (TextView) findViewById(R.id.textView);
        tv.setOnClickListener(this);
        b1 = (Button)findViewById(R.id.button1);
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
    if(v.getId() == b1.getId())
    {
        Intent a = new Intent(getApplicationContext(),AddCase.class);
        startActivity(a);
    }
        if(v.getId() == b2.getId())
        {
            Intent a = new Intent(getApplicationContext(),AddClient.class);
            startActivity(a);

        }
        if(v.getId() == b3.getId())
        {
            Intent a = new Intent(getApplicationContext(),AddHearing.class);
            startActivity(a);
        }
        if(v.getId() == b4.getId())
        {
            Intent a = new Intent(getApplicationContext(),AboutUs.class);
            startActivity(a);
        }

    }
}
