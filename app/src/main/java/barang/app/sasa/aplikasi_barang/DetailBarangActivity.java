package barang.app.sasa.aplikasi_barang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import barang.app.sasa.aplikasi_barang.Model.Barang;
import barang.app.sasa.aplikasi_barang.Model.DeleteBarang;
import barang.app.sasa.aplikasi_barang.Model.Schema;
import barang.app.sasa.aplikasi_barang.Rest.ApiClient;
import barang.app.sasa.aplikasi_barang.Rest.ApiInterface;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailBarangActivity extends AppCompatActivity {
    @BindView(R.id.txtNamaBarang)
    TextView txtNamaBarang;
    @BindView(R.id.txtMerk)
    TextView txtMerk;
    @BindView(R.id.txtQty)
    TextView txtQty;
    @BindView(R.id.txtPlant)
    TextView txtPlant;
    @BindView(R.id.txtLokasi)
    TextView txtLokasi;
    @BindView(R.id.txtKeterangan)
    TextView txtKeterangan;
    @BindView(R.id.btnDelete)
    Button btnDelete;
    @BindView(R.id.btnEdit)
    Button btnEdit;
    ApiInterface apiInterface;
    String kode,namaBarang,merkBarang,keterangan,lokasi,qty,plant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_barang);
        ButterKnife.bind(this);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Intent intent = getIntent();
        kode = intent.getStringExtra("kode");
        namaBarang = intent.getStringExtra("namaBarang");
        merkBarang = intent.getStringExtra("merkBarang");
        keterangan = intent.getStringExtra("keterangan");
        lokasi = intent.getStringExtra("lokasi");
        qty = intent.getStringExtra("qty");
        plant = intent.getStringExtra("plant");

        txtNamaBarang.setText(": "+namaBarang);
        txtMerk.setText(": "+merkBarang);
        txtQty.setText(": "+qty);
        txtPlant.setText(": "+plant);
        txtLokasi.setText(": "+lokasi);
        txtKeterangan.setText(": "+keterangan);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<Schema> users = apiInterface.deleteBarang(kode);
                users.enqueue(new Callback<Schema>() {
                    @Override
                    public void onResponse(Call<Schema> call, Response<Schema> response) {
                        if (response.isSuccessful()) {

                            Toast.makeText(getApplicationContext(), "Success",
                                    Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(getApplicationContext(), "Try Again",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Schema> call, Throwable t) {
                        Log.e("TAG", "onFailure: " + t.toString());
                        t.printStackTrace();
                        Toast.makeText(getApplicationContext(), "Try Again", Toast.LENGTH_SHORT).show();
                    }

                });
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailBarangActivity.this, EditBarangActivity.class);
                intent.putExtra("kode",kode);
                intent.putExtra("namaBarang",namaBarang);
                intent.putExtra("merkBarang",merkBarang);
                intent.putExtra("lokasi",lokasi);
                intent.putExtra("keterangan",keterangan);
                intent.putExtra("plant",plant);
                intent.putExtra("qty",qty);
                DetailBarangActivity.this.startActivity(intent);
            }
        });
    }
}
