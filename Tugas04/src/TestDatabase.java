import dao.MahasiswaDao;
import model.Mahasiswa;

public class TestDatabase {

    public static void main(String[] args) {

        Mahasiswa mahasiswa = new Mahasiswa();

        mahasiswa.setNpm("223040001");
        mahasiswa.setNama("Budi");
        mahasiswa.setProdi("Teknik Informatika");
        mahasiswa.setSemester(5);
        mahasiswa.setAlamat("Bandung");

        MahasiswaDao mahasiswaDao = new MahasiswaDao();

        int result = mahasiswaDao.insert(mahasiswa);

        System.out.println("Hasil insert: " + result);
    }
}