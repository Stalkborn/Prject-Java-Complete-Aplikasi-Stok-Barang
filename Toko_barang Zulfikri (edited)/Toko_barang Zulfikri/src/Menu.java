import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.event.*;

class Menu extends JFrame {

    JButton BtData_Barang = new JButton("Data Barang");
    JButton BtData_Pelanggan = new JButton("Data Pelanggan");
    JButton BtAbout = new JButton("About");
    JButton BtLogout = new JButton("Logout");
    
    JLabel background = new JLabel(new ImageIcon("gambar/bgb.jpg"));

    JLabel Menu = new JLabel("Menu");
    JLabel BorderMenu = new JLabel();

    //jpanel
    JPanel panel1 = new JPanel();

    Menu()
    {
        setTitle("zulfikri ridha M");
        setLocation(200,20);
        setSize(400,600);
        setResizable(false);
        setVisible(true);
    }

    void komponen()
    {
        getContentPane().setLayout(null);
        
        getContentPane().add(panel1);
        panel1.setLayout(null);
        panel1.setBounds(40,80,300,400);
        panel1.setBorder(new TitledBorder(new LineBorder(Color.black, 5)));


        panel1.add(BtData_Barang);
        BtData_Barang.setBounds(75,50,150,40);
        BtData_Barang.setIcon(new ImageIcon("gambar/open-box.png"));

        panel1.add(BtData_Pelanggan);
        BtData_Pelanggan.setBounds(75,120,150,40);
        BtData_Pelanggan.setIcon(new ImageIcon("gambar/pelanggan.png"));

        panel1.add(BtAbout);
        BtAbout.setBounds(75,190,150,40);
        BtAbout.setIcon(new ImageIcon("gambar/boxes.png"));

        panel1.add(BtLogout);
        BtLogout.setBounds(75,260,150,40);
        BtLogout.setIcon(new ImageIcon("gambar/logout.png"));

        panel1.add(Menu);
        Menu.setBounds(130,0,70,60);
        Menu.setFont(new Font("Times New Roman", Font.BOLD,20));

        getContentPane().add(background);
        background.setBounds(0,0,900,800);

        setVisible(true);

        // Background
        getContentPane().add(background);
        background.setBounds(0,0,400,600);
    }

    void AksiReaksi() 
    {

           //tombolbarang
           BtData_Barang.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                TableBarang Tp = new TableBarang();
                Tp.Komponenvisual();
                Tp.AksiReaksi();
                dispose();
            }
        });
        

        //tombolpelanggan
        BtData_Pelanggan.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                TablePelanggan Tp = new TablePelanggan();
                Tp.Komponenvisual();
                Tp.AksiReaksi();
                dispose();
            }
        });

        
        //tombolabout
        BtAbout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                about Tp = new about();
                Tp.komponenvisual();
                Tp.AksiReaksi();
                dispose();
            }
        });


        //tombol logout
        BtLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                Login lg = new Login();
                lg.komponen();
                lg.AksiReaksi();
                dispose();
            }
        });
        //akhir logout
    }

    public static void main (String args[])
    {
        Menu As = new Menu();
        As.komponen();
        As.AksiReaksi();
    }
}
