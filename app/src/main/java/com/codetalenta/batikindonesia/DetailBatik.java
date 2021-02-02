package com.codetalenta.batikindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

public class DetailBatik extends AppCompatActivity {
    private ImageView btnBack;
    private TextView judulBatik, maknaBatik, daerahBatik, hargaBatik;
    private RoundedImageView gambarBatik;
    private String judul, makna, daerah, hargaTinggi, hargaRendah, gambar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_batik);
        init();
        getData();
    }

    private void init(){
        btnBack = findViewById(R.id.btnBack);
        judulBatik = findViewById(R.id.judulBatik);
        maknaBatik = findViewById(R.id.maknaBatik);
        daerahBatik = findViewById(R.id.daerahBatik);
        hargaBatik = findViewById(R.id.hargaBatik);
        gambarBatik = findViewById(R.id.gambar);
    }

    private void getData(){
        judul = getIntent().getStringExtra("nama");
        makna = getIntent().getStringExtra("makna");
        gambar = getIntent().getStringExtra("gambar");
        daerah = getIntent().getStringExtra("daerah");
        hargaTinggi = getIntent().getStringExtra("hargaTinggi");
        hargaRendah = getIntent().getStringExtra("hargaRendah");
        judulBatik.setText(judul);
        maknaBatik.setText(makna);
        daerahBatik.setText("Asal : "+daerah);
        hargaBatik.setText("Harga : " + "Rp "+hargaRendah +" - "+"Rp "+hargaTinggi);
        Picasso.get().load(gambar).into(gambarBatik);
        btnBack.setOnClickListener(v -> {
            onBackPressed();
        });
    }
}