package com.delican.third_lab;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

EditText editText1,editText2;
    Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        button1 = (Button)findViewById(R.id.button);
        editText1=(EditText)findViewById(R.id.EditText1);
        editText2=(EditText)findViewById(R.id.EditText2);
        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SharedPreferences uspas = getSharedPreferences("us-pas", MODE_PRIVATE);
        SharedPreferences uslog = getSharedPreferences("us-log", MODE_PRIVATE);
        try
        {
            String log = editText1.getText().toString();
            String pass = editText2.getText().toString();
            if (uspas.getString(log,"").equals(pass)) {
                Toast.makeText(this, "Welcome back, "+uslog.getString(log, ""), Toast.LENGTH_LONG).show();
            }
            else Toast.makeText(this,"Incorrect login or pass",Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            Toast.makeText(this,"Incorrect login or pass",Toast.LENGTH_LONG).show();
        }
    }
}
