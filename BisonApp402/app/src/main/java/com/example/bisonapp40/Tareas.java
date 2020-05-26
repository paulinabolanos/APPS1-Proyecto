package com.example.bisonapp40;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tareas extends AppCompatActivity {
    Button btnInicio, btnAgregar, btnTareas, btnProyectos, btnExamenes;
    private RecyclerView recVwTareas;
    private ActividadesAdaptador actividadesAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tareas);

        btnInicio = findViewById(R.id.btnInicio);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnTareas = findViewById(R.id.btnTareas);
        btnProyectos = findViewById(R.id.btnProyectos);
        btnExamenes = findViewById(R.id.btnExamenes);

        recVwTareas = findViewById(R.id.recVwTareas);
        recVwTareas.setLayoutManager(new LinearLayoutManager(this));

        DBSQLite db = new DBSQLite(getApplicationContext());

        actividadesAdaptador = new ActividadesAdaptador(db.mostrarActividades());
        recVwTareas.setAdapter(actividadesAdaptador);

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
    }
}
