import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FormMataKuliah extends JPanel {

    private JTextField txtKode;
    private JTextField txtNama;

    private JSpinner spinnerSemester;
    private JSlider sliderKesulitan;

    private JButton btnSimpan;
    private JButton btnReset;

    private JTable tableMataKuliah;
    private DefaultTableModel modelTable;

    public FormMataKuliah() {

        this.setLayout(null);

        JLabel labelJudul = new JLabel("Form Data Mata Kuliah");
        labelJudul.setBounds(20, 20, 200, 30);

        JLabel labelKode = new JLabel("Kode Mata Kuliah");
        labelKode.setBounds(20, 70, 120, 25);

        txtKode = new JTextField();
        txtKode.setBounds(150, 70, 200, 25);

        JLabel labelNama = new JLabel("Nama Mata Kuliah");
        labelNama.setBounds(20, 110, 120, 25);

        txtNama = new JTextField();
        txtNama.setBounds(150, 110, 200, 25);

        JLabel labelSemester = new JLabel("Semester");
        labelSemester.setBounds(20, 150, 120, 25);

        SpinnerNumberModel modelSemester =
            new SpinnerNumberModel(1, 1, 8, 1);

        spinnerSemester = new JSpinner(modelSemester);
        spinnerSemester.setBounds(150, 150, 80, 25);

        JLabel labelKesulitan = new JLabel("Tingkat Kesulitan");
        labelKesulitan.setBounds(20, 190, 120, 25);

        sliderKesulitan = new JSlider(1, 10, 5);
        sliderKesulitan.setBounds(150, 180, 300, 60);

        sliderKesulitan.setMajorTickSpacing(1);
        sliderKesulitan.setPaintTicks(true);
        sliderKesulitan.setPaintLabels(true);

        btnSimpan = new JButton("Simpan");
        btnSimpan.setBounds(150, 260, 100, 30);

        btnReset = new JButton("Reset");
        btnReset.setBounds(260, 260, 100, 30);

        String[] namaKolom = {
            "Kode",
            "Nama Mata Kuliah",
            "Semester",
            "Tingkat Kesulitan"
        };

        modelTable = new DefaultTableModel(namaKolom, 0);

        tableMataKuliah = new JTable(modelTable);

        JScrollPane scrollTable = new JScrollPane(tableMataKuliah);
        scrollTable.setBounds(20, 320, 740, 220);

        btnSimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String kode = txtKode.getText();
                String nama = txtNama.getText();

                int semester =
                    (Integer) spinnerSemester.getValue();

                int kesulitan =
                    sliderKesulitan.getValue();

                Object[] dataMataKuliah = {
                    kode,
                    nama,
                    semester,
                    kesulitan
                };

                modelTable.addRow(dataMataKuliah);
            }
        });

        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                txtKode.setText("");
                txtNama.setText("");

                spinnerSemester.setValue(1);
                sliderKesulitan.setValue(5);
            }
        });

        this.add(labelJudul);

        this.add(labelKode);
        this.add(txtKode);

        this.add(labelNama);
        this.add(txtNama);

        this.add(labelSemester);
        this.add(spinnerSemester);

        this.add(labelKesulitan);
        this.add(sliderKesulitan);

        this.add(btnSimpan);
        this.add(btnReset);

        this.add(scrollTable);
    }
}