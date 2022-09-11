package com.example.basicapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;
    private Button plusBtn,minusBtn;
    private TextView result;
    private int resInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dl = (DrawerLayout)findViewById(R.id.dl);
        plusBtn = (Button)findViewById(R.id.plus);
        minusBtn = (Button)findViewById(R.id.minus);
        result = (TextView)findViewById(R.id.result);
        resInt = Integer.parseInt(result.getText().toString());

        abdt = new ActionBarDrawerToggle(this,dl,R.string.Open, R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);

        dl.addDrawerListener(abdt);
        abdt.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nv = (NavigationView)findViewById(R.id.nv);

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if(id == R.id.NetworkCall){
                    Toast.makeText(MainActivity.this, "NetworkCall" , Toast.LENGTH_SHORT).show();
                }
                else if(id == R.id.Calculator){
                    Toast.makeText(MainActivity.this, "Calculator" , Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });

        // setting up click listeners for both the buttons
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resInt = resInt+1;
                 result.setText(Integer.toString(resInt));

            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(resInt > 0){
                    resInt = resInt-1;
                    result.setText(Integer.toString(resInt));
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(abdt.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);

    }
}