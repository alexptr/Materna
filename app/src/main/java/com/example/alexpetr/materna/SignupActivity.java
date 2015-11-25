package com.example.alexpetr.materna;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.parse.ParseObject;

import Managers.User;
import Managers.UserManager;

public class SignupActivity extends AppCompatActivity implements TextWatcher {


    private boolean canSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ((EditText) findViewById(R.id.mailText)).addTextChangedListener(this);
        ((EditText) findViewById(R.id.confirmMailText)).addTextChangedListener(this);
        ((EditText) findViewById(R.id.passwordText)).addTextChangedListener(this);
        ((EditText) findViewById(R.id.confirmPasswordText)).addTextChangedListener(this);

    }

    public void SignMeUp (View view)
    {

        if (
                ((EditText) findViewById(R.id.mailText)).getCurrentTextColor() == Color.RED ||
                ((EditText) findViewById(R.id.confirmMailText)).getCurrentTextColor() == Color.RED ||
                ((EditText) findViewById(R.id.passwordText)).getCurrentTextColor() == Color.RED ||
                ((EditText) findViewById(R.id.confirmPasswordText)).getCurrentTextColor() == Color.RED
            )

        {

        }
        else
        {
            User user = new User();

            user.setUsername(((EditText) findViewById(R.id.nameText)).getText().toString());
            user.setEmail(((EditText) findViewById(R.id.mailText)).getText().toString());
            user.setPassword(((EditText) findViewById(R.id.passwordText)).getText().toString());

            Globals globals = (Globals)getApplicationContext();

            UserManager userManager = globals.GetUserManager();
            userManager.SaveNewUser(user);


            Intent intent = new Intent(this, DashboardActivity.class);
            startActivity(intent);
        }
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        /*
        ((EditText) findViewById(R.id.mailText)).addTextChangedListener(this);
        ((EditText) findViewById(R.id.confirmMailText)).addTextChangedListener(this);
        ((EditText) findViewById(R.id.passwordText)).addTextChangedListener(this);
        ((EditText) findViewById(R.id.confirmPasswordText)).addTextChangedListener(this);
        */

        if (!((EditText) findViewById(R.id.mailText)).getText().toString().equals(((EditText) findViewById(R.id.confirmMailText)).getText().toString()))
        {
            ((EditText) findViewById(R.id.mailText)).setTextColor(Color.RED);
            ((EditText) findViewById(R.id.confirmMailText)).setTextColor(Color.RED);

        }
        else
        {
            if (!isEmailValid(((EditText) findViewById(R.id.mailText)).getText().toString()))
            {
                ((EditText) findViewById(R.id.mailText)).setTextColor(Color.RED);

            }
            else
            {
                ((EditText) findViewById(R.id.mailText)).setTextColor(Color.BLACK);

            }

            if (!isEmailValid(((EditText) findViewById(R.id.confirmMailText)).getText().toString()))
            {
                ((EditText) findViewById(R.id.confirmMailText)).setTextColor(Color.RED);
            }
            else
            {
                ((EditText) findViewById(R.id.confirmMailText)).setTextColor(Color.BLACK);
            }
        }

        if (!((EditText) findViewById(R.id.passwordText)).getText().toString().equals(((EditText) findViewById(R.id.confirmPasswordText)).getText().toString()))
        {
            ((EditText) findViewById(R.id.passwordText)).setTextColor(Color.RED);
            ((EditText) findViewById(R.id.confirmPasswordText)).setTextColor(Color.RED);
        }
        else
        {
            ((EditText) findViewById(R.id.passwordText)).setTextColor(Color.BLACK);
            ((EditText) findViewById(R.id.confirmPasswordText)).setTextColor(Color.BLACK);
        }




    }

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
