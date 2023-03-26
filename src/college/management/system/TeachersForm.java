package college.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;

public class TeachersForm extends JFrame {

    public TeachersForm() {

        JLabel header = new JLabel("Add Teacher's Information");
        header.setFont(new Font("Times New Roman",Font.BOLD,18));
        header.setBounds(295, 80, 400, 40);
        add(header);
        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(220, 120, 200, 40);
        add(nameLabel);

        JLabel designationLabel = new JLabel("Designation: ");
        designationLabel.setBounds(220, 170, 200, 40);
        add(designationLabel);

        JLabel ageLabel = new JLabel("Age: ");
        ageLabel.setBounds(220, 220, 200, 40);
        add(ageLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(300, 120, 200, 30);
        add(nameField);

        JTextField designationField = new JTextField();
        designationField.setBounds(300, 170, 200, 30);
        add(designationField);

        JTextField ageField = new JTextField();
        ageField.setBounds(300, 220, 200, 30);
        add(ageField);

        JButton save = new JButton("Save");
        save.setBounds(400, 270, 100, 40);
        add(save);

        JLabel sm = new JLabel("");
        sm.setBounds(300, 300, 300, 100);
        add(sm);
        sm.setVisible(false);

        Image icon = Toolkit.getDefaultToolkit().getImage("E:\\Spring21\\CSE110\\College Management System\\src\\college\\management\\system\\Teacher.jpg");
        setIconImage(icon);
        getContentPane().setBackground(Color.ORANGE);
        setLayout(null);
        setVisible(true);
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton back = new JButton("Back");
        back.setBounds(270, 270, 100, 40);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                TeacherInfo t = new TeacherInfo();
                setVisible(false);
            }

        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String name = nameField.getText();
                String designation = designationField.getText();
                String age = ageField.getText();

                File file = new File("E:\\Spring21\\CSE110\\College Management System\\src\\college\\management\\system\\TeacherInput.txt");
                try {
                    if (!file.exists()) {

                        file.createNewFile();

                    }
                    FileWriter fw = new FileWriter(file, true);
                    fw.append(name + "," + designation + "," + age + "\n");

                    nameField.setText("");
                    designationField.setText("");
                    ageField.setText("");
                    sm.setText("Info Saved Successfully!");
                    sm.setVisible(true);

                    Timer t = new Timer(3000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            sm.setText("");
                        }
                    });
                    t.setRepeats(false);
                    t.start();

                    fw.close();
                } catch (IOException e) {
                    Logger.getLogger(TeachersForm.class.getName()).log(Level.SEVERE, null, e);
                }

            }
        });
    }

}
