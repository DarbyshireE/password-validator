package com.example.elliott.validator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Validator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validator);
    }

    public static boolean validate(String password)
    {
        if (password.equalsIgnoreCase("password"))
            return false;
        if (password.length() < 8)
            return false;
        else
            return true;
    }
}
