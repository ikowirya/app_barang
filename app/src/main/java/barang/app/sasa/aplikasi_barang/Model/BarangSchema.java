package barang.app.sasa.aplikasi_barang.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BarangSchema {
    @SerializedName("status")
    private String status;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private List<Barang> data;

    public BarangSchema() {
    }

    public BarangSchema(String status, String message, List<Barang> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {

        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Barang> getData() {
        return data;
    }

    public void setData(List<Barang> data) {
        this.data = data;
    }
}
