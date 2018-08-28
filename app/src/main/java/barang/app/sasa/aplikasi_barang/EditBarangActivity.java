package barang.app.sasa.aplikasi_barang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import barang.app.sasa.aplikasi_barang.Model.Barang;
import barang.app.sasa.aplikasi_barang.Model.Schema;
import barang.app.sasa.aplikasi_barang.Rest.ApiClient;
import barang.app.sasa.aplikasi_barang.Rest.ApiInterface;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditBarangActivity extends AppCompatActivity {
    @BindView(R.id.btnEdit)
    Button btnEdit;
    @BindView(R.id.txtKode)
    EditText txtKode;
    @BindView(R.id.txtNamaBarang)
    EditText txtNamaBarang;
    @BindView(R.id.txtMerk)
    EditText txtMerk;
    @BindView(R.id.txtQty)
    EditText txtQty;
    @BindView(R.id.txtPlant)
    EditText txtPlant;
    @BindView(R.id.txtLokasi)
    EditText txtLokasi;
    @BindView(R.id.txtKeterangan)
    EditText txtKeterangan;
    ApiInterface apiInterface;
    String kode,namaBarang,merkBarang,keterangan,lokasi,qty,plant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_barang);
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

        txtKode.setEnabled(false);
        txtKode.setText(kode);
        txtNamaBarang.setText(namaBarang);
        txtMerk.setText(merkBarang);
        txtKeterangan.setText(lokasi);
        txtLokasi.setText(lokasi);
        txtQty.setText(qty);
        txtPlant.setText(plant);


        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kode = txtKode.getText().toString();
                namaBarang = txtNamaBarang.getText().toString();
                merkBarang = txtMerk.getText().toString();
                qty = txtQty.getText().toString();
                plant = txtPlant.getText().toString();
                lokasi = txtLokasi.getText().toString();
                keterangan = txtKeterangan.getText().toString();
                Barang barang = new Barang(kode,namaBarang,merkBarang,lokasi,keterangan,qty,plant);
                Call<Schema> users = apiInterface.putBarang(barang);
                users.enqueue(new Callback<Schema>() {
                    @Override
                    public void onResponse(Call<Schema> call, Response<Schema> response) {
                        if (response.isSuccessful()) {
                            startActivity(new Intent(EditBarangActivity.this,MainActivity.class));
                            Toast.makeText(getApplicationContext(), "Success",
                                    Toast.LENGTH_SHORT).show();
                            finish();

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
    }
}
