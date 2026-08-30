import java.awt.event.*;
import javax.swing.*;

public class HelloRadioButton extends JFrame {

    public HelloRadioButton(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelInput = new JLabel("Nama:");
        labelInput.setBounds(15,40,350,10);

        JTextField textField = new JTextField();
        textField.setBounds(15,60,350,30);

        JLabel labelNomorHP = new JLabel("Nomor HP:");
        labelNomorHP.setBounds(15,100,350,10);

        JTextField textFieldNomorHP = new JTextField();
        textFieldNomorHP.setBounds(15,120,350,30);

        JLabel labelRadio = new JLabel("Jenis Kelamin:");
        labelRadio.setBounds(15,160,350,10);

        JRadioButton radioButton1 = new JRadioButton("Laki-Laki", true);
        radioButton1.setBounds(15,175,350,30);

        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(15,205,350,30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
        checkBox.setBounds(15,235,350,30);
        JLabel labelTabungan = new JLabel("Jenis Tabungan:");
            labelTabungan.setBounds(15,265,350,20);

            String[] jenisTabungan = {
                "Tabungan 1",
                "Tabungan 2",
                "Tabungan 3",
                "Tabungan 4"
            };

        JList<String> listTabungan = new JList<>(jenisTabungan);
        listTabungan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPaneTabungan = new JScrollPane(listTabungan);
        scrollPaneTabungan.setBounds(15,290,200,80);

        JButton button = new JButton("Simpan");
        button.setBounds(15,385,100,40);

        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(15,430,550,100);

        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String jenisKelamin = "";

                if(radioButton1.isSelected()){
                    jenisKelamin = radioButton1.getText();
                }

                if(radioButton2.isSelected()){
                    jenisKelamin = radioButton2.getText();
                }

                String nama = textField.getText();
                String nomorHP = textFieldNomorHP.getText();
                String tabungan = listTabungan.getSelectedValue();

                txtOutput.append("Nama\t\t: "+nama+"\n");
                txtOutput.append("Nomor HP\t\t: "+nomorHP+"\n");
                txtOutput.append("Jenis Kelamin\t\t: "+jenisKelamin+"\n");
                txtOutput.append("Jenis Tabungan\t\t: "+tabungan+"\n");

                if(checkBox.isSelected()){
                    txtOutput.append("WNA\t\t: Ya\n");
                }else{
                    txtOutput.append("WNA\t\t: Bukan\n");
                }

                txtOutput.append("========================================\n");

                textField.setText("");
                textFieldNomorHP.setText("");
            }
        });

        this.add(labelTabungan);
        this.add(scrollPaneTabungan);   
        this.add(button);
        this.add(textField);
        this.add(textFieldNomorHP);
        this.add(labelNomorHP);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(checkBox);
        this.add(labelInput);
        this.add(txtOutput);

        this.setSize(600,620);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloRadioButton h = new HelloRadioButton();
                h.setVisible(true);
            }
        });
    }
}