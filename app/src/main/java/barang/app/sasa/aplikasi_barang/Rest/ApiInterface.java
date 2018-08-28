package barang.app.sasa.aplikasi_barang.Rest;

import android.database.Observable;

import barang.app.sasa.aplikasi_barang.Model.Barang;
import barang.app.sasa.aplikasi_barang.Model.BarangSchema;
import barang.app.sasa.aplikasi_barang.Model.DeleteBarang;
import barang.app.sasa.aplikasi_barang.Model.Schema;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
    @GET("c_barang")
    Call<BarangSchema> getBarang();
    @POST("c_barang")
    Call<Schema> postBarang(@Body Barang barang);
    @PUT("c_barang")
    Call<Schema> putBarang(@Body Barang barang);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "c_barang", hasBody = true)
    Call<Schema> deleteBarang(@Field("kode_brg") String kode_brg);

}
