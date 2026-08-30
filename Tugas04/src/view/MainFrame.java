package view;

import dao.MahasiswaDao;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Mahasiswa;

public class MainFrame extends JFrame {

    private JTextField txtNpm;
    private JTextField txtNama;
    private JTextField txtProdi;
    private JTextField txtSemester;
    private JTextField txtAlamat;

    private JButton btnSimpan;
    private JButton btnUbah;
    private JButton btnHapus;
    private JButton btnReset;

    private JTable tableMahasiswa;
    private DefaultTableModel modelTable;

    private MahasiswaDao mahasiswaDao;

    public MainFrame() {

        this.setTitle("Data Mahasiswa");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        mahasiswaDao = new MahasiswaDao();

        JLabel labelJudul = new JLabel("Data Mahasiswa");
        labelJudul.setBounds(20, 20, 200, 30);

        JLabel labelNpm = new JLabel("NPM");
        labelNpm.setBounds(20, 70, 100, 25);

        txtNpm = new JTextField();
        txtNpm.setBounds(130, 70, 220, 25);

        JLabel labelNama = new JLabel("Nama");
        labelNama.setBounds(20, 110, 100, 25);

        txtNama = new JTextField();
        txtNama.setBounds(130, 110, 220, 25);

        JLabel labelProdi = new JLabel("Program Studi");
        labelProdi.setBounds(20, 150, 100, 25);

        txtProdi = new JTextField();
        txtProdi.setBounds(130, 150, 220, 25);

        JLabel labelSemester = new JLabel("Semester");
        labelSemester.setBounds(20, 190, 100, 25);

        txtSemester = new JTextField();
        txtSemester.setBounds(130, 190, 220, 25);

        JLabel labelAlamat = new JLabel("Alamat");
        labelAlamat.setBounds(20, 230, 100, 25);

        txtAlamat = new JTextField();
        txtAlamat.setBounds(130, 230, 220, 25);

        btnSimpan = new JButton("Simpan");
        btnSimpan.setBounds(20, 280, 90, 30);

        btnUbah = new JButton("Ubah");
        btnUbah.setBounds(120, 280, 90, 30);

        btnHapus = new JButton("Hapus");
        btnHapus.setBounds(220, 280, 90, 30);

        btnReset = new JButton("Reset");
        btnReset.setBounds(320, 280, 90, 30);

        MahasiswaButtonSimpanActionListener simpanActionListener =
            new MahasiswaButtonSimpanActionListener(
                this,
                mahasiswaDao
            );

        btnSimpan.addActionListener(
            simpanActionListener
        );

        MahasiswaButtonUbahActionListener ubahActionListener =
            new MahasiswaButtonUbahActionListener(
                this,
                mahasiswaDao
            );

        btnUbah.addActionListener(
            ubahActionListener
        );

        MahasiswaButtonHapusActionListener hapusActionListener =
            new MahasiswaButtonHapusActionListener(
                this,
                mahasiswaDao
            );

        btnHapus.addActionListener(
            hapusActionListener
        );

        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                resetForm();
            }
        });

        String[] namaKolom = {
            "NPM",
            "Nama",
            "Program Studi",
            "Semester",
            "Alamat"
        };

        modelTable = new DefaultTableModel(namaKolom, 0);
        tableMahasiswa = new JTable(modelTable);

        tableMahasiswa.addMouseListener(
            new java.awt.event.MouseAdapter() {

                public void mouseClicked(
                        java.awt.event.MouseEvent e) {

                    int baris =
                        tableMahasiswa.getSelectedRow();

                    txtNpm.setText(
                        modelTable.getValueAt(baris, 0).toString()
                    );

                    txtNama.setText(
                        modelTable.getValueAt(baris, 1).toString()
                    );

                    txtProdi.setText(
                        modelTable.getValueAt(baris, 2).toString()
                    );

                    txtSemester.setText(
                        modelTable.getValueAt(baris, 3).toString()
                    );

                    txtAlamat.setText(
                        modelTable.getValueAt(baris, 4).toString()
                    );
                }
            }
        );

        JScrollPane scrollTable =
            new JScrollPane(tableMahasiswa);

        scrollTable.setBounds(20, 340, 740, 200);

        this.add(labelJudul);

        this.add(labelNpm);
        this.add(txtNpm);

        this.add(labelNama);
        this.add(txtNama);

        this.add(labelProdi);
        this.add(txtProdi);

        this.add(labelSemester);
        this.add(txtSemester);

        this.add(labelAlamat);
        this.add(txtAlamat);

        this.add(btnSimpan);
        this.add(btnUbah);
        this.add(btnHapus);
        this.add(btnReset);

        this.add(scrollTable);

        loadData();

        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
    }

    private void loadData() {

        modelTable.setRowCount(0);

        List<Mahasiswa> list =
            mahasiswaDao.findAll();

        for (Mahasiswa mahasiswa : list) {

            Object[] data = {
                mahasiswa.getNpm(),
                mahasiswa.getNama(),
                mahasiswa.getProdi(),
                mahasiswa.getSemester(),
                mahasiswa.getAlamat()
            };

            modelTable.addRow(data);
        }
    }

    public String getNpm() {
    return txtNpm.getText();
    }

    public String getNama() {
        return txtNama.getText();
    }

    public String getProdi() {
        return txtProdi.getText();
    }

    public int getSemester() {
        return Integer.parseInt(
            txtSemester.getText()
        );
    }

    public String getAlamat() {
        return txtAlamat.getText();
    }

    public void addMahasiswa(Mahasiswa mahasiswa) {

        Object[] data = {
            mahasiswa.getNpm(),
            mahasiswa.getNama(),
            mahasiswa.getProdi(),
            mahasiswa.getSemester(),
            mahasiswa.getAlamat()
        };

        modelTable.addRow(data);

        txtNpm.setText("");
        txtNama.setText("");
        txtProdi.setText("");
        txtSemester.setText("");
        txtAlamat.setText("");
    }

    public void refreshData() {
    loadData();
    }

    public void resetForm() {

        txtNpm.setText("");
        txtNama.setText("");
        txtProdi.setText("");
        txtSemester.setText("");
        txtAlamat.setText("");
    }
    

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            }
        });
    }
}