package com.example.DBPersons;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends Activity {
    private Button btSave,btCancel;
    private EditText etLogin,etPassword,etName,etSurname;
    private Context context;
    private long MyPersonsID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etLogin=(EditText)findViewById(R.id.Login);
        etPassword=(EditText)findViewById(R.id.Password);
        etName=(EditText)findViewById(R.id.Name);
        etSurname=(EditText)findViewById(R.id.Surname);
        btSave=(Button)findViewById(R.id.butSave);
        btCancel=(Button)findViewById(R.id.butCancel);

        if(getIntent().hasExtra("Persons")){
            Persons persons=(Persons)getIntent().getSerializableExtra("Persons");
            etLogin.setText(persons.getLogin());
            etPassword.setText(persons.getName());
            etName.setText(persons.getName());
            etSurname.setText(persons.getSurname());
            MyPersonsID=persons.getId();
        }
        else
        {
            MyPersonsID=-1;
        }
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Persons persons=new Persons(MyPersonsID,etLogin.getText().toString(),etPassword.getText().toString(),
                                                      etName.getText().toString(),
                                                        etSurname.getText().toString());
                Intent intent=getIntent();
                intent.putExtra("Persons", persons);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}

