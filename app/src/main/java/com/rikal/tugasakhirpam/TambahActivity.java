package com.rikal.tugasakhirpam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TambahActivity extends AppCompatActivity {

    EditText edNama, edKelas, edNilai;
    Button edButton;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        edNama = findViewById(R.id.edNama);
        edKelas = findViewById(R.id.edKelas);
        edButton = findViewById(R.id.btnSimpan);

        edButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getNama = edNama.getText().toString();
                String getKelas = edKelas.getText().toString();

                if (getNama.isEmpty()){
                    edNama.setError("Masukkan Nama");
                } else if (getKelas.isEmpty()){
                    edKelas.setError("Masukkan Kelas");
                } else {
                    database.child("Pengguna").push().setValue(new ModelPengguna(getNama,getKelas)).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(TambahActivity.this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(TambahActivity.this, ProfileActivity.class));
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(TambahActivity.this, "Gagal Menyimpan Data", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}