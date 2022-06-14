package com.rikal.tugasakhirpam;

//import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.github.barteksc.pdfviewer.PDFView;

public class MateriActivity extends AppCompatActivity {

    public ConstraintLayout btnMateri1;
    public ConstraintLayout btnMateri2;
    public ConstraintLayout btnMateri3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);

        btnMateri1 = findViewById(R.id.btnMateri1);
        btnMateri1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MateriActivity.this, Materi1Activity.class);
                startActivity(i);
            }
        });

        btnMateri2 = findViewById(R.id.btnMateri2);
        btnMateri2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MateriActivity.this, Materi2Activity.class);
                startActivity(i);
            }
        });

        btnMateri3 = findViewById(R.id.btnMateri3);
        btnMateri3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MateriActivity.this, Materi3Activity.class);
                startActivity(i);
            }
        });

    }
}