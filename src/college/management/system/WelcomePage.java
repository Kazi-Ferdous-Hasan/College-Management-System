package college.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class WelcomePage extends JFrame {

    public WelcomePage() {

        JLabel lll = new JLabel("HOMEPAGE");
        lll.setFont(new Font("Times New Roman",Font.BOLD,25));
        lll.setBounds(300, 50, 200, 30);
        add(lll);
        
        JLabel l = new JLabel("Welcome to National Ideal College");
        l.setFont(new Font("Times New Roman",Font.BOLD,25));
        l.setBounds(200, 80, 400, 30);
        add(l);
        
        JLabel ll = new JLabel("Khilgaon, DHAKA-1214");
        ll.setFont(new Font("Times New Roman",Font.BOLD,18));
        ll.setBounds(280, 110, 200, 30);
        add(ll);
        
        JButton b1 = new JButton("Admin Login");
        JButton b2 = new JButton("Student Admin Login");
        b1.setBounds(275, 150, 200, 40);
        b2.setBounds(275, 200, 200, 40);
        add(b1);
        add(b2);
        
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                AdminLogin frame2 = new AdminLogin();
                //frame2.setBackground(Color.red);
                setVisible(false);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                StudentLogin frame2 = new StudentLogin();
                frame2.setBackground(Color.red);
                setVisible(false);
            }
        });

        Image icon = Toolkit.getDefaultToolkit().getImage("E:\\Spring21\\CSE110\\College Management System\\src\\college\\management\\system\\NicLogo.png");
        setIconImage(icon);
        getContentPane().setBackground(Color.ORANGE);
        setLayout(null);
        setVisible(true);
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
