package com.rikal.tugasakhirpam;

//import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    public ImageView btnBack;
    FloatingActionButton tambah;
    AdapterPengguna adapterPengguna;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    ArrayList<ModelPengguna> listPengguna;
    RecyclerView tv_tampil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        tambah = findViewById(R.id.btn_tambah);
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this, TambahActivity.class));
            }
        });
        tv_tampil = findViewById(R.id.tv_tampil);
        RecyclerView.LayoutManager mLayout = new LinearLayoutManager(this);
        tv_tampil.setLayoutManager(mLayout);
        tv_tampil.setItemAnimator(new DefaultItemAnimator());

        tampilData();

    }

    private void tampilData() {

        database.child("Pengguna").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                if(snapshot.exists()) {

                    listPengguna = new ArrayList<>();
                    for (DataSnapshot item : snapshot.getChildren()) {
                        ModelPengguna pngguna = item.getValue(ModelPengguna.class);
                        pngguna.setKey(item.getKey());
                        listPengguna.add(pngguna);
                    }
                    adapterPengguna = new AdapterPengguna(listPengguna, ProfileActivity.this);
                    tv_tampil.setAdapter(adapterPengguna);

                    TextView view = findViewById(R.id.textView12);
                    view.setVisibility(View.GONE);

                    FloatingActionButton tombol = findViewById(R.id.btn_tambah);
                    tombol.setVisibility(View.GONE);

                } else {

                    listPengguna = new ArrayList<>();
                    for (DataSnapshot item : snapshot.getChildren()) {
                        ModelPengguna pngguna = item.getValue(ModelPengguna.class);
                        pngguna.setKey(item.getKey());
                        listPengguna.add(pngguna);
                    }
                    adapterPengguna = new AdapterPengguna(listPengguna, ProfileActivity.this);
                    tv_tampil.setAdapter(adapterPengguna);

//                    Toast.makeText(getApplicationContext(), "User Not found ", Toast.LENGTH_LONG).show();
                    TextView view = findViewById(R.id.textView12);
                    view.setVisibility(View.VISIBLE);

                    FloatingActionButton tombol = findViewById(R.id.btn_tambah);
                    tombol.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}