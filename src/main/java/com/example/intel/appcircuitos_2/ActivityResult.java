package com.example.intel.appcircuitos_2;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.LogPrinter;
import android.widget.TextView;

import java.util.Arrays;
import java.lang.reflect.Array;
//import org.apache.commons.lang3;

public class ActivityResult extends AppCompatActivity {
    private TextView txtResultado;
    private TextView txtResultado2;
    private TextView txtResultado3;
    private TextView txtResultado4;
    private TextView txtResultado5;
    private TextView txtResultado6;
    private TextView txtResultado7;
    private TextView txtResultado8;
    private TextView txtResultado9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_result);

        //Localizar los controles
        txtResultado = (TextView)findViewById(R.id.txtResult);
        txtResultado2 = (TextView)findViewById(R.id.txtResult2);
        txtResultado3 = (TextView)findViewById(R.id.txtResult3);
        txtResultado4 = (TextView)findViewById(R.id.txtResult4);
        txtResultado5 = (TextView)findViewById(R.id.txtResult5);
        txtResultado6 = (TextView)findViewById(R.id.txtResult6);
        txtResultado7 = (TextView)findViewById(R.id.txtResult7);
        txtResultado8 = (TextView)findViewById(R.id.txtResult8);
        txtResultado9 = (TextView)findViewById(R.id.txtResult9);

        //Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();
        Bundle bundle2 = this.getIntent().getExtras();
        Bundle bundle3 = this.getIntent().getExtras();

        //Construimos el mensaje a mostrar
        txtResultado.setText("El numero de filas es: " + bundle.getString("Filas") );
        txtResultado2.setText("El numero de columnas es: " + bundle.getString("Columnas"));
        //txtResultado3.setText("El entero es: " + bundle2.getInt("Corrientes"));

        //txtResultado3.setText("Prueba 1");
        //txtResultado3.setTextColor(Color.BLUE);

    /*    for (int i = 0; i < 5; i++) {
            Log.d("Inside the loop:"," i = " + i);
            txtResultado3.setText("Inside the loop:" + i);
        }
    */

        // Valores necesarios para definir tamaño de matrices *************************************
        int ramas=4;
        int nodos=2;

        //Matriz de ceros C ***********************************************************************
        int [][] C = new int[3][3];
        for (int i1 = 0; i1 < 3; i1++) {
            for (int j1 = 0; j1 < 3; j1++) {
                C[i1][j1] = 0;
            }
        }
        //txtResultado3.setText("Matriz");
        //txtResultado4.setText("El valor es:" + C[0][0]);
        //txtResultado5.setText("El valor es:" + C[0][1]);
        //txtResultado6.setText("El valor es:" + C[0][2]);
        //txtResultado7.setText("El valor es:" + C[0][3]);
        //txtResultado8.setText("El valor es:" + C[1][0]);
        //txtResultado9.setText("El valor es:" + C[1][3]);

        //Matriz Identidad I *********************************************************************
        int [][] I = new int[3][3];
        for (int i2 = 0; i2 < 3; i2++) {
            for (int j2 = 0; j2 < 3; j2++) {
                if (i2 == j2){
                    I[i2][j2] = 1;
                }
                else I[i2][j2] = 0;
            }
        }
        //txtResultado3.setText("Matriz");
        //txtResultado4.setText("El valor es:" + I[0][0]);
        //txtResultado5.setText("El valor es:" + I[1][1]);
        //txtResultado6.setText("El valor es:" + I[2][2]);

        //Matriz Identidad  y ceros I C  *********************************************************
        int CI [][]  = new int[3][6];
        for (int i3 = 0; i3 < 3; i3++) {
            for (int j3 = 0; j3 < 3; j3++) {
                CI[i3][j3] = C[i3][j3];
            }
        }
        for (int i3 = 0; i3 < 3; i3++) {
            for (int j3 = 3; j3 < 6; j3++) {
                CI[i3][j3] = I[i3][j3 - 3];
            }
        }

        //txtResultado3.setText("Matriz");
        //txtResultado4.setText("El valor es:" + CI[2][0]);
        //txtResultado5.setText("El valor es:" + CI[2][1]);
        //txtResultado6.setText("El valor es:" + CI[2][2]);
        //txtResultado7.setText("El valor es:" + CI[2][3]);
        //txtResultado8.setText("El valor es:" + CI[2][4]);
        //txtResultado9.setText("El valor es:" + CI[2][5]);

        //Matriz de diferentes valores ************************************************************
        int a = 5;
        //int b = bundle2.getInt("Corrientes");

        int [][] E = new int[nodos][ramas];
        for (int i4 = 0; i4 < nodos; i4++) {
            for (int j4 = 0; j4 < ramas; j4++) {
                E[i4][j4] = 3;
            }
        }
        //txtResultado4 = (TextView)findViewById(R.id.);
        //txtResultado4.setText("El valor es:" + E[0][0]);
        //txtResultado5.setText("El valor es:" + E[0][1]);
        //txtResultado6.setText("El valor es:" + E[0][2]);
        //txtResultado7.setText("El valor es:" + E[0][3]);
        //txtResultado8.setText("El valor es:" + E[1][0]);
        //txtResultado9.setText("El valor es:" + E[1][1]);


        // Determinante ***************************************************************************
        int n =4;   // para rango 3, n=2
        int m = n-1;
        //int orden = n;
        int L;
        //int [][] d = {{1,2,3},{4,5,6},{7,8,9}};
        //int [][] d = {{1,0,2},{2,3,4},{0,5,6}};
        //int [][] d = {{1,2,3},{4,5,3},{4,5,6}};
        double [][] d = {{1.0,1.0,8.0,8.0,9.0},{3.0,4.0,4.0,5.0,5.0},{6.0,6.0,7.0,7.0,8.0},{8.0,9.0,9.0,0.0,1.0},{2.0,3.0,4.0,5.0,0.0}};
        //int [][] det = new int[1][1];
        double det = 1.0;
        for (int k = 0; k <= m; k++) {
            L = k+1;
            for (int i = L; i <= n; i++) {
                for (int j = L; j <= n; j++) {
                    d[i][j] = ((d[k][k] * d[i][j]) - (d[k][j] * d[i][k])) / (d[k][k]);
                    Log.d("Inside the loop:"," i = " + j + d[i][j]);
                }
            }
            det = det * d[k+1][k+1];
            //det = det * (k+2);
        }
        txtResultado4.setText("El determinante_8 es: " + det);


        // Adjunta ********************************************************************************
        //Math.pow()
        //txtResultado4.setText("El determinante_s es: " + det);


    /*    int a = 7;
        int b = 3;
        int c = a+b;
        int [][] matriz = {{a,b,c},{4,5,6}};
        txtResultado4.setText("El resultado es: " + c);
        txtResultado5.setText("El valor es: " + matriz[0][2]);
    */

    }
}
