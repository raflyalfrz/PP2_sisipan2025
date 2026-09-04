package view;

import dao.MahasiswaDao;
import java.awt.event.*;
import javax.swing.JOptionPane;
import model.Mahasiswa;

public class MahasiswaButtonHapusActionListener
        implements ActionListener {

    private MainFrame mainFrame;
    private MahasiswaDao mahasiswaDao;

    public MahasiswaButtonHapusActionListener(
            MainFrame mainFrame,
            MahasiswaDao mahasiswaDao) {

        this.mainFrame = mainFrame;
        this.mahasiswaDao = mahasiswaDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (!mainFrame.isDataDipilih()) {

            JOptionPane.showMessageDialog(
                mainFrame,
                "Pilih data mahasiswa yang akan dihapus terlebih dahulu.",
                "Peringatan",
                JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        int pilihan = JOptionPane.showConfirmDialog(
            mainFrame,
            "Apakah Anda yakin ingin menghapus data ini?",
            "Konfirmasi Hapus",
            JOptionPane.YES_NO_OPTION
        );

        if (pilihan == JOptionPane.YES_OPTION) {

            Mahasiswa mahasiswa = new Mahasiswa();

            mahasiswa.setNpm(
                mainFrame.getNpm()
            );

            mahasiswaDao.delete(mahasiswa);

            JOptionPane.showMessageDialog(
                mainFrame,
                "Data mahasiswa berhasil dihapus."
            );

            mainFrame.refreshData();
            mainFrame.resetForm();
        }
    }
}