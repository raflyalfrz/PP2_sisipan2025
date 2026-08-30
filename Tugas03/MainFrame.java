import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel panelUtama;

    public MainFrame() {

        this.setTitle("Aplikasi Data Mahasiswa");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        panelUtama = new JPanel(cardLayout);

        JPanel panelHome = new JPanel();
        panelHome.setLayout(null);

        JLabel labelJudul = new JLabel("Aplikasi Data Mahasiswa");
        labelJudul.setBounds(270, 200, 250, 30);

        panelHome.add(labelJudul);

        FormMahasiswa formMahasiswa = new FormMahasiswa();
        FormMataKuliah formMataKuliah = new FormMataKuliah();
        FormKegiatan formKegiatan = new FormKegiatan();

        panelUtama.add(panelHome, "Home");
        panelUtama.add(formMahasiswa, "Mahasiswa");
        panelUtama.add(formMataKuliah, "MataKuliah");
        panelUtama.add(formKegiatan, "Kegiatan");

        JMenuBar menuBar = new JMenuBar();

        JMenu menuData = new JMenu("Data");

        JMenuItem menuHome = new JMenuItem("Home");
        JMenuItem menuMahasiswa = new JMenuItem("Data Mahasiswa");
        JMenuItem menuMataKuliah = new JMenuItem("Data Mata Kuliah");
        JMenuItem menuKegiatan = new JMenuItem("Data Kegiatan");
        JMenuItem menuExit = new JMenuItem("Exit");

        menuData.add(menuHome);
        menuData.add(menuMahasiswa);
        menuData.add(menuMataKuliah);
        menuData.add(menuKegiatan);
        menuData.addSeparator();
        menuData.add(menuExit);

        menuBar.add(menuData);

        this.setJMenuBar(menuBar);

        menuHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelUtama, "Home");
            }
        });

        menuMahasiswa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelUtama, "Mahasiswa");
            }
        });

        menuMataKuliah.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelUtama, "MataKuliah");
            }
        });

        menuKegiatan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelUtama, "Kegiatan");
            }
        });

        menuExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        this.add(panelUtama);

        cardLayout.show(panelUtama, "Home");

        this.setSize(800, 650);
        this.setLocationRelativeTo(null);
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