package barang.app.sasa.aplikasi_barang.Model;

import com.google.gson.annotations.SerializedName;

public class DeleteBarang {
    @SerializedName("kode_brg")
    private String kode_brg;

    public DeleteBarang() {
    }

    public DeleteBarang(String kode_brg) {

        this.kode_brg = kode_brg;
    }

    public String getKode_brg() {

        return kode_brg;
    }

    public void setKode_brg(String kode_brg) {
        this.kode_brg = kode_brg;
    }
}
