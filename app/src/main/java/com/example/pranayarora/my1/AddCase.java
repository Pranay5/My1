package com.example.pranayarora.my1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class AddCase extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2;
    EditText et1,et2,et3,et4,et5,et6;
    TextView t1,t2,t3;
    Spinner s1,s2,s3;

    String a1[]={"Select one","Session Court","District Court","High Court","Supreme Court","Labour Court","Consumer Court"};
    String a2[]={"Select one","Civil","Criminal","Fraud","Accident"};
    String a3[]={"Select one","Appearing of Client","Appreance of Other Side","Evidence","Re-appearance","Case Closure"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_case);
        et1=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText2);
        et3=(EditText)findViewById(R.id.editText3);
        et4=(EditText)findViewById(R.id.editText4);
        et5=(EditText)findViewById(R.id.editText5);
        et6=(EditText)findViewById(R.id.editText6);
        t1 = (TextView)findViewById(R.id.textView2);
        t2 = (TextView)findViewById(R.id.textView3);
        t3 = (TextView)findViewById(R.id.textView4);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

        s1 = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,a1);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_item);
        s1.setAdapter(aa);
    }

    @Override
    public void onClick(View v) {


    }
}
