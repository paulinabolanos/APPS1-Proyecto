package com.example.bisonapp40;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edTxtNoControl, edTxtPassword;
    Button btnIngresar, btnRegistrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edTxtNoControl = findViewById(R.id.edTxtNoControl);
        edTxtPassword = findViewById(R.id.edTxtPassword);

        btnIngresar = findViewById(R.id.btnIngresar);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        final DBSQLite objDB = new DBSQLite(getApplicationContext());

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(objDB.login(edTxtNoControl.getText().toString(), edTxtPassword.getText().toString()) != 0){
                    Intent intent = new Intent(getApplicationContext(), Inicio.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_SHORT).show();

                    Intent intent2 = new Intent(getApplicationContext(), Agregar.class);
                    intent2.putExtra("noControl", edTxtNoControl.getText().toString());

                    edTxtNoControl.setText("");
                    edTxtPassword.setText("");
                }else{
                    Toast.makeText(getApplicationContext(), "Cree una cuenta", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Registro.class);
                startActivity(intent);
            }
        });
    }
}
