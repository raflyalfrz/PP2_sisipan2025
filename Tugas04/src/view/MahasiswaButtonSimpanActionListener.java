package view;

import java.awt.event.*;
import model.Mahasiswa;
import dao.MahasiswaDao;

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

        mahasiswaDao.insert(mahasiswa);

        mainFrame.addMahasiswa(mahasiswa);
    }
}