package com.rikal.tugasakhirpam;

//import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class QuizActivity extends AppCompatActivity {

    public ImageView btnBack;
    TextView pertanyaan;
    RadioGroup rg;
    RadioButton pilihanA, pilihanB, pilihanC, pilihanD;
    int nomor = 0;
    public static int hasil, benar, salah;

    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    String[] pertanyaan_kuis = new String[]{
            "1. Memberikan representasi atau citra struktur, bentuk, dan bidang merupakan konsep..",
            "2. Garis yang dibuat secara resmi menggunakan alat gambar dan alat ukur disebut..",
            "3. Di dalam karya seni terdapat unsur yang bersifat semu maupun nyata. Dalam karya seni tiga dimensi, Anda dapat merasakan sensari merasa berada di dalamnya. Hal tersebut merupakan unsur ..",
            "4. Gothic Archs mempunyai makna..",
            "5. Kombinasi garis horizontal dan vertikal memberikan kesan..",
    };

    String[] pilihan_jawaban = new String[]{
            "a. fungsi garis","b. pengertian garis","c. jenis garis ","d. makna garis",
            "a. garis informal","b. garis formal","c. garis horizontal","d. garis diagonal",
            "a. unsur estetika","b. unsur bidang","c. unsur ruang","d. 9",
            "a. lemah gemulai dan keriangan","b. lengkung bulat mengesankan kekokohan","c. stabilitas, kekuatan, atau kemegahan","d. kepercayaan dan religius",
            "a. formal, kokoh dan tegas","b. konflik, perang, dan larangan","c. kelahiran atau generasi penerus","d. kekokohan",
    };

    String[] jawaban_benar = new String[]{
            "a. fungsi garis",
            "b. garis formal",
            "c. unsur ruang",
            "d. kepercayaan dan religius",
            "a. formal, kokoh dan tegas",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        pertanyaan = (TextView)findViewById(R.id.kuis);
        rg = (RadioGroup)findViewById(R.id.radio_group);
        pilihanA = (RadioButton) findViewById(R.id.pilihanA);
        pilihanB = (RadioButton) findViewById(R.id.pilihanB);
        pilihanC = (RadioButton) findViewById(R.id.pilihanC);
        pilihanD = (RadioButton) findViewById(R.id.pilihanD);

        pertanyaan.setText(pertanyaan_kuis[nomor]);
        pilihanA.setText(pilihan_jawaban[0]);
        pilihanB.setText(pilihan_jawaban[1]);
        pilihanC.setText(pilihan_jawaban[2]);
        pilihanD.setText(pilihan_jawaban[3]);

        rg.check(0);
        benar = 0;
        salah = 0;
    }

    public void next(View view) {


        if (pilihanA.isChecked() | pilihanB.isChecked() | pilihanC.isChecked() | pilihanD.isChecked()) {
            RadioButton jawaban_user = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban = jawaban_user.getText().toString();
            rg.check(0);
            if (ambil_jawaban.equalsIgnoreCase(jawaban_benar[nomor])) benar++;
            else salah++;
            nomor++;
            if (nomor < pertanyaan_kuis.length) {
                pertanyaan.setText(pertanyaan_kuis[nomor]);
                pilihanA.setText(pilihan_jawaban[(nomor * 4) + 0]);
                pilihanB.setText(pilihan_jawaban[(nomor * 4) + 1]);
                pilihanC.setText(pilihan_jawaban[(nomor * 4) + 2]);
                pilihanD.setText(pilihan_jawaban[(nomor * 4) + 3]);

            } else {
                hasil = benar * 20;
                Intent selesai = new Intent(getApplicationContext(), HasilKuis.class);
                startActivity(selesai);
            }
        }
        else {
            Toast.makeText(this, "Silahkan diisi dulu", Toast.LENGTH_SHORT).show();
        }
    }
}