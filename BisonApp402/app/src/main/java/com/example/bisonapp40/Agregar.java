package com.example.bisonapp40;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Agregar extends AppCompatActivity {
    Button btnInicio, btnAgregar, btnTareas, btnProyectos, btnExamenes, btnAdd;
    EditText edTxtNombreT, edTxtActividad, edTxtMateria, edTxtDescripcion, edTxtDia, edTxtMes, edTxtAno, edTxtHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        btnInicio = findViewById(R.id.btnInicio);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnTareas = findViewById(R.id.btnTareas);
        btnProyectos = findViewById(R.id.btnProyectos);
        btnExamenes = findViewById(R.id.btnExamenes);
        btnAdd = findViewById(R.id.btnAdd);

        edTxtNombreT = findViewById(R.id.edTxtNombreT);
        edTxtActividad = findViewById(R.id.edTxtActividad);
        edTxtMateria = findViewById(R.id.edTxtMateria);
        edTxtDescripcion = findViewById(R.id.edTxtDescripcion);
        edTxtDia = findViewById(R.id.edTxtDia);
        edTxtMes = findViewById(R.id.edTxtMes);
        edTxtAno = findViewById(R.id.edTxtAno);
        edTxtHora = findViewById(R.id.edTxtHora);

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Inicio.class);
                startActivity(intent);
                finish();
            }
        });

        btnTareas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Tareas.class);
                startActivity(intent);
                finish();
            }
        });

        btnProyectos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Proyectos.class);
                startActivity(intent);
                finish();
            }
        });

        btnExamenes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Examenes.class);
                startActivity(intent);
                finish();
            }
        });

        final DBSQLite objDB = new DBSQLite(getApplicationContext());


        btnAdd.setOnClickListener(new View.OnClickListener() {
            String noControl = getIntent().getStringExtra("noControl");
            @Override
            public void onClick(View v) {
                if(edTxtNombreT.getText().toString().equals("") || edTxtActividad.getText().toString().equals("") ||
                        edTxtMateria.getText().toString().equals("") ||edTxtDescripcion.getText().toString().equals("")||
                        edTxtDia.getText().toString().equals("")||edTxtMes.getText().toString().equals("")||
                        edTxtAno.getText().toString().equals("")||edTxtHora.getText().toString().equals("")){

                    Toast.makeText(getApplicationContext(), "Faltan campos por llenar", Toast.LENGTH_SHORT).show();
                }else{
                    objDB.agregarActividad(noControl, edTxtNombreT.getText().toString(), edTxtActividad.getText().toString(),
                            edTxtMateria.getText().toString(), edTxtDescripcion.getText().toString(), edTxtDia.getText().toString(),
                            edTxtMes.getText().toString(), edTxtAno.getText().toString(), edTxtHora.getText().toString());
                    Toast.makeText(getApplicationContext(), "Se agregó correctamente", Toast.LENGTH_SHORT).show();
                }

                edTxtNombreT.setText("");
                edTxtActividad.setText("");
                edTxtMateria.setText("");
                edTxtDescripcion.setText("");
                edTxtDia.setText("");
                edTxtMes.setText("");
                edTxtAno.setText("");
                edTxtHora.setText("");

            }
        });
    }
}
