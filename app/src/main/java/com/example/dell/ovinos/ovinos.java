package com.example.dell.ovinos;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class ovinos extends AppCompatActivity {
    private EditText diio,edad;
    private Spinner raza,sexo;
    private Button modificar,eliminar, guardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ovinos);

        diio = (EditText)findViewById(R.id.diio);
        edad = (EditText)findViewById(R.id.edad);
        raza = (Spinner)findViewById(R.id.raza);
        sexo = (Spinner)findViewById(R.id.sexo);
        modificar = (Button)findViewById(R.id.modificar);
        eliminar = (Button)findViewById(R.id.eliminar);
        guardar = (Button)findViewById(R.id.guardar);

        String []opciones={"Suffok","Dorset Horn","Dorper","Hampshire","Romney","Texcel","Borrego","Merino","Polypay"};
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, opciones);
        raza.setAdapter(adapter);
        String []o={"Macho","Hembra"};
        ArrayAdapter adap = new ArrayAdapter(this,android.R.layout.simple_spinner_item, o);
        sexo.setAdapter(adap);
        modificar.setEnabled(false);
        eliminar.setEnabled(false);
    }
    public void sgte (View v){
        Intent intent = new Intent(ovinos.this, inicio.class);
        startActivity(intent);
    }
    public void guardar(View v) {
        modificar.setEnabled(false);
        eliminar.setEnabled(false);

        if(diio.equals("") || edad.equals("")){
            Toast.makeText(this, "faltan datos",
                    Toast.LENGTH_SHORT).show();
        }

        else{

            String selec=raza.getSelectedItem().toString();
            String sex=sexo.getSelectedItem().toString();
            tabla admin = new tabla(this,
                    "ovinos", null, 1);
            SQLiteDatabase bd = admin.getWritableDatabase();


            String dii = diio.getText().toString();
            int numdiio = Integer.parseInt(dii);
            Cursor fila = bd.rawQuery(
                    "select diio from ovinos where diio=" + numdiio, null);
            if (fila.moveToFirst()) {
                String x = (fila.getString(0));
                bd.close();
                Toast.makeText(this, "ya existe el dato",
                        Toast.LENGTH_SHORT).show();
            }    else{


                String eda = edad.getText().toString();
                int numedad = Integer.parseInt(eda);


                ContentValues registro = new ContentValues();
                registro.put("diio", numdiio);
                registro.put("raza", selec);
                registro.put("sexo", sex);
                registro.put("edad", numedad);
                bd.insert("ovinos", null, registro);
                bd.close();
                diio.setText("");
                edad.setText("");
                Toast.makeText(this, "Se guardaron los datos",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void buscar(View v) {

        if(diio.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingrese diio",
                    Toast.LENGTH_SHORT).show();
        }else {


            tabla admin = new tabla(this,
                    "ovinos", null, 1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            String dii = diio.getText().toString();
            int numdiio = Integer.parseInt(dii);
            Cursor fila = bd.rawQuery(
                    "select sexo,raza,edad from ovinos where diio=" + numdiio, null);
            if (fila.moveToFirst()) {
                String sex = (fila.getString(0));
                String x = (fila.getString(1));
                edad.setText(fila.getString(2));
                modificar.setEnabled(true);
                eliminar.setEnabled(true);
                guardar.setEnabled(false);
                if (x.equals("Suffok")) {
                    String []opciones={"Suffok","Dorset Horn","Dorper","Hampshire","Romney","Texcel","Borrego","Merino","Polypay"};
                    ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, opciones);
                    raza.setAdapter(adapter);
                } else if (x.equals("Dorset Horn")) {
                    String []opciones={"Dorset Horn","Suffok","Dorper","Hampshire","Romney","Texcel","Borrego","Merino","Polypay"};
                    ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, opciones);
                    raza.setAdapter(adapter);
                } else if (x.equals("Dorper")) {
                    String []opciones={"Dorper","Suffok","Dorset Horn","Hampshire","Romney","Texcel","Borrego","Merino","Polypay"};
                    ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, opciones);
                    raza.setAdapter(adapter);
                } else if (x.equals("Hampshire")) {
                    String []opciones={"Hampshire","Suffok","Dorset Horn","Dorper","Romney","Texcel","Borrego","Merino","Polypay"};
                    ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, opciones);
                    raza.setAdapter(adapter);
                } else if (x.equals("Romney")) {
                    String []opciones={"Romney","Suffok","Dorset Horn","Dorper","Hampshire","Texcel","Borrego","Merino","Polypay"};
                    ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, opciones);
                    raza.setAdapter(adapter);
                } else if (x.equals("Texcel")) {
                    String []opciones={"Texcel","Suffok","Dorset Horn","Dorper","Hampshire","Romney","Borrego","Merino","Polypay"};
                    ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, opciones);
                    raza.setAdapter(adapter);
                }else if (x.equals("Borrego")) {
                    String []opciones={"Borrego","Suffok","Dorset Horn","Dorper","Hampshire","Romney","Texcel","Merino","Polypay"};
                    ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, opciones);
                    raza.setAdapter(adapter);
                }else if (x.equals("Merino")) {
                    String []opciones={"Merino","Suffok","Dorset Horn","Dorper","Hampshire","Romney","Texcel","Borrego","Polypay"};
                    ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, opciones);
                    raza.setAdapter(adapter);
                }else if (x.equals("Polypay")) {
                    String []opciones={"Polypay","Suffok","Dorset Horn","Dorper","Hampshire","Romney","Texcel","Borrego","Merino"};
                    ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, opciones);
                    raza.setAdapter(adapter);
                }
                if (sex.equals("Macho")) {
                    String []o={"Macho","Hembra"};
                    ArrayAdapter adap = new ArrayAdapter(this,android.R.layout.simple_spinner_item, o);
                    sexo.setAdapter(adap);
                } else {
                    String []o={"Hembra","Macho"};
                    ArrayAdapter adap = new ArrayAdapter(this,android.R.layout.simple_spinner_item, o);
                    sexo.setAdapter(adap);
                }


            } else
                Toast.makeText(this, "No existe ovino con dicho diio",
                        Toast.LENGTH_SHORT).show();
            bd.close();
        }

    }
    public void modificar(View v) {
        guardar.setEnabled(true);
        modificar.setEnabled(false);
        eliminar.setEnabled(false);
        String selec=raza.getSelectedItem().toString();
        String sex=sexo.getSelectedItem().toString();
        tabla admin = new tabla(this,
                "ovinos", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String dii = diio.getText().toString();
        int numdiio = Integer.parseInt(dii);



        String eda = edad.getText().toString();
        int numedad = Integer.parseInt(eda);

        ContentValues registro = new ContentValues();

        registro.put("raza", selec);
        registro.put("sexo", sex);
        registro.put("edad", numedad);
        diio.setText("");
        edad.setText("");

        int cant = bd.update("ovinos", registro, "diio=" + numdiio, null);
        bd.close();
        if (cant == 1)
            Toast.makeText(this, "se modificaron los datos", Toast.LENGTH_SHORT)
                    .show();
        else
            Toast.makeText(this, "no existe ovino con dicho diio",
                    Toast.LENGTH_SHORT).show();
    }
    public void eliminar(View v) {
        guardar.setEnabled(true);
        modificar.setEnabled(false);
        eliminar.setEnabled(false);
        tabla admin = new tabla(this,
                "ovinos", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String dii= diio.getText().toString();
        int numdii = Integer.parseInt(dii);
        int cant = bd.delete("ovinos", "diio=" + numdii, null);
        bd.close();
        diio.setText("");
        edad.setText("");
        if (cant == 1)
            Toast.makeText(this, "Se borró el registro del ovino",
                    Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe un vacuno con dicho diio",
                    Toast.LENGTH_SHORT).show();
    }
}
