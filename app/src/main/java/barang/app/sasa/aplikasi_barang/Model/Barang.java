package barang.app.sasa.aplikasi_barang.Model;

import com.google.gson.annotations.SerializedName;

public class Barang {
    @SerializedName("kode_brg")
    private String kode_brg;
    @SerializedName("nama_brg")
    private String nama_brg;
    @SerializedName("merk_brg")
    private String merk_brg;
    @SerializedName("lokasi")
    private String lokasi;
    @SerializedName("keterangan")
    private String keterangan;
    @SerializedName("qty")
    private String qty;
    @SerializedName("plant")
    private String plant;

    public Barang() {
    }

    public Barang(String kode_brg, String nama_brg, String merk_brg, String lokasi, String keterangan, String qty, String plant) {

        this.kode_brg = kode_brg;
        this.nama_brg = nama_brg;
        this.merk_brg = merk_brg;
        this.lokasi = lokasi;
        this.keterangan = keterangan;
        this.qty = qty;
        this.plant = plant;
    }

    public String getKode_brg() {

        return kode_brg;
    }

    public void setKode_brg(String kode_brg) {
        this.kode_brg = kode_brg;
    }

    public String getNama_brg() {
        return nama_brg;
    }

    public void setNama_brg(String nama_brg) {
        this.nama_brg = nama_brg;
    }

    public String getMerk_brg() {
        return merk_brg;
    }

    public void setMerk_brg(String merk_brg) {
        this.merk_brg = merk_brg;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }
}
