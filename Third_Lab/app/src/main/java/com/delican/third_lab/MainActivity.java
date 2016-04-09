package com.delican.third_lab;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.SharedPreferences.Editor;

import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.Login) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            return true;
        }
        else  if (id == R.id.Registation){
            Intent intent = new Intent(this, RegActivity.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.Exit)
        {
            AlertDialog.Builder dlgalert = new AlertDialog.Builder(this);
            dlgalert.setMessage("Are you sure you want to close this awesome app?:(");
            dlgalert.setTitle("Exit?");
            dlgalert.setPositiveButton("Yeah", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();

                }
            });

            dlgalert.setNegativeButton("No, This app is so awesome", null);
            dlgalert.setCancelable(true);
            dlgalert.create();
            dlgalert.show();
        }

        return super.onOptionsItemSelected(item);
    }
}
