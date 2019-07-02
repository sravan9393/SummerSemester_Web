package com.example.icp1_login_activity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;
public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TextView lblName = findViewById(R.id.lblName);
        String username = getIntent().getStringExtra("username");
        lblName.setText("Hi " + username);
    }

    /*
     * This method will call when the user clicks on logout button. It will redirect to login page.
     */
    public void logout(View view) {
        Intent redirect = new Intent(HomeActivity.this, MainActivity.class);
        startActivity(redirect);
    }
}