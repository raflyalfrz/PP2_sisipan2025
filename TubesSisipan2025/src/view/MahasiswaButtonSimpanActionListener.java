package view;
import dao.MahasiswaDao;
import java.awt.event.*;
import javax.swing.JOptionPane;
import model.Mahasiswa;

public class MahasiswaButtonSimpanActionListener
        implements ActionListener {

    private MainFrame mainFrame;
    private MahasiswaDao mahasiswaDao;

    public MahasiswaButtonSimpanActionListener(
            MainFrame mainFrame,
            MahasiswaDao mahasiswaDao) {

        this.mainFrame = mainFrame;
        this.mahasiswaDao = mahasiswaDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (mainFrame.isDataDipilih()) {

            JOptionPane.showMessageDialog(
                mainFrame,
                "Data sedang dipilih. Gunakan tombol Ubah untuk mengubah data atau Reset untuk menambahkan data baru."
            );

            return;
        }

        if (!mainFrame.validasiInput()) {
            return;
        }

        if (mahasiswaDao.isNpmExists(
                mainFrame.getNpm())) {

            JOptionPane.showMessageDialog(
                mainFrame,
                "NPM sudah terdaftar. Gunakan NPM lain.",
                "Peringatan",
                JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        Mahasiswa mahasiswa = new Mahasiswa();

        mahasiswa.setNpm(
            mainFrame.getNpm()
        );

        mahasiswa.setNama(
            mainFrame.getNama()
        );

        mahasiswa.setProdi(
            mainFrame.getProdi()
        );

        mahasiswa.setSemester(
            mainFrame.getSemester()
        );

        mahasiswa.setAlamat(
            mainFrame.getAlamat()
        );

        int hasil =
            mahasiswaDao.insert(mahasiswa);

        if (hasil > 0) {

            mainFrame.addMahasiswa(mahasiswa);

            JOptionPane.showMessageDialog(
                mainFrame,
                "Data mahasiswa berhasil ditambahkan."
            );

        } else {

            JOptionPane.showMessageDialog(
                mainFrame,
                "Data mahasiswa gagal ditambahkan.",
                "Gagal",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}