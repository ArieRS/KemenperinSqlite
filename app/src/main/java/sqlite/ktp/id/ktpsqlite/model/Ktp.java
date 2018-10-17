package sqlite.ktp.id.ktpsqlite.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Ktp implements Parcelable {
    public static final String ID = "id";
    public static final String NIK = "nik";
    public static final String NAMA = "nama";
    public static final String TANGGAL_LAHIR = "tanggalLahir";
    public static final String JENIS_KELAMIN = "jenisKelamin";

    int id;
    String nik;
    String nama;
    String tanggalLahir;
    String jenisKelamin;

    public Ktp(int id, String nik, String nama, String tanggalLahir, String jenisKelamin) {
        this.id = id;
        this.nik = nik;
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.jenisKelamin = jenisKelamin;
    }

    public Ktp() { }

    protected Ktp(Parcel in) {
        id = in.readInt();
        nik = in.readString();
        nama = in.readString();
        tanggalLahir = in.readString();
        jenisKelamin = in.readString();
    }

    public static final Creator<Ktp> CREATOR = new Creator<Ktp>() {
        @Override
        public Ktp createFromParcel(Parcel in) {
            return new Ktp(in);
        }

        @Override
        public Ktp[] newArray(int size) {
            return new Ktp[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    @Override
    public String toString() {
        return "Ktp{" +
                "id=" + id +
                ", nik='" + nik + '\'' +
                ", nama='" + nama + '\'' +
                ", tanggalLahir='" + tanggalLahir + '\'' +
                ", jenisKelamin='" + jenisKelamin + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(nik);
        parcel.writeString(nama);
        parcel.writeString(tanggalLahir);
        parcel.writeString(jenisKelamin);
    }
}
