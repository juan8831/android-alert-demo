package com.example.juanlopez.alertdemo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);
        if(item.getItemId() == R.id.english)
        {
            setLanguage("English");
        }
        else
        {
            setLanguage("Spanish");
        }

        return true;
    }

    public void setLanguage(String lang)
    {


        sharedPreferences.edit().putString("language", lang);

        TextView langTxt = (TextView)findViewById(R.id.langTxt);
        langTxt.setText(lang);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = this.getSharedPreferences("com.example.juanlopez.alertdemo", Context.MODE_PRIVATE);

        String lang = sharedPreferences.getString("lang", "");

        if(lang == "")
        {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Language Preference")
                    .setMessage("What language you want?")
                    .setPositiveButton("Spanish", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            setLanguage("Spanish");
                        }
                    })
                    .setNegativeButton("English", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            setLanguage("English");
                        }
                    })
                    .show();

        }



    }
}
