import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.event.*;

class about extends JFrame {

    // Awal Codingan Background
    JLabel background = new JLabel(new ImageIcon("img/B.jpg"));
    // Akhir Codingan Background

    // Awal Codingan Judul Aplikasi
    JLabel judul = new JLabel("About");
    // JLabel judul2 = new JLabel("Kami Melayani Dengan Senang Hati");
    // Akhir Codingan Judul Aplikasi

    // Awal Codingan About
    JLabel nama = new JLabel("Name :");
    JLabel ZulFikri = new JLabel("ZulFikri Ridha M");
    JLabel kelas = new JLabel("Class :");
    JLabel jawab_kelas = new JLabel("2 TI B 1");
    JLabel jurusan = new JLabel("Nim :");
    JLabel jawab_jurusan = new JLabel("2021302033");
    // Akhir Codingan About

    // Awal Codingan Kembali
    JButton tb_kembali = new JButton("KEMBALI");
    // Akhir Codingan Kembali

    // Awal Deklarasi Panel
    JPanel panel = new JPanel();
    // Akhir Deklarasi Panel

    about() {
        setTitle("About");
        setBounds(400, 60, 600, 640);
    }

    void komponenvisual() {
        getContentPane().setLayout(null);

        // Awal Codingan Visual Judul 1
        getContentPane().add(judul);
        judul.setBounds(260, 40, 500, 40);
        judul.setFont(new Font("Arial", Font.BOLD, 20));
        // judul.setHorizontalAlignment(SwingConstants.CENTER);
        // Akhir Codingan Visual Judul 1

        // Awal Codingan Visual Tombol Menu
        getContentPane().add(panel);
        panel.setLayout(null);
        panel.setBounds(40, 120, 500, 430);
        panel.setBorder(new TitledBorder(new LineBorder(Color.black, 5)));
        panel.setOpaque(false);

        // Tombol Data Buku
        // panel.add(tb_databuku);
        // tb_databuku.setBounds(25, 80, 120, 60);
        // tb_databuku.setToolTipText("Data Buku");

        // Awal About
        // ============== NAME ============//
        panel.add(nama);
        nama.setBounds(20, 30, 100, 20);
        nama.setFont(new Font("Arial", Font.BOLD, 13));

        panel.add(ZulFikri);
        ZulFikri.setBounds(80, 30, 300, 20);
        ZulFikri.setFont(new Font("Arial", Font.BOLD, 13));

        // ============== CLASS ============//
        panel.add(kelas);
        kelas.setBounds(20, 60, 100, 20);
        kelas.setFont(new Font("Arial", Font.BOLD, 13));

        panel.add(jawab_kelas);
        jawab_kelas.setBounds(80, 60, 100, 20);
        jawab_kelas.setFont(new Font("Arial", Font.BOLD, 13));

        // ============== CLASS ============//
        panel.add(jurusan);
        jurusan.setBounds(20, 90, 100, 20);
        jurusan.setFont(new Font("Arial", Font.BOLD, 13));

        panel.add(jawab_jurusan);
        jawab_jurusan.setBounds(80, 90, 300, 20);
        jawab_jurusan.setFont(new Font("Arial", Font.BOLD, 13));
        // Akhir About

        // ========== AWAL CODINGAN TOMBOL KEMBALI ==========//
        getContentPane().add(tb_kembali);
        tb_kembali.setBounds(240, 555, 100, 40);
        // ========== Akhir CODINGAN TOMBOL KEMBALI ==========//

        setVisible(true);

        // Awal Codingan Visual Background
        getContentPane().add(background);
        background.setBounds(0, 0, 1154, 650);
        // Akhir Codingan Visual Background
    }

    void AksiReaksi() {
        // ================== CODINGAN TOMBOL KEMBALI ===============//
        tb_kembali.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu app = new Menu();
                app.komponen();
                app.AksiReaksi();
                dispose();
            }
        });
    }

    public static void main(String args[]) {
        about ab = new about();
        ab.komponenvisual();
        ab.AksiReaksi();

    }
}