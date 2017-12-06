package com.example.intel.appcircuitos_2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;

import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    private EditText txtNombre;
    private EditText txtNombre2;
    private EditText Corrientes;
    private Button btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencia a los controles de la interfaz
        txtNombre = (EditText)findViewById(R.id.txtNombre);
        txtNombre2 = (EditText)findViewById(R.id.txtNombre2);
        Corrientes = (EditText)findViewById(R.id.Corrientes);
        btnAceptar = (Button)findViewById(R.id.btnAceptar);


        // Evento click del botón
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent
                Intent intent =
                        new Intent(MainActivity.this, ActivityResult.class);

                //Creamos la información a pasar entre actividades
                Bundle b = new Bundle();
                b.putString("Filas", txtNombre.getText().toString());
                Bundle c = new Bundle();
                c.putString("Columnas", txtNombre2.getText().toString());
                Bundle d = new Bundle();
                //d.putInt("Corrientes",9);
                d.putString("Corrientes",Corrientes.getText().toString());

                //Añadimos la información al intent
                intent.putExtras(b);
                intent.putExtras(c);
                intent.putExtras(d);

                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });

    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */
}
