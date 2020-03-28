package com.example.proyecto_bisonapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

public class Inicio extends AppCompatActivity {
    private TabLayout TabLayout;
    private ViewPager VwPager;
    ImageView imgVwBackI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        TabLayout = findViewById(R.id.TabLayout);
        VwPager = findViewById(R.id.VwPager);
        imgVwBackI = findViewById(R.id.imgVwBackI);

        TabLayout.setupWithViewPager(VwPager);
        setUpWithViewPager(VwPager);

        imgVwBackI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void setUpWithViewPager (ViewPager VwPager){
        TabViewPagerAdapter tabViewPagerAdapter = new TabViewPagerAdapter(getSupportFragmentManager());
        tabViewPagerAdapter.addFrag(new Horario(), "HORARIO");
        tabViewPagerAdapter.addFrag(new Tareas(), "TAREAS");
        tabViewPagerAdapter.addFrag(new Proyectos(), "PROYECTOS");
        tabViewPagerAdapter.addFrag(new Examenes(), "EXAMENES");
        VwPager.setAdapter(tabViewPagerAdapter);
    }
}
