package com.example.attenuators;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class PiNetwork extends AppCompatActivity {

    private ImageView imageView;
    private EditText r1,r2,att;
    private Button Calculate;
    private TextView TextRA,TextRB,TextRC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pi_network);
        getSupportActionBar().setTitle("Pi Network");


        imageView=(ImageView) findViewById(R.id.piimage);
        r1=(EditText) findViewById(R.id.R1input);
        r2=(EditText) findViewById(R.id.R2Input);
        att=(EditText) findViewById(R.id.AttInput);
        Calculate= (Button) findViewById(R.id.Calc);
        TextRA= (TextView) findViewById(R.id.Ra);
        TextRB= (TextView) findViewById(R.id.Rb);
        TextRC= (TextView) findViewById(R.id.Rc);
        Glide.with(PiNetwork.this)
                .load(R.drawable.pi)
                .into(imageView);

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                att.onEditorAction(EditorInfo.IME_ACTION_DONE);
                calculate();
            }
        });

    }

    private void calculate()
    {
        if((r1.getText().toString().length()<=0)||(r2.getText().toString().length()<=0)||(att.getText().toString().length()<=0))
        {
            Toast.makeText(this,"Enter all values",Toast.LENGTH_SHORT).show();
            return;
        }
        double R1= Double.parseDouble(r1.getText().toString());
        double R2= Double.parseDouble(r2.getText().toString());
        double ATT= Double.parseDouble(att.getText().toString());

        double N=Math.pow(10,ATT/20);
        double S=Math.sqrt(R1/R2);

        double Ra= (R1*(N*N-1)/(N*N-2*N*S+1));
        double Rb=(0.5*Math.sqrt(R1*R2)*(N*N-1)/(N));
        double Rc=(R2*(N*N-1)/(N*N-(2*N/S)+1));

        TextRA.setText(String.format("Ra: %.2f ohms",Ra));
        TextRB.setText(String.format("Rb: %.2f ohms",Rb));
        TextRC.setText(String.format("Rc: %.2f ohms",Rc));


    }

}