package com.umkc.lab3;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.facebook.login.LoginManager;
import com.facebook.login.widget.ProfilePictureView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        String email=getIntent().getStringExtra("email");
        String birthday = getIntent().getStringExtra("birthday");
        String id = getIntent().getStringExtra("id");
        TextView lblEmail= findViewById(R.id.lblEmail);
        TextView lblBirthDay= findViewById(R.id.lblBirthDay);

        lblEmail.setText(email);
        lblBirthDay.setText(birthday);
        ProfilePictureView profilePictureView;

        profilePictureView = (ProfilePictureView) findViewById(R.id.friendProfilePicture);

        profilePictureView.setProfileId(id);
    }

    public void logout(View view) {
        LoginManager.getInstance().logOut();
        Intent redirect = new Intent(HomeActivity.this,LoginActivity.class);
        startActivity(redirect);
    }
}
