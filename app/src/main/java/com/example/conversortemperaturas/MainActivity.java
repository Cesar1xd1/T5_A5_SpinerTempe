package com.example.conversortemperaturas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText entrada;
    TextView salida;
    Spinner spEntrada,spSalida;
    String[]  opciones = {"Centigrados","Fahreinheit","Rankine","Kelvin"};
    int x = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entrada = findViewById(R.id.etEntrada);
        salida = findViewById(R.id.tvSalida);
        spEntrada = findViewById(R.id.spEntrada);
        spEntrada.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones));

        spSalida = findViewById(R.id.spSalida);
        spSalida.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones));
        DecimalFormat df = new DecimalFormat("#.00");

        spEntrada.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id){
                //Toast.makeText(adapterView.getContext(), (String) spEntrada.getSelectedItem(), Toast.LENGTH_SHORT).show();
                if(spEntrada.getSelectedItem().equals("Centigrados")){
                    x = 1;
                }else if(spEntrada.getSelectedItem().equals("Fahreinheit")){
                    x = 2;
                }else if(spEntrada.getSelectedItem().equals("Rankine")){
                    x = 3;
                }else if(spEntrada.getSelectedItem().equals("Kelvin")){
                    x = 4;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                //vacio

            }
        });

        spSalida.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                double input = 0;
                if(entrada.getText().toString().equals("")){
                    input = 0;
                }else{
                    input = Double.parseDouble(entrada.getText().toString());
                }

                double res = 0;


                //Toast.makeText(adapterView.getContext(), (String) spEntrada.getSelectedItem(), Toast.LENGTH_SHORT).show();
                if(x==1){
                    if(spSalida.getSelectedItem().equals("Centigrados")){
                            salida.setText(entrada.getText().toString());
                    }else if(spSalida.getSelectedItem().equals("Fahreinheit")){
                        res = (1.8)*(input)+32;
                        String f = df.format(res);
                        salida.setText(f);
                    }else if(spSalida.getSelectedItem().equals("Rankine")){
                        res = (1.8)*(input) + 491.67;
                        String f = df.format(res);
                        salida.setText(f);
                    }else if(spSalida.getSelectedItem().equals("Kelvin")){
                        res = input + 273.15;
                        String f = df.format(res);
                        salida.setText(f);
                    }

                }else if(x==2){
                    if(spSalida.getSelectedItem().equals("Centigrados")){
                        res = (input-32) * (5/9);
                        String f = df.format(res);
                        salida.setText(f);
                    }else if(spSalida.getSelectedItem().equals("Fahreinheit")){
                        salida.setText(entrada.getText().toString());
                    }else if(spSalida.getSelectedItem().equals("Rankine")){
                        res = (input) + 459.67;
                        String f = df.format(res);
                        salida.setText(f);
                    }else if(spSalida.getSelectedItem().equals("Kelvin")){
                        res = (input -32)*(5/9) + 273.15;
                        String f = df.format(res);
                        salida.setText(f);
                    }
                }else if (x == 3){
                    if(spSalida.getSelectedItem().equals("Centigrados")){
                        res = (input-491.67) * (5/9);
                        String f = df.format(res);
                        salida.setText(f);
                    }else if(spSalida.getSelectedItem().equals("Fahreinheit")){
                        res = input-459.67;
                        String f = df.format(res);
                        salida.setText(f);
                    }else if(spSalida.getSelectedItem().equals("Rankine")){
                        salida.setText(entrada.getText().toString());
                    }else if(spSalida.getSelectedItem().equals("Kelvin")){
                        res = (input)*(5/9);
                        String f = df.format(res);
                        salida.setText(f);
                    }

                }else if(x==4){
                    if(spSalida.getSelectedItem().equals("Centigrados")){
                        res = (input-273.15);
                        String f = df.format(res);
                        salida.setText(f);
                    }else if(spSalida.getSelectedItem().equals("Fahreinheit")){
                        res = (input-273.15)*(1.8)+32;
                        String f = df.format(res);
                        salida.setText(f);
                    }else if(spSalida.getSelectedItem().equals("Rankine")){
                        res = (input-273.15)* (1.8)+ 491.67;
                        String f = df.format(res);
                        salida.setText(f);
                    }else if(spSalida.getSelectedItem().equals("Kelvin")){
                        salida.setText(entrada.getText().toString());
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                //vacio

            }
        });


    }


}