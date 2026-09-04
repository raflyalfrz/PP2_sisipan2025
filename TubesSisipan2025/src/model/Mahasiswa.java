package model;

public class Mahasiswa {

    private String npm;
    private String nama;
    private String prodi;
    private int semester;
    private String alamat;

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNpm() {
        return npm;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public String getProdi() {
        return prodi;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getSemester() {
        return semester;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAlamat() {
        return alamat;
    }
}