package college.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class FirstYearTable extends JFrame {

    public FirstYearTable() throws IOException {

        DefaultTableModel dtm = new DefaultTableModel(0, 0);
        String header[] = new String[]{"NAME", "ID", "SECTION"};
        dtm.setColumnIdentifiers(header);
        dtm.addRow(header);
        JTable tbl = new JTable(dtm);
        tbl.setBounds(0, 0, 1360, 600);
        tbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(tbl);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tbl.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tbl.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tbl.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        Font font = new Font("Verdana", Font.PLAIN, 15);
        tbl.setFont(font);
        tbl.setRowHeight(35);
        tbl.setBackground(new Color(54,180,210));
        tbl.setForeground(Color.black);
       

        JButton back = new JButton("Back");
        back.setBounds(700, 620, 200, 40);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                FirstYear t = new FirstYear();
                setVisible(false);
            }

        });
        
        JButton remove = new JButton("Remove");
        remove.setBounds(480, 620, 200,40);
        add(remove);
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int row = tbl.getSelectedRow();
                if (row > 0) {
                    //System.out.println("Index is: "+ row);
                    File inputFile = new File("E:\\Spring21\\CSE110\\College Management System\\src\\college\\management\\system\\FirstYearInput.txt");
                    File tempFile = new File("E:\\Spring21\\CSE110\\College Management System\\src\\college\\management\\system\\FirstYearTempFile.txt");

                    if (!tempFile.exists()) {
                        //tempFile.createNewFile("");
                        System.out.println("Temp File Does Not Exist");
                    } else {
                        System.out.println("Temp File Exist");
                    }
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
                        String currentLine;

                        while ((currentLine = reader.readLine()) != null) {
                            // trim newline when comparing with lineToRemove
                            String trimmedLine = currentLine.trim();
                            String lineToRemove = (String) tbl.getValueAt(row, 0) + "," + tbl.getValueAt(row, 1) + "," + tbl.getValueAt(row, 2);
                            System.out.println("Current Line: " + trimmedLine);
                            System.out.println("Remove Line: " + lineToRemove);
                            if (trimmedLine.equals(lineToRemove)) {
                                continue;
                            }
                            writer.write(currentLine + "\n");

                        }
                        writer.close();
                        reader.close();

                        reader = new BufferedReader(new FileReader(tempFile));
                        writer = new BufferedWriter(new FileWriter(inputFile));

                        while ((currentLine = reader.readLine()) != null) {

                            writer.write(currentLine + "\n");

                        }
                        writer.close();
                        reader.close();

                    } catch (IOException ex) {
                        Logger.getLogger(TeachersTable.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    // boolean s = inputFile.delete();
                    //boolean successful = tempFile.renameTo(inputFile);

                    dtm.removeRow(row);
                }

            }
        });

        File file = new File("E:\\Spring21\\CSE110\\College Management System\\src\\college\\management\\system\\FirstYearInput.txt");
        try {
            if (!file.exists()) {

            }
            BufferedReader out = new BufferedReader(new FileReader(file));
            String str = null;

            while ((str = out.readLine()) != null) {
                Vector<Object> data = new Vector<Object>();
                String[] token = str.split(",");
                data.add(token[0]);
                data.add(token[1]);
                data.add(token[2]);
                dtm.addRow(data);
            }

            Image icon = Toolkit.getDefaultToolkit().getImage("E:\\Spring21\\CSE110\\College Management System\\src\\college\\management\\system\\Std.png");
            setIconImage(icon);
            getContentPane().setBackground(new Color(60, 117, 160));
            setLayout(null);
            setVisible(true);
            setSize(3000, 950);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (Exception e) {

        }
    }

}
