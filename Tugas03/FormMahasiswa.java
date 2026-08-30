import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FormMahasiswa extends JPanel {

    private JTextField txtNpm;
    private JTextField txtNama;
    private JTextArea txtAlamat;

    private JRadioButton radioLaki;
    private JRadioButton radioPerempuan;
    private ButtonGroup groupJenisKelamin;

    private JComboBox<String> comboProdi;

    private JTable tableMahasiswa;
    private DefaultTableModel modelTable;

    private JButton btnSimpan;
    private JButton btnReset;

    public FormMahasiswa() {

        this.setLayout(null);

        JLabel labelJudul = new JLabel("Form Data Mahasiswa");
        labelJudul.setBounds(20, 20, 200, 30);

        JLabel labelNpm = new JLabel("NPM");
        labelNpm.setBounds(20, 70, 120, 25);

        txtNpm = new JTextField();
        txtNpm.setBounds(150, 70, 200, 25);

        JLabel labelNama = new JLabel("Nama");
        labelNama.setBounds(20, 110, 120, 25);

        txtNama = new JTextField();
        txtNama.setBounds(150, 110, 200, 25);

        JLabel labelJenisKelamin = new JLabel("Jenis Kelamin");
        labelJenisKelamin.setBounds(20, 150, 120, 25);

        radioLaki = new JRadioButton("Laki-laki");
        radioLaki.setBounds(150, 150, 100, 25);

        radioPerempuan = new JRadioButton("Perempuan");
        radioPerempuan.setBounds(250, 150, 110, 25);

        groupJenisKelamin = new ButtonGroup();
        groupJenisKelamin.add(radioLaki);
        groupJenisKelamin.add(radioPerempuan);

        JLabel labelProdi = new JLabel("Program Studi");
        labelProdi.setBounds(20, 190, 120, 25);

        String[] daftarProdi = {
            "Teknik Informatika",
            "Teknik Industri",
            "Teknik Mesin"
        };

        comboProdi = new JComboBox<>(daftarProdi);
        comboProdi.setBounds(150, 190, 200, 25);

        JLabel labelAlamat = new JLabel("Alamat");
        labelAlamat.setBounds(20, 230, 120, 25);

        txtAlamat = new JTextArea();
        txtAlamat.setLineWrap(true);
        txtAlamat.setWrapStyleWord(true);

        JScrollPane scrollAlamat = new JScrollPane(txtAlamat);
        scrollAlamat.setBounds(150, 230, 300, 80);

        btnSimpan = new JButton("Simpan");
        btnSimpan.setBounds(150, 330, 100, 30);

        btnReset = new JButton("Reset");
        btnReset.setBounds(260, 330, 100, 30);

        String[] namaKolom = {
            "NPM",
            "Nama",
            "Jenis Kelamin",
            "Program Studi",
            "Alamat"
        };

        modelTable = new DefaultTableModel(namaKolom, 0);

        tableMahasiswa = new JTable(modelTable);

        JScrollPane scrollTable = new JScrollPane(tableMahasiswa);
        scrollTable.setBounds(20, 390, 740, 170);

        btnSimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String npm = txtNpm.getText();
                String nama = txtNama.getText();
                String alamat = txtAlamat.getText();

                String jenisKelamin = "";

                if (radioLaki.isSelected()) {
                    jenisKelamin = "Laki-laki";
                } else if (radioPerempuan.isSelected()) {
                    jenisKelamin = "Perempuan";
                }

                String prodi =
                    (String) comboProdi.getSelectedItem();

                Object[] dataMahasiswa = {
                    npm,
                    nama,
                    jenisKelamin,
                    prodi,
                    alamat
                };

                modelTable.addRow(dataMahasiswa);
            }
        });

        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                txtNpm.setText("");
                txtNama.setText("");
                txtAlamat.setText("");

                groupJenisKelamin.clearSelection();

                comboProdi.setSelectedIndex(0);
            }
        });

        this.add(labelJudul);

        this.add(labelNpm);
        this.add(txtNpm);

        this.add(labelNama);
        this.add(txtNama);

        this.add(labelJenisKelamin);
        this.add(radioLaki);
        this.add(radioPerempuan);

        this.add(labelProdi);
        this.add(comboProdi);

        this.add(labelAlamat);
        this.add(scrollAlamat);

        this.add(btnSimpan);
        this.add(btnReset);

        this.add(scrollTable);
    }
}