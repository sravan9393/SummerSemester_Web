package com.example.icp_2_mobile_web;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    public String orderedItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void add(View view) {
        CheckBox chkCapp = findViewById(R.id.chkCapp);
        CheckBox chkFlat = findViewById(R.id.chkFlat);
        CheckBox chkLatte = findViewById(R.id.chkLatte);
        Spinner txtCappQty= findViewById(R.id.txtCappQty);
        Spinner txtFlatQty= findViewById(R.id.txtFlatQty);
        Spinner txtLatteQty= findViewById(R.id.txtLatteQty);

        Boolean cappValue =chkCapp.isChecked();
        Boolean flatValue =chkFlat.isChecked();
        Boolean latteValue =chkLatte.isChecked();
        Integer cappQtyValue = 0;
        Integer flatQtyValue =0;
        Integer latteQtyValue=0;


            cappQtyValue = Integer.parseInt(String.valueOf(txtCappQty.getSelectedItem()));


            flatQtyValue =Integer.parseInt(String.valueOf(txtFlatQty.getSelectedItem()));


            latteQtyValue =Integer.parseInt(String.valueOf(txtLatteQty.getSelectedItem()));

        float total = calculate(cappValue,flatValue,latteValue,cappQtyValue,flatQtyValue,latteQtyValue);

        Intent redirect = new Intent(MainActivity.this, OrderActivity.class).putExtra("total",total+"").putExtra("orderedItems",orderedItems);
        startActivity(redirect);
    }

    public float calculate(Boolean cappValue,Boolean flatValue,Boolean latteValue,Integer cappQtyValue,Integer flatQtyValue,Integer latteQtyValue){
        orderedItems="";
        float total =0;
        if(cappValue){
            total = total + (5 * cappQtyValue);
            orderedItems = orderedItems+" Cheese Pizza Quantity:"+cappQtyValue ;
        }
        if(flatValue){
            total = total + (10 * flatQtyValue);
            orderedItems = orderedItems+"\n Barbeque Chicken Pizza Quantity:"+flatQtyValue;
        }
        if(latteValue){
            total = total + (20 * latteQtyValue);
            orderedItems = orderedItems+"\n Panera Onion Quantity:"+latteQtyValue;
        }
        return total;
    }


}
