package barang.app.sasa.aplikasi_barang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import barang.app.sasa.aplikasi_barang.Adapter.ListBarangAdapter;
import barang.app.sasa.aplikasi_barang.Model.Barang;
import barang.app.sasa.aplikasi_barang.Model.BarangSchema;
import barang.app.sasa.aplikasi_barang.Rest.ApiClient;
import barang.app.sasa.aplikasi_barang.Rest.ApiInterface;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewBarangActivity extends AppCompatActivity {
    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;
    ApiInterface apiInterface;
    RecyclerView.LayoutManager mLayoutManager;
    ListBarangAdapter listBarangAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_barang);
        ButterKnife.bind(this);
        mLayoutManager = new LinearLayoutManager(this);
        recycler_view.setLayoutManager(mLayoutManager);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<BarangSchema> users = apiInterface.getBarang();
        users.enqueue(new Callback<BarangSchema>() {
            @Override
            public void onResponse(Call<BarangSchema> call, Response<BarangSchema> response) {
                if (response.isSuccessful()) {
                    List<Barang> barangList= response.body().getData();
                    if (barangList.size() > 0) {
                        listBarangAdapter = new ListBarangAdapter(barangList);
                        recycler_view.setAdapter(listBarangAdapter);
                    } else {
                        Toast.makeText(getApplicationContext(), "Empty Data",
                                Toast.LENGTH_SHORT).show();
                    }


                } else {
                    Toast.makeText(getApplicationContext(), "Try Again",
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BarangSchema> call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.toString());
                t.printStackTrace();
                Toast.makeText(getApplicationContext(), "Try Again", Toast.LENGTH_SHORT).show();
            }

        });
    }
}
