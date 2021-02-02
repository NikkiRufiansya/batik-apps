package com.codetalenta.batikindonesia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView, recyclerViewAll;
    private List<BatikModels> batikModels = new ArrayList<>();
    private List<BatikModels> batikModelsAll = new ArrayList<>();
    private BatikAdapterPopular batikAdapterPopular;
    private BatikAllAdapter batikAllAdapter;
    private LinearLayoutManager linearLayoutManager;
    private BatikService batikService = UrlApi.getBatikService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getAll();
        getDataPopuler();

    }

    private void getDataPopuler() {
        recyclerView = findViewById(R.id.batikPopuler);
        batikService.getPopular().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String respon = response.body().string();
                    JSONObject hasil = new JSONObject(respon);
                    JSONArray data = hasil.getJSONArray("hasil");
                    for (int i = 0; i < data.length(); i++) {
                        JSONObject batik = data.getJSONObject(i);
                        batikModels.add(new BatikModels(
                                batik.getString("nama_batik"),
                                batik.getString("daerah_batik"),
                                batik.getString("makna_batik"),
                                batik.getString("harga_tinggi"),
                                batik.getString("harga_rendah"),
                                batik.getString("link_batik")));
                    }
                    batikAdapterPopular = new BatikAdapterPopular(MainActivity.this, batikModels);
                    linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(batikAdapterPopular);
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void getAll() {
        recyclerViewAll = findViewById(R.id.allBatik);
        batikService.getAll().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String respon = response.body().string();
                    JSONObject hasil = new JSONObject(respon);
                    JSONArray data = hasil.getJSONArray("hasil");
                    for (int i = 0; i < data.length(); i++) {
                        JSONObject batik = data.getJSONObject(i);
                        batikModelsAll.add(new BatikModels(
                                batik.getString("nama_batik"),
                                batik.getString("daerah_batik"),
                                batik.getString("makna_batik"),
                                batik.getString("harga_tinggi"),
                                batik.getString("harga_rendah"),
                                batik.getString("link_batik")));
                    }
                    batikAllAdapter = new BatikAllAdapter(MainActivity.this, batikModelsAll);
                    recyclerViewAll.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
                    recyclerViewAll.setAdapter(batikAllAdapter);
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }


}