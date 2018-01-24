package com.example.gerardo.appcircuitosv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProcesamientoActivity extends AppCompatActivity {


    private TextView textView1;
    private TextView textView2;
    private EditText editText2;
    private TextView textView3;
    private EditText editText3;
    private TextView textView4;
    private EditText editText4;
    private Button buttonMake;

    private EditText txtNombre;
    private EditText txtNombre2;
    private EditText Corrientes;
    private Button btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procesamiento);

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
                        new Intent(ProcesamientoActivity.this, ActivityResult.class);

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
}
