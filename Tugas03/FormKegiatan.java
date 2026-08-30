import javax.swing.*;

public class FormKegiatan extends JPanel {

    public FormKegiatan() {
        this.setLayout(null);

        JLabel labelJudul = new JLabel("Form Data Kegiatan");
        labelJudul.setBounds(20, 20, 200, 30);

        this.add(labelJudul);
    }
}