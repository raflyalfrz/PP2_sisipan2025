package view;

import dao.MahasiswaDao;
import java.awt.event.*;
import javax.swing.JOptionPane;
import model.Mahasiswa;
public class MahasiswaButtonUbahActionListener
        implements ActionListener {

    private MainFrame mainFrame;
    private MahasiswaDao mahasiswaDao;

    public MahasiswaButtonUbahActionListener(
            MainFrame mainFrame,
            MahasiswaDao mahasiswaDao) {

        this.mainFrame = mainFrame;
        this.mahasiswaDao = mahasiswaDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!mainFrame.validasiInput()) {
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

        mahasiswaDao.update(mahasiswa);
        JOptionPane.showMessageDialog(
            mainFrame,
            "Data mahasiswa berhasil diubah."
        );

        mainFrame.refreshData();
        mainFrame.resetForm();
    }
}