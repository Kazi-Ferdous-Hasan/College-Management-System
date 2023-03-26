package college.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

public class StaffInfo extends JFrame {

    public StaffInfo() {

        JButton input = new JButton("Add Staff's Info");
        input.setBounds(305, 100, 200, 40);
        add(input);
        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                StaffsForm s = new StaffsForm();
                setVisible(false);
            }

        });

        JButton tbl = new JButton("Staff's Table");
        tbl.setBounds(305, 150, 200, 40);
        add(tbl);
        tbl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    StaffsTable st = new StaffsTable();
                } catch (IOException ex) {
                    Logger.getLogger(StaffInfo.class.getName()).log(Level.SEVERE, null, ex);
                }
                setVisible(false);
            }

        });

        JButton back = new JButton("Back");
        back.setBounds(305, 200, 200, 40);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                AfterAdminLoginPage al = new AfterAdminLoginPage();
                setVisible(false);
            }

        });
        Image icon = Toolkit.getDefaultToolkit().getImage("E:\\Spring21\\CSE110\\College Management System\\src\\college\\management\\system\\Staff.jpg");
        setIconImage(icon);
        getContentPane().setBackground(Color.ORANGE);
        setLayout(null);
        setVisible(true);
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
