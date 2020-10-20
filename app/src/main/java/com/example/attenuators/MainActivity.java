package com.example.attenuators;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button t,pi,bridged;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t=(Button) findViewById(R.id.tnetwork);
        pi=(Button) findViewById(R.id.pi_network);
        bridged= (Button) findViewById(R.id.BridgedNetwork);

        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Tnetwork.class);
                startActivity(intent);
            }
        });

        pi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,PiNetwork.class);
                startActivity(intent);
            }
        });

        bridged.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Bridged.class);
                startActivity(intent);
            }
        });

    }
}