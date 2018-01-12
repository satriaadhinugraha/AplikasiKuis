package com.kuisgreget.kuismenggelegar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD;
    int nomor = 0;
    public static int hasil, benar, salah;

    //Pertanyaan quiz
    String[] pertanyaan_kuis = new String[]{
            "1. Berapa kali angka 7 muncul dari angka 1 hingga 100 ?",
            "2. Sepasang suami istri mempunyai 4 anak perempuan dan setiap anak perempuan mempunyai 1 sodara laki-laki berapa jumlah anggota kelurga tersebut ?",
            "3. Mana yang lebih berat batu 1 kg atau kapas 1 kg ?",
            "4. Bila seorang bankir, memiliki 3 anak jony, sinta, ucok dan memiliki istri bernama lunamaya, siapakah nama bankir itu ?",
            "5. Bilangan 4 digit ABCD dikalikan dengan angka terakhirnya menjadi DCBA. ABCDxD = DCBA. Brapakah nilai ABCD ?"
    };

    //Pilihan Jawaban
    String[] pilihan_jawaban = new String[]{
            "30","40","50","20",
            "7","8","9","10",
            "Kapas","Batu","Beda","Sama",
            "lunamaya","bankir","Bila","istri",
            "8019","1089","9018","0819",
    };

    // Jawaban yang benar
    String[] jawaban_benar = new String[]{
            "20",
            "7",
            "Sama",
            "Bila",
            "1089",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pertanyaan = (TextView)findViewById(R.id.pertanyaan);
        rg = (RadioGroup)findViewById(R.id.radio_group);
        PilihanA = (RadioButton) findViewById(R.id.pilihanA);
        PilihanB = (RadioButton) findViewById(R.id.pilihanB);
        PilihanC = (RadioButton) findViewById(R.id.pilihanC);
        PilihanD = (RadioButton) findViewById(R.id.pilihanD);

        pertanyaan.setText(pertanyaan_kuis[nomor]);
        PilihanA.setText(pilihan_jawaban[0]);
        PilihanB.setText(pilihan_jawaban[1]);
        PilihanC.setText(pilihan_jawaban[2]);
        PilihanD.setText(pilihan_jawaban[3]);

        rg.check(0);
        benar = 0;
        salah = 0;
    }

    public void next(View view){
        if(PilihanA.isChecked()||PilihanB.isChecked()||PilihanC.isChecked()||PilihanD.isChecked()){
            RadioButton jawaban_user = (RadioButton)findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rg.check(0);
            if(ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor]))benar++;
            else salah++;
            nomor++;
            if(nomor<pertanyaan_kuis.length){
                pertanyaan.setText(pertanyaan_kuis[nomor]);
                PilihanA.setText(pilihan_jawaban[(nomor*4)+0]);
                PilihanB.setText(pilihan_jawaban[(nomor*4)+1]);
                PilihanC.setText(pilihan_jawaban[(nomor*4)+2]);
                PilihanD.setText(pilihan_jawaban[(nomor*4)+3]);
            } else{
                hasil=benar * 20;
                Intent selesai = new Intent(getApplicationContext(),HasilKuis.class);
                startActivity(selesai);
            }
        }
        else {
            Toast.makeText( this, "Pilih Jawaban dulu",Toast.LENGTH_SHORT).show();
        }
    }
}
