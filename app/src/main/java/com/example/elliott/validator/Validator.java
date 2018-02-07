package com.example.elliott.validator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Validator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validator);

        final TextView resultValidate = findViewById(R.id.resultValidate);
        final TextView enterPass = findViewById(R.id.enterPass);

        findViewById(R.id.validatePass).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (validate(enterPass.getText().toString()))
                    resultValidate.setText(R.string.validate_success);
                else
                    resultValidate.setText(R.string.validate_failure);
            }
        });
    }

    public static boolean validate(String password)
    {
        boolean result1 = false;
        boolean result2 = false;
        boolean result3 = false;

        if (password.equalsIgnoreCase("password"))
            return false;
        if (password.length() < 8)
            return false;
        for (int i=0; i<password.length(); i++)
        {
            if (!Character.isLetter(password.charAt(i)) && !Character.isDigit(password.charAt(i)))
                result1 = true;
        }
        if (!result1)
            return false;
        for (int i=0; i<password.length(); i++)
        {
            if (Character.isDigit(password.charAt(i)))
                result2 = true;
        }
        if(!result2)
            return false;
        for (int i=0; i<password.length(); i++)
        {
            if (password.charAt(i) >= 65 && password.charAt(i) <= 90)
                result3 = true;
        }
        if(!result3)
            return false;
        return true;
    }
}
