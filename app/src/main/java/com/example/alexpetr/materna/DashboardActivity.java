package com.example.alexpetr.materna;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);



    }

    public void goToPromo(View view)
    {
        Intent intent = new Intent(this, PromoActivity.class);
        startActivity(intent);
    }

    public void goToMaterna(View view)
    {
        Intent intent = new Intent(this, MaternaActivity.class);
        startActivity(intent);
    }

    public void goToSetari(View view)
    {
        Intent intent = new Intent (this, SetariActivity.class);
        startActivity(intent);
    }

}
