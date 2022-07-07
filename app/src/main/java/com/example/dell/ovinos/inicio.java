package com.example.dell.ovinos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }
    public void sgte (View v){
        Intent intent = new Intent(inicio.this, ovinos.class);
        startActivity(intent);
    }
    public void sgte1 (View v){
        Intent intent = new Intent(inicio.this, control.class);
        startActivity(intent);
    }

}
