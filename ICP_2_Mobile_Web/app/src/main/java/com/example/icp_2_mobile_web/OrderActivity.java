package com.example.icp_2_mobile_web;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    public String total;
    public String orderedItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        total = getIntent().getStringExtra("total");
        orderedItems = getIntent().getStringExtra("orderedItems");
        TextView lblOrderSummary =findViewById(R.id.lblOrder);
        lblOrderSummary .setText("Total : "+total+ "\n\n Ordered Items : \n"+orderedItems );
    }

    public void pay(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        // The intent does not have a URI, so declare the "text/plain" MIME type
        emailIntent.setType("plain/text");
        // Recipients
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"PizzaOrder@gmail.com"});
        // Adding Subject
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "order Summary");
        // Adding the order Summary Text
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Total : "+total+ "\n\n Ordered Items : \n"+orderedItems);
        // Redirecting to Email Intent
        startActivity(Intent.createChooser(emailIntent, ""));
    }

}
