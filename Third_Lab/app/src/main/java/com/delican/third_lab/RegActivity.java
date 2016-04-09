package com.delican.third_lab;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegActivity extends AppCompatActivity implements OnClickListener {

    EditText editText1,editText2,editText3,editText4;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        editText1 = (EditText)findViewById(R.id.EditText1);
        editText2 = (EditText)findViewById(R.id.EditText2);
        editText3 = (EditText)findViewById(R.id.EditText3);
        editText4 = (EditText)findViewById(R.id.EditText4);
        button1 = (Button)findViewById(R.id.button);
        button1.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.button)
        {
            if (editText3.getText().toString().equals(editText4.getText().toString())){
            SharedPreferences uspas = getSharedPreferences("us-pas", MODE_PRIVATE);
            SharedPreferences uslog = getSharedPreferences("us-log", MODE_PRIVATE);
            SharedPreferences.Editor edit_uspas = uspas.edit();
            SharedPreferences.Editor edit_uslog = uslog.edit();
            edit_uslog.putString(editText2.getText().toString(),editText1.getText().toString());
            edit_uspas.putString(editText2.getText().toString(),editText3.getText().toString());
            edit_uslog.apply();
            edit_uspas.apply();
                Toast.makeText(this,"Added",Toast.LENGTH_LONG).show();
        }
            else Toast.makeText(this,"Different passwords",Toast.LENGTH_LONG).show();
        }


    }


}
