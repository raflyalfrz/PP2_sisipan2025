package view;

import java.awt.event.*;
import model.Mahasiswa;
import dao.MahasiswaDao;

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

        Mahasiswa mahasiswa = new Mahasiswa();

        mahasiswa.setNpm(
            mainFrame.getNpm()
        );

        mahasiswaDao.delete(mahasiswa);

        mainFrame.refreshData();
        mainFrame.resetForm();
    }
}