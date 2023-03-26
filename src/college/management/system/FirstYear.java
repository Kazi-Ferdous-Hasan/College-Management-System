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

public class FirstYear extends JFrame {

    public FirstYear() {
        JButton y1 = new JButton("Add student info");
        JButton y2 = new JButton("Student Table");
        y1.setBounds(305, 100, 200, 40);
        y2.setBounds(305, 150, 200, 40);
        add(y1);
        add(y2);
        y1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                FirstYearForm ti = new FirstYearForm();
                setVisible(false);
            }
        });
        y2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    FirstYearTable ti = new FirstYearTable();
                } catch (IOException ex) {
                    Logger.getLogger(FirstYear.class.getName()).log(Level.SEVERE, null, ex);
                }
                setVisible(false);
            }
        });

        JButton logout = new JButton("Back");
        logout.setBounds(305, 200, 200, 40);
        add(logout);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                AfterStudentLoginPage al = new AfterStudentLoginPage();
                setVisible(false);
            }

        });
        Image icon = Toolkit.getDefaultToolkit().getImage("E:\\Spring21\\CSE110\\College Management System\\src\\college\\management\\system\\Std.png");
        setIconImage(icon);
        getContentPane().setBackground(Color.ORANGE);
        setLayout(null);
        setVisible(true);
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
