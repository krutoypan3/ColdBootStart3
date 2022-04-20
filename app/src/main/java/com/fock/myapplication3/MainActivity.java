package com.fock.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Написать приложение, которое только при третьем своем холодном старте показывает Toast с произвольным текстом.

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        int coldBootCount = sharedPreferences.getInt("coldBootCount", 1); //see if it's run before, default no
        if (coldBootCount == 3) {
            Toast.makeText(getApplicationContext(), "Третий холодный запуск приложения", Toast.LENGTH_SHORT).show();
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("coldBootCount", coldBootCount + 1);
        edit.apply(); //apply
    }
}