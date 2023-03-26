package college.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class StudentLogin extends JFrame {
    
    public StudentLogin() {
        
        JLabel msg = new JLabel("Student Admin Login Page");
        msg.setFont(new Font("Times New Roman",Font.BOLD,18));
        msg.setBounds(280, 60, 300, 40);
        add(msg);
        JLabel id = new JLabel("User ID: ");
        id.setBounds(220, 100, 200, 40);
        add(id);
        JLabel pass = new JLabel("Password: ");
        pass.setBounds(220, 150, 200, 40);
        add(pass);
        JTextField t = new JTextField();
        t.setBounds(285, 100, 200, 30);
        add(t);
        JPasswordField p = new JPasswordField();
        p.setBounds(285, 150, 200, 30);
        add(p);
        JButton login = new JButton("Login");
        login.setBounds(390, 200, 100, 40);
        add(login);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String var = t.getText();
                    var += new String(p.getPassword());
                    String idpass = "studentstd123";
                    if (idpass.equals(var)) {
                        AfterStudentLoginPage astdlp = new AfterStudentLoginPage();
                        setVisible(false);
                    } else {
                        //StudentLogin stdl = new StudentLogin();
                        //setVisible(false);
                        JOptionPane.showMessageDialog(null, "Invalid id or password!\nPlease try again.");
                    }
                }
                catch(HeadlessException e){
                    JOptionPane.showMessageDialog(null, "Something went wrong, Please try again.");
                }

            }
        });
        JButton back = new JButton("Back");
        back.setBounds(270, 200, 100, 40);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                WelcomePage wp = new WelcomePage();
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










