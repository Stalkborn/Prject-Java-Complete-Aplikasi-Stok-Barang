import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.border.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

class TableBarang extends JFrame{
    JLabel title = new JLabel("");
    JLabel Txbarang = new JLabel("DATA BARANG");

    //JLabel KodeBarang = new JLabel("Kode Barang");
    //JLabel NamaBarang = new JLabel("Nama_barang Barang");

    // Awal Deklarasi Database
    Connection koneksi = null;
    // Akhir Dekalarasi Database

    JButton BtTambah = new JButton("TAMBAH");
    JButton BtEdit = new JButton("EDIT");
    JButton BtHapus = new JButton("HAPUS");
    JButton BtKembali = new JButton("KEMBALI");
    JButton BtSearch = new JButton("SEARCH ID");
    JButton BtPrint = new JButton("PRINT");

  
    JLabel Id_barang = new JLabel("ID BARANG");
    JLabel Nama_barang = new JLabel("NAMA BARANG");
    JLabel Perusahaan = new JLabel("NAMA PERUSAHAAN");
    JLabel Harga_beli = new JLabel("HARGA JUAL");
    JLabel Harga_jual = new JLabel("HARGA BELI");

    //text field
    JTextField TbId_barang = new JTextField();
    JTextField TbNama_barang = new JTextField();
    JTextField TbPerushaan = new JTextField();
    JTextField TbHarga_beli = new JTextField();
    JTextField TbHarga_jual = new JTextField();

    //panel
    JPanel panel2 = new JPanel();
    
      // Awal Codingan Model
      String header[] = { "Id_barang", "Nama_barang","Perushaan","harga_beli","Harga_jual" };

      DefaultTableModel model = new DefaultTableModel(null, header);
      JTable tabel = new JTable(model);
      JScrollPane pane = new JScrollPane(tabel);
      Dimension dimensi = new Dimension(15, 2);
      // Akhir Codingan Model

    TableBarang()
    {
        setTitle("Table Barang");
        setLocation(260,10);
        setSize(900,600);
        setResizable(false);
        setVisible(true);
    }

    void Komponenvisual()
    {
        //Title
        getContentPane().setLayout(null);
        getContentPane().add(Txbarang);
        Txbarang.setBounds(360, 20,200,40);
        Txbarang.setFont(new Font("Times New Roman" , Font.BOLD , 20));


        //panel
        getContentPane().add(panel2);
        panel2.setBounds(70,70,750,450);
        panel2.setLayout(null);
        panel2.setBorder(new TitledBorder(new LineBorder(Color.black, 5)));


        //Button
       panel2.add(BtTambah);
        BtTambah.setBounds(20,380,100,60);
        BtTambah.setIcon(new ImageIcon("img/save.png"));

       panel2.add(BtEdit);
        BtEdit.setBounds(130,380,100,60);
        BtEdit.setIcon(new ImageIcon("img/writing.png"));

       panel2.add(BtHapus);
        BtHapus.setBounds(240,380,100,60);
        BtHapus.setIcon(new ImageIcon("img/delete.png"));

       panel2.add(BtKembali);
        BtKembali.setBounds(350,380,100,60);
        BtKembali.setIcon(new ImageIcon("img/kembali.png"));

       panel2.add(BtSearch);
        BtSearch.setBounds(160,170,110,40);
        BtSearch.setIcon(new ImageIcon("img/search3.png"));

       panel2.add(BtPrint);
        BtPrint.setBounds(650,400,90,40);
        BtPrint.setIcon(new ImageIcon("img/print.png"));
        
        //label

       panel2.add(Id_barang);
        Id_barang.setBounds(20,0,130,60);

       panel2.add(Nama_barang);
        Nama_barang.setBounds(20,30,130,60);

       panel2.add(Perusahaan);
        Perusahaan.setBounds(20,60,130,60);

       panel2.add(Harga_beli);
        Harga_beli.setBounds(20,90,130,60);

       panel2.add(Harga_jual);
        Harga_jual.setBounds(20,120,130,60);

        //jtext field
       panel2.add(TbId_barang);
        TbId_barang.setBounds(150,20,120,25);

       panel2.add(TbNama_barang);
        TbNama_barang.setBounds(150,50,120,25);

       panel2.add(TbPerushaan);
        TbPerushaan.setBounds(150,80,120,25);

       panel2.add(TbHarga_beli);
        TbHarga_beli.setBounds(150,110,120,25);

       panel2.add(TbHarga_jual);
        TbHarga_jual.setBounds(150,140,120,25);

         // Codingan Menampilkan Form Data Tabel
         panel2.add(pane);
         pane.setBounds(275, 20, 465, 300);
         pane.setOpaque(false);
         pane.getViewport().setOpaque(false);
 
         tabel.setShowGrid(true);
         tabel.setShowVerticalLines(true);
         tabel.setIntercellSpacing(new Dimension((dimensi)));
         tabel.setGridColor(Color.GREEN);
         // Codingan Menampilkan Form Data Tabel

         setVisible(true);

         koneksiDatabase();
         tampilTabel();
         bersihdata();
    }



    //voidaksi reaksi
    void AksiReaksi()
    {
        //===============bttambah===================//
        BtTambah.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String sql = "insert into tabelbarang values(?,?,?,?,?)";
                    PreparedStatement pr = koneksi.prepareStatement(sql);

                    pr.setString(1, TbId_barang.getText());
                    pr.setString(2, TbNama_barang.getText());
                    pr.setString(3, TbPerushaan.getText());
                    pr.setString(4, TbHarga_beli.getText());
                    pr.setString(5, TbHarga_jual.getText());
                 
                    pr.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Data Telah Di Tambahkan");

                    tampilTabel();
                    bersihdata();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Data Gagal DI Tambahkan");
                    System.out.println(ex);
                }
            }

        });
        //=========akhir==============///

        ///===================search================////
        BtSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idbarang = TbId_barang.getText();

                try {
                    Statement state = koneksi.createStatement();

                    String sql = "Select * from tabelbarang where id_barang ='" + idbarang + "'";
                    ResultSet rs = state.executeQuery(sql);

                    if (rs.next()) {
                       TbId_barang.setText(rs.getString(1));
                       TbNama_barang.setText(rs.getString(2));
                       TbPerushaan.setText(rs.getString(3));
                       TbHarga_beli.setText(rs.getString(4));
                       TbHarga_jual.setText(rs.getString(5));
                       
                       BtTambah.setEnabled(false);
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        ///========================akhir===================//

         // ================== CODINGAN TOMBOL KEMBALI ===============//
         BtKembali.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu app = new Menu();
                app.komponen();
                app.AksiReaksi();
                dispose();
            }
        });


        //==============awal==================//
         // =========== ========== CODINGAN AKSI REAKSI EDIT DATA ================== //
         BtEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == BtEdit) {
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        koneksi = DriverManager.getConnection("jdbc:mysql://localhost/toko_barang", "root", "");

                        String sql = "update tabelbarang set nama_barang=?, perushaan=?, harga_beli=?, harga_jual=? WHERE id_barang=?";
                        PreparedStatement pr = koneksi.prepareStatement(sql);

                        pr.setString(1, TbNama_barang.getText());
                        pr.setString(2, TbPerushaan.getText());
                        pr.setString(3, TbHarga_beli.getText());
                        pr.setString(4, TbHarga_jual.getText());
                        pr.setString(5, TbId_barang.getText());

                        pr.executeUpdate();
                        pr.close();
                        //koneksi.close();

                        tampilTabel();
                        bersihdata();
                        koneksiDatabase();

                        JOptionPane.showMessageDialog(null, "Data Sudah Di Edit");

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Data Gagal Di Edit");
                    }
                    BtEdit.setEnabled(true);
                }
            }
        });
        //=============akhir=================//

      

         // ===================== CODINGAN AKSI REAKSI HAPUS DATA ================== //
         BtHapus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idbarang = TbId_barang.getText();
                int tanya = JOptionPane.showConfirmDialog(null,
                        "Apakah Anda Yakin Ingin Menghapus Data Kode Barang " + idbarang + "?", "Konfirmasi",
                        JOptionPane.YES_NO_OPTION);

                if (tanya == 0) {
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        koneksi = DriverManager.getConnection("jdbc:mysql://localhost/toko_barang", "root", "");

                        String sql = "delete from tabelbarang where id_barang=? ";
                        PreparedStatement pr = koneksi.prepareStatement(sql);

                        pr.setString(1, idbarang);

                        pr.executeUpdate();
                        pr.close();

                        JOptionPane.showMessageDialog(null, "Data Telah Di Hapus");

                        tampilTabel();
                        bersihdata();

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error:" + ex, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });



        //======awal print ========//
          // ===================== CODINGAN AKSI REAKSI PRINT DATA ================== //
          BtPrint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                print();
            }
        });
        //=====akhir=========/



    }

    //koneksi database
    void koneksiDatabase()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException cnf)
        {
            System.out.println("Driver tak ditemukan : " + cnf);
        }
        try
        {
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/toko_barang","root","");
            System.out.println("sukses konek");
        }
        catch (SQLException se)
        {
            System.out.println("gagal konek " + se);
        }
    }
    //end koneksi databases


     // ===================== PRINT =====================//
     void print()
     {
         int y = 0;
         Frame fr = new Frame();
         PrintJob print = fr.getToolkit().getPrintJob(fr, "Prinnting", null, null);
         if (print != null) {
             Graphics g = print.getGraphics();
             if (g != null) {
 
                 g.drawString("PRINT DATA BARANG", 250, 40);
 
                 String Id = tabel.getColumnName(0);
                 String nama = tabel.getColumnName(1);
                 String alamat = tabel.getColumnName(2);
                 String no_hp = tabel.getColumnName(3);
                 String email = tabel.getColumnName(4);
 
                 g.setFont(new Font("Dialog", 1, 8));
                 g.drawString(Id, 120, 100);
                 g.drawString(nama, 180, 100);
                 g.drawString(alamat, 250, 100);
                 g.drawString(no_hp, 320, 100);
                 g.drawString(email, 390, 100);
                 g.drawLine(120, 103, 600, 103);
 
                 int n = model.getRowCount();
                 for (int i = 0; i < n; i++) {
                     int k = i + 1;
                     int j = 10 * k;
                     y = 103 + j;
 
                     g.setFont(new Font("Dialog", 0, 8));
                     String data_id = model.getValueAt(i, 0).toString();
                     String data_nama = model.getValueAt(i, 1).toString();
                     String data_alamat = model.getValueAt(i, 2).toString();
                     String data_no_hp = model.getValueAt(i, 3).toString();
                     String data_email = model.getValueAt(i, 4).toString();
                 
                     g.drawString(data_id, 120, y);
                     g.drawString(data_nama, 180, y);
                     g.drawString(data_alamat, 250, y);
                     g.drawString(data_no_hp, 320, y);
                     g.drawString(data_email, 390, y);
                 }
             }
             print.end();
             print.end();
         }
 
     }
     //=============akhir=============//


     // ================== CODINGAN HAPUS TABEL =================//
     void hapusTabel() {
        int row = model.getRowCount();
        for (int i = 0; i < row; i++) {
            model.removeRow(0);
        }
    }


     // ================== TAMPIL TABEL DATA VIEW ===============//
    // Awal Codingan Tampil Tabel
    void tampilTabel() {
        hapusTabel();
        try {
            Statement state = koneksi.createStatement();
            String sql = "select * from tabelbarang";
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                Object obj[] = new Object[5];
                obj[0] = rs.getString(1);
                obj[1] = rs.getString(2);
                obj[2] = rs.getString(3);
                obj[3] = rs.getString(4);
                obj[4] = rs.getString(5);
          
                model.addRow(obj);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    // Akhir Codingan Tampil Tabel
     // ==================== CODINGAN BERSIH DATA ====================//
    // Awal Codingan Bersih Data
    void bersihdata() {
        TbId_barang.setText("");
        TbNama_barang.setText("");
        TbPerushaan.setText("");
        TbHarga_beli.setText("");
        TbHarga_jual.setText("");
    }
    // Akhir Codingan Bersih Data


    public static void main(String args[])
    {
        TablePelanggan AI = new TablePelanggan();
        AI.Komponenvisual();
        AI.AksiReaksi();
    }
}
