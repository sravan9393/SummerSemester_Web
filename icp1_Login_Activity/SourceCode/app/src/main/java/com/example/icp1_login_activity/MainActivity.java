package com.example.icp1_login_activity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        /*
         * Login method will call when user click on login button
         */
        public void login(View v)
        {
            //Getting values from text fields controls.
            EditText txtUsername = (EditText) findViewById(R.id.txtUsername);
            EditText txtPassword = (EditText) findViewById(R.id.txtPassword);

            //Getting values from controls.
            String username = txtUsername.getText().toString();
            String password = txtPassword.getText().toString();



            //Checking the username is empty or not.
            if(username.isEmpty())
            {

            }
            //Checking the password is empty or not.
            else if(password.isEmpty())
            {

            }
            //Validating the username and password.
            else if(username.equalsIgnoreCase("admin") && password.equals("admin"))
            {
                Intent redirect = new Intent(MainActivity.this,HomeActivity.class).putExtra("username",username);
                startActivity(redirect);
            }
            else {

            }
        }
    }