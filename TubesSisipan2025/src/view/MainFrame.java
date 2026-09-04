package view;

import dao.MahasiswaDao;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Mahasiswa;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

public class MainFrame extends JFrame {

    private JTextField txtNpm;
    private JTextField txtNama;
    private JTextField txtProdi;
    private JTextField txtSemester;
    private JTextField txtAlamat;
    private JTextField txtCari;

    private JButton btnSimpan;
    private JButton btnUbah;
    private JButton btnHapus;
    private JButton btnReset;

    private JTable tableMahasiswa;
    private DefaultTableModel modelTable;
    private TableRowSorter<DefaultTableModel> rowSorter;

    private MahasiswaDao mahasiswaDao;
    private boolean dataDipilih = false;

    public MainFrame() {

        this.setTitle("Data Mahasiswa");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        this.getContentPane().setBackground(
            new java.awt.Color(245, 247, 250)
        );

        mahasiswaDao = new MahasiswaDao();

        JLabel labelJudul =
            new JLabel("DATA MAHASISWA");

        labelJudul.setBounds(
            30, 20, 300, 35
        );

        labelJudul.setFont(
            new java.awt.Font(
                "SansSerif",
                java.awt.Font.BOLD,
                22
            )
        );

        JLabel labelSubJudul =
            new JLabel(
                "Sistem Pengelolaan Data Mahasiswa"
            );

        labelSubJudul.setBounds(
            30, 52, 350, 25
        );

        labelSubJudul.setFont(
            new java.awt.Font(
                "SansSerif",
                java.awt.Font.PLAIN,
                12
            )
        );

        JLabel labelNpm = new JLabel("NPM");
        labelNpm.setBounds(30, 100, 120, 35);

        txtNpm = new JTextField();
        txtNpm.setBounds(160, 100, 300, 30);

        JLabel labelNama = new JLabel("Nama");
        labelNama.setBounds(30, 140, 120, 30);

        txtNama = new JTextField();
        txtNama.setBounds(160, 140, 300, 30);

        JLabel labelProdi = new JLabel("Program Studi");
        labelProdi.setBounds(30, 180, 120, 30);

        txtProdi = new JTextField();
        txtProdi.setBounds(160, 180, 300, 30);

        JLabel labelSemester = new JLabel("Semester");
        labelSemester.setBounds(30, 220, 120, 30);

        txtSemester = new JTextField();
        txtSemester.setBounds(160, 220, 300, 30);

        JLabel labelAlamat = new JLabel("Alamat");
        labelAlamat.setBounds(30, 260, 120, 30);

        txtAlamat = new JTextField();
        txtAlamat.setBounds(160, 260, 300, 30);

        JLabel labelDaftar =
            new JLabel("Daftar Mahasiswa");

        labelDaftar.setBounds(
            30, 385, 200, 30
        );

        labelDaftar.setFont(
            new java.awt.Font(
                "SansSerif",
                java.awt.Font.BOLD,
                16
            )
        );

        JLabel lblCari = new JLabel("Cari");
        lblCari.setBounds(530, 385, 400, 30);
        add(lblCari);

        txtCari = new JTextField();
        txtCari.setBounds(570, 385, 280, 30);
        add(txtCari);

        btnSimpan = new JButton("Simpan");
        btnSimpan.setBounds(30, 315, 100, 35);

        btnUbah = new JButton("Ubah");
        btnUbah.setBounds(140,315, 100, 35);

        btnHapus = new JButton("Hapus");
        btnHapus.setBounds(250, 315, 100, 35);

        btnReset = new JButton("Reset");
        btnReset.setBounds(360, 315, 100, 35);

        btnSimpan.setFocusPainted(false);
        btnUbah.setFocusPainted(false);
        btnHapus.setFocusPainted(false);
        btnReset.setFocusPainted(false);

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

        tableMahasiswa.setRowHeight(28);

        tableMahasiswa.getTableHeader().setFont(
            new java.awt.Font(
                "SansSerif",
                java.awt.Font.BOLD,
                12
            )
        );

        tableMahasiswa.setSelectionMode(
            ListSelectionModel.SINGLE_SELECTION
        );

        rowSorter = new TableRowSorter<>(modelTable);

        tableMahasiswa.setRowSorter(
            rowSorter
        );
        txtCari.getDocument().addDocumentListener(
            new DocumentListener() {

                @Override
                public void insertUpdate(DocumentEvent e) {
                    cariData();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    cariData();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    cariData();
                }
            }
        );

        tableMahasiswa.addMouseListener(
            new java.awt.event.MouseAdapter() {

                public void mouseClicked(
                        java.awt.event.MouseEvent e) {

                    int barisView =
                        tableMahasiswa.getSelectedRow();

                    if (barisView == -1) {
                        return;
                    }

                    int baris =
                        tableMahasiswa.convertRowIndexToModel(
                            barisView
                        );

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

                    dataDipilih = true;
                }
            }
        );

        JScrollPane scrollTable =
            new JScrollPane(tableMahasiswa);

        scrollTable.setBounds(30, 425, 820, 240);

        this.add(labelJudul);
        this.add(labelSubJudul);

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
        this.add(labelDaftar);
        this.add(scrollTable);

        loadData();

        this.setSize(900, 730);
        this.setResizable(false);
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

    public boolean isDataDipilih() {
        return dataDipilih;
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
        dataDipilih = false;
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
        dataDipilih = false;
    }

    public boolean validasiInput() {

        if (txtNpm.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "NPM tidak boleh kosong."
            );

            txtNpm.requestFocus();
            return false;
        }

        if (txtNama.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "Nama tidak boleh kosong."
            );

            txtNama.requestFocus();
            return false;
        }

        if (txtProdi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "Program Studi tidak boleh kosong."
            );

            txtProdi.requestFocus();
            return false;
        }

        if (txtSemester.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "Semester tidak boleh kosong."
            );

            txtSemester.requestFocus();
            return false;
        }

        try {
            int semester = Integer.parseInt(
                txtSemester.getText()
            );

            if (semester < 1 || semester > 14) {
                JOptionPane.showMessageDialog(
                    this,
                    "Semester harus antara 1 sampai 14."
                );

                txtSemester.requestFocus();
                return false;
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                this,
                "Semester harus berupa angka."
            );

            txtSemester.requestFocus();
            return false;
        }

        if (txtAlamat.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "Alamat tidak boleh kosong."
            );

            txtAlamat.requestFocus();
            return false;
        }

        return true;
    }

    private void cariData() {

        String kataKunci =
            txtCari.getText().trim();

        if (kataKunci.isEmpty()) {

            rowSorter.setRowFilter(null);

        } else {

            rowSorter.setRowFilter(
                RowFilter.regexFilter(
                    "(?i)" + kataKunci
                )
            );
        }
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