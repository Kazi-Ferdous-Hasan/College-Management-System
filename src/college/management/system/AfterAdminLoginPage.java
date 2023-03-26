package college.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class AfterAdminLoginPage extends JFrame {

    public AfterAdminLoginPage() {
        
        JButton teacher = new JButton("Teacher info");
        JButton staff = new JButton("Staff info");
        teacher.setBounds(305, 100, 200, 40);
        staff.setBounds(305, 150, 200, 40);
        add(teacher);
        add(staff);
        teacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                TeacherInfo ti = new TeacherInfo();
                setVisible(false);
            }
        });
        
        staff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                StaffInfo si = new StaffInfo();
                setVisible(false);
            }
        });

        JButton logout = new JButton("Log Out");
        logout.setBounds(305, 200, 200, 40);
        add(logout);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                AdminLogin al = new AdminLogin();
                setVisible(false);
            }

        });
        Image icon = Toolkit.getDefaultToolkit().getImage("E:\\Spring21\\CSE110\\College Management System\\src\\college\\management\\system\\Admin.png");
        setIconImage(icon);
        getContentPane().setBackground(Color.ORANGE);
        setLayout(null);
        setVisible(true);
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
