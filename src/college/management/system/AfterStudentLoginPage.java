
package college.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class AfterStudentLoginPage extends JFrame{

    public AfterStudentLoginPage() {
        
        JButton y1 = new JButton("First Year");
        JButton y2 = new JButton("Second Year");
        y1.setBounds(305, 100, 200, 40);
        y2.setBounds(305, 150, 200, 40);
        add(y1);
        add(y2);
        y1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                FirstYear ti = new FirstYear();
                setVisible(false);
            }
        });
        y2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                SecondYear ti = new SecondYear();
                setVisible(false);
            }
        });
        
        JButton logout = new JButton("Log Out");
        logout.setBounds(305, 200, 200, 40);
        add(logout);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                StudentLogin al = new StudentLogin();
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
