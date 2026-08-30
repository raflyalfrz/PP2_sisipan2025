import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FormKegiatan extends JPanel {

    private JTextField txtNamaKegiatan;

    private JCheckBox checkOrganisasi;
    private JCheckBox checkOlahraga;
    private JCheckBox checkSeni;

    private JList<String> listKeahlian;

    private JButton btnSimpan;
    private JButton btnReset;

    private JTable tableKegiatan;
    private DefaultTableModel modelTable;

    public FormKegiatan() {

        this.setLayout(null);

        JLabel labelJudul = new JLabel("Form Data Kegiatan");
        labelJudul.setBounds(20, 20, 200, 30);

        JLabel labelNama = new JLabel("Nama Kegiatan");
        labelNama.setBounds(20, 70, 120, 25);

        txtNamaKegiatan = new JTextField();
        txtNamaKegiatan.setBounds(150, 70, 200, 25);

        JLabel labelJenis = new JLabel("Jenis Kegiatan");
        labelJenis.setBounds(20, 110, 120, 25);

        checkOrganisasi = new JCheckBox("Organisasi");
        checkOrganisasi.setBounds(150, 110, 100, 25);

        checkOlahraga = new JCheckBox("Olahraga");
        checkOlahraga.setBounds(250, 110, 100, 25);

        checkSeni = new JCheckBox("Seni");
        checkSeni.setBounds(350, 110, 80, 25);

        JLabel labelKeahlian = new JLabel("Keahlian");
        labelKeahlian.setBounds(20, 160, 120, 25);

        String[] daftarKeahlian = {
            "Desain",
            "Programming",
            "Public Speaking",
            "Networking"
        };

        listKeahlian = new JList<>(daftarKeahlian);
        listKeahlian.setSelectionMode(
            ListSelectionModel.SINGLE_SELECTION
        );

        JScrollPane scrollKeahlian =
            new JScrollPane(listKeahlian);

        scrollKeahlian.setBounds(150, 160, 200, 90);

        btnSimpan = new JButton("Simpan");
        btnSimpan.setBounds(150, 270, 100, 30);

        btnReset = new JButton("Reset");
        btnReset.setBounds(260, 270, 100, 30);

        String[] namaKolom = {
            "Nama Kegiatan",
            "Jenis Kegiatan",
            "Keahlian"
        };

        modelTable = new DefaultTableModel(namaKolom, 0);

        tableKegiatan = new JTable(modelTable);

        JScrollPane scrollTable =
            new JScrollPane(tableKegiatan);

        scrollTable.setBounds(20, 330, 740, 210);

        btnSimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String nama =
                    txtNamaKegiatan.getText();

                String jenis = "";

                if (checkOrganisasi.isSelected()) {
                    jenis += "Organisasi ";
                }

                if (checkOlahraga.isSelected()) {
                    jenis += "Olahraga ";
                }

                if (checkSeni.isSelected()) {
                    jenis += "Seni ";
                }

                String keahlian =
                    listKeahlian.getSelectedValue();

                Object[] dataKegiatan = {
                    nama,
                    jenis,
                    keahlian
                };

                modelTable.addRow(dataKegiatan);
            }
        });

        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                txtNamaKegiatan.setText("");

                checkOrganisasi.setSelected(false);
                checkOlahraga.setSelected(false);
                checkSeni.setSelected(false);

                listKeahlian.clearSelection();
            }
        });

        this.add(labelJudul);

        this.add(labelNama);
        this.add(txtNamaKegiatan);

        this.add(labelJenis);
        this.add(checkOrganisasi);
        this.add(checkOlahraga);
        this.add(checkSeni);

        this.add(labelKeahlian);
        this.add(scrollKeahlian);

        this.add(btnSimpan);
        this.add(btnReset);

        this.add(scrollTable);
    }
}