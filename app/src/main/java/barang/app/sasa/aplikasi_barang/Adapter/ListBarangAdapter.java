package barang.app.sasa.aplikasi_barang.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import barang.app.sasa.aplikasi_barang.DetailBarangActivity;
import barang.app.sasa.aplikasi_barang.Model.Barang;
import barang.app.sasa.aplikasi_barang.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ListBarangAdapter extends RecyclerView.Adapter<ListBarangAdapter.ListBarangViewHolder>{
    List <Barang> barangList;

    public ListBarangAdapter(List<Barang> barangList) {
        this.barangList = barangList;
    }

    @Override
    public ListBarangViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_barang,parent,false);
        return new ListBarangAdapter.ListBarangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListBarangViewHolder holder, int position) {
        final Context context = holder.itemView.getContext();
        holder.txtNamaBarang.setText(barangList.get(position).getNama_brg());

        final String kode = barangList.get(position).getKode_brg();
        final String namaBarang = barangList.get(position).getNama_brg();
        final String merkBarang  = barangList.get(position).getMerk_brg();
        final String lokasi  = barangList.get(position).getLokasi();
        final String keterangan = barangList.get(position).getKeterangan();
        final String plant = barangList.get(position).getPlant();
        final String qty  = barangList.get(position).getQty();

        holder.txtNamaBarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailBarangActivity.class);
                intent.putExtra("kode",kode);
                intent.putExtra("namaBarang",namaBarang);
                intent.putExtra("merkBarang",merkBarang);
                intent.putExtra("lokasi",lokasi);
                intent.putExtra("keterangan",keterangan);
                intent.putExtra("plant",plant);
                intent.putExtra("qty",qty);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return barangList.size();
    }

    public class ListBarangViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtNamaBarang)
        TextView txtNamaBarang;
        public ListBarangViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
