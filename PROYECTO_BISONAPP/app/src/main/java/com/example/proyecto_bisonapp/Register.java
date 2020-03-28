package com.example.proyecto_bisonapp;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Register extends StringRequest {
    private static final  String REGISTER_REQUEST_URL="http://192.168.1.84/Register.php";
    private Map<String, String> params;

    public Register(String nombre, String apellido, String email, String password, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("nombre",nombre);
        params.put("apellido",apellido);
        params.put("email",email);
        params.put("password",password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
