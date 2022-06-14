package com.rikal.tugasakhirpam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HasilKuis extends Activity {

//    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil_kuis);

        TextView hasil = (TextView) findViewById(R.id.hasil);
        TextView nilai = (TextView) findViewById(R.id.nilai);

        hasil.setText("Jawaban Benar : " + QuizActivity.benar+"\nJawaban Salah : "+QuizActivity.salah);
        nilai.setText(""+QuizActivity.hasil);

//        String getNilai = nilai.getText().toString();
//        database.child("Nilai").child(data.getKey()).setValue(new ModelNilai(getNilai));

    }

    public void ulangi(View view){
        finish();
        Intent i = new Intent(getApplicationContext(), QuizActivity.class);
        startActivity(i);

    }
}
