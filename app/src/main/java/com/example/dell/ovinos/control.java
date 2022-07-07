package com.example.dell.ovinos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class control extends AppCompatActivity {
private EditText diio,fecha;
private Spinner medicamento;
private RadioButton rb1,rb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        diio = (EditText)findViewById(R.id.diio);
        fecha = (EditText)findViewById(R.id.fecha);
        medicamento = (Spinner)findViewById(R.id.medicamento);
        rb1 = (RadioButton)findViewById(R.id.rb1);
        rb2 = (RadioButton)findViewById(R.id.rb2);

        String []opciones={"RUMITEN","INVECTINA","INVERMIC","INVETROID","BILIFAR","CALFOMA"};
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, opciones);
        medicamento.setAdapter(adapter);

    }
}
