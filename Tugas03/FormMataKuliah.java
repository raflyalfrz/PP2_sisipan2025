import javax.swing.*;

public class FormMataKuliah extends JPanel {

    public FormMataKuliah() {
        this.setLayout(null);

        JLabel labelJudul = new JLabel("Form Data Mata Kuliah");
        labelJudul.setBounds(20, 20, 200, 30);

        this.add(labelJudul);
    }
}