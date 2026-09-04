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

        JLabel lblCari = new JLabel("Cari Mahasiswa");
        lblCari.setBounds(430, 280, 110, 30);
        add(lblCari);

        txtCari = new JTextField();
        txtCari.setBounds(540, 280, 220, 30);
        add(txtCari);

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