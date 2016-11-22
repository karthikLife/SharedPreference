package com.example.hp.sharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.hp.sharedpreference.R.id.username;

public class ActivityB extends AppCompatActivity {

Button b1;
    public static final String DEFAULT="N/A";

    TextView userNameTextView,passwordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        userNameTextView=(TextView)findViewById(R.id.textView2);
        passwordTextView=(TextView)findViewById(R.id.textView4);
        b1=(Button)findViewById(R.id.prevoius);
    }
    public void load(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name", DEFAULT);
        String password = sharedPreferences.getString("password", DEFAULT);

        if (name.equals(DEFAULT) || password.equals(DEFAULT))

        {
Toast.makeText(this,"No data Found",Toast.LENGTH_LONG).show();
        } else {
            userNameTextView.setText(name);
            passwordTextView.setText(password);

            Toast.makeText(this,"Data Sucessfully",Toast.LENGTH_LONG).show();


        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in);
            }
        });
    }
    }

