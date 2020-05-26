package com.example.bisonapp40;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Examenes extends AppCompatActivity {
    Button btnInicio, btnAgregar, btnTareas, btnProyectos, btnExamenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examenes);

        btnInicio = findViewById(R.id.btnInicio);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnTareas = findViewById(R.id.btnTareas);
        btnProyectos = findViewById(R.id.btnProyectos);
        btnExamenes = findViewById(R.id.btnExamenes);

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Inicio.class);
                startActivity(intent);
                finish();
            }
        });

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Agregar.class);
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


    }
}
