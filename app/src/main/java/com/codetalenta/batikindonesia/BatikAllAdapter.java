package com.codetalenta.batikindonesia;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BatikAllAdapter extends RecyclerView.Adapter<BatikAllAdapter.MyView> {

    private Context context;
    private List<BatikModels> data;

    public BatikAllAdapter(Context context, List<BatikModels> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public BatikAllAdapter.MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_all,parent, false);
        return new MyView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BatikAllAdapter.MyView holder, int position) {
        holder.namaBatik.setText(data.get(position).getNama());
        Picasso.get().load(data.get(position).getGambar()).into(holder.gambar);
        holder.gambar.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailBatik.class);
            intent.putExtra("nama", data.get(position).getNama());
            intent.putExtra("makna", data.get(position).getMakna());
            intent.putExtra("gambar", data.get(position).getGambar());
            intent.putExtra("daerah", data.get(position).getDaerah());
            intent.putExtra("hargaTinggi", data.get(position).getHargaTertinggi());
            intent.putExtra("hargaRendah", data.get(position).getHargaTerendah());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyView extends RecyclerView.ViewHolder {
        RoundedImageView gambar;
        TextView namaBatik;
        public MyView(@NonNull View itemView) {
            super(itemView);
            gambar = itemView.findViewById(R.id.gambarAll);
            namaBatik = itemView.findViewById(R.id.namaBatik);
        }
    }
}
