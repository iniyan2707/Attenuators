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

public class Bridged extends AppCompatActivity {

    private ImageView imageView;
    private EditText r,att;
    private Button Calculate;
    private TextView TextRA,TextRB,TextRC;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bridged);
        getSupportActionBar().setTitle("Bridged T Network");


        imageView=(ImageView) findViewById(R.id.bridgedtimage);
        r=(EditText) findViewById(R.id.R1input);
        att=(EditText) findViewById(R.id.AttInput);
        Calculate= (Button) findViewById(R.id.Calc);
        TextRA= (TextView) findViewById(R.id.Ra);
        TextRB= (TextView) findViewById(R.id.Rb);
        TextRC= (TextView) findViewById(R.id.Rc);
        Glide.with(Bridged.this)
                .load(R.drawable.brt)
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
        if((r.getText().toString().length()<=0)||(att.getText().toString().length()<=0))
        {
            Toast.makeText(this,"Enter all values",Toast.LENGTH_SHORT).show();
            return;
        }
        double R= Double.parseDouble(r.getText().toString());
        double ATT= Double.parseDouble(att.getText().toString());

        double N=Math.pow(10,ATT/20);

        double Ra= R;
        double Rb= R*(N-1);
        double Rc=R/(N-1);

        TextRA.setText(String.format("Ra: %.2f ohms",Ra));
        TextRB.setText(String.format("Rb: %.2f ohms",Rb));
        TextRC.setText(String.format("Rc: %.2f ohms",Rc));
    }

}