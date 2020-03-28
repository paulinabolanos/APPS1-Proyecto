package com.example.proyecto_bisonapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Registro extends AppCompatActivity {
    ImageView imgVwBackR;
    Button btnRegis;
    EditText edTxtName, edTxtLastName, edTxtEmail, edTxtPass;
    //edTxtPassConf

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        imgVwBackR = findViewById(R.id.imgVwBackR);
        btnRegis = findViewById(R.id.btnRegis);
        edTxtName = findViewById(R.id.edTxtName);
        edTxtLastName = findViewById(R.id.edTxtLastName);
        edTxtEmail = findViewById(R.id.edTxtEmail);
        edTxtPass = findViewById(R.id.edTxtPass);
        //edTxtPassConf = findViewById(R.id.edTxtPassConf);

        imgVwBackR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nombre = edTxtName.getText().toString();
                final String apellido = edTxtLastName.getText().toString();
                final String email = edTxtEmail.getText().toString();
                final String password = edTxtPass.getText().toString();
                Response.Listener<String> respoListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success){
                                Intent intRegis = new Intent(Registro.this, MainActivity.class);
                                Registro.this.startActivity(intRegis);
                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(Registro.this);
                                builder.setMessage("error registro").setNegativeButton("Retry", null).create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                Register objRegis = new Register(nombre, apellido, email, password, respoListener);
                RequestQueue queue = Volley.newRequestQueue(Registro.this);
                queue.add(objRegis);
            }
        });


    }


}
