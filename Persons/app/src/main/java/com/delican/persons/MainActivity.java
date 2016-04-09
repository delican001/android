package com.delican.persons;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {

    View v;
    TextView textView1;
    Button buttonPut, buttonWrite;
    EditText editText1, editText2;
    SharedPreferences sharedPreferences;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            textView1 = (TextView) findViewById(R.id.textView1);
            editText1 = (EditText) findViewById(R.id.editText1);
            editText2 = (EditText) findViewById(R.id.editText2);
            buttonPut = (Button) findViewById(R.id.buttonPut);
            buttonWrite = (Button) findViewById(R.id.buttonWrite);
            final TreeSet<Person> tSet = new TreeSet<Person>();

            View.OnClickListener click1 = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Person temp = new Person(Integer.valueOf(editText1.getText().toString()), editText2.getText().toString());

                        tSet.add(temp);
                        editText1.setText("");
                        editText2.setText("");
                        Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_LONG).show();
                        sharedPreferences = getPreferences(MODE_PRIVATE); //подключение к хранилищу
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        editor.putString("SOMEKEY",editText2.getText().toString());// кладем значение
                        editor.commit();
                    }
                    catch (Exception e){
                        Toast.makeText(getApplicationContext(),"Sth empty", Toast.LENGTH_LONG).show();
                    }
                }
            };
            View.OnClickListener click2 = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        textView1.setText(tSet.toString());
                        sharedPreferences = getPreferences(MODE_PRIVATE);
                    }
                    catch (Exception e)
                    {Toast.makeText(getApplicationContext(),"Troubles",Toast.LENGTH_LONG).show();
                }
            }};

            buttonPut.setOnClickListener(click1);
            buttonWrite.setOnClickListener(click2);



        }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.commit();
    }
}
