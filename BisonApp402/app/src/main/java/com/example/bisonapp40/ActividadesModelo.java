package com.example.bisonapp40;

public class ActividadesModelo {
    private String nombre, actividad, materia, descripcion, dia, mes, ano, hora;

    public ActividadesModelo(String nombre, String actividad, String materia, String descripcion, String dia, String mes,
                             String ano, String hora) {
        this.nombre = nombre;
        this.actividad = actividad;
        this.materia = materia;
        this.descripcion = descripcion;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.hora = hora;
    }

    public String getNombre() {
        return nombre;
    }

    public String getActividad() {
        return actividad;
    }

    public String getMateria() {
        return materia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDia() {
        return dia;
    }

    public String getMes() {
        return mes;
    }

    public String getAno() {
        return ano;
    }

    public String getHora() {
        return hora;
    }
}
