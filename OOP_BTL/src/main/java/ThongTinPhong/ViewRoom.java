package ThongTinPhong;

import Dao.ThongTinSVDao;
import SinhVienDangKy.ThongTinDangKy;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class ViewRoom extends JPanel {
    public static String msv;
    private JComboBox<Integer> phong;
    private  JComboBox<String> toa;
    private JTextField text_msv;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private Vector vData;
    private Vector vTitle;
    public ViewRoom() throws SQLException{
        setSize(1000,680);
        setLayout(null);
        this.viewR();
    }
    public void viewR() {
        ActionListener ac = new RoomListener(this);

        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        vData = ThongTinSVDao.getData();
        vTitle = new Vector<>();
        vTitle.add("MSV");
        vTitle.add("Name");
        vTitle.add("Sex");
        vTitle.add("Phone");
        vTitle.add("Address");
        vTitle.add( "Date");
        vTitle.add("CCCD");
        vTitle.add("Email");
        vTitle.add("Tình Trạng");
        vTitle.add("Mã Ngành ");
        vTitle.add("Chức Vụ ");
        vTitle.add("Lớp ");
        vTitle.add("Phòng");
        vTitle.add("Tòa");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(vData, vTitle));
        jScrollPane1.setViewportView(jTable1);
        jScrollPane2.setViewportView(jScrollPane1);
        jScrollPane2.setBounds(30,30,880,400);

        Font font = new Font("Arial", Font.BOLD,14);

        JLabel jl_msv = new JLabel("Chọn MSV");
        jl_msv.setBounds(50, 480, 70,30);
        jl_msv.setFont(new Font("Cambria", Font.BOLD, 14));

        text_msv = new JTextField();
        text_msv.setFont(font);
        text_msv.setBounds(120, 480, 100,30);

        JLabel jl_toa = new JLabel("Chọn Tòa");
        jl_toa.setBounds(250, 480, 100,30);
        jl_toa.setFont(new Font("Cambria", Font.BOLD, 14));


        String[] s2 = {"C1","C2","B1","B2"};
        toa = new JComboBox(s2);
        toa.setBounds(340, 480, 60,30);
        toa.setFont(font);

        JLabel jl_Phong = new JLabel("Chọn Phòng");
        jl_Phong.setBounds(420, 480, 100,30);
        jl_Phong.setFont(new Font("Cambria", Font.BOLD, 14));

        Integer[] rooms = {101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,201,202,203,204,205,206,207,208,209,210,211,212,213,214,215,216,217,218,219,220,221,301,302,303,304,305,306,307,308,309,310,311,312,313,314,315,316,317,318,319,320,321,401,402,403,404,405,406,407,408,409,410,411,412,413,414,415,416,417,418,419,420,421};
        phong = new JComboBox(rooms);
        phong.setBounds(520,480,60,30);
        phong.setFont(font);

        JButton jb_search = new JButton("Tìm Kiếm");
        jb_search.setBorder(new LineBorder(Color.GRAY));
        jb_search.setBounds(700,480,150,30);
        jb_search.addActionListener(ac);

        JButton jb_view = new JButton("Hiện Thị Thông Tin");
        jb_view.setBorder(new LineBorder(Color.GRAY));
        jb_view.setBounds(700,450,150,30);
        jb_view.addActionListener(ac);

        JButton jb_delete = new JButton("DELETE SV");
        jb_delete.setBorder(new LineBorder(Color.GRAY));
        jb_delete.setBounds(700,510,150,30);
        jb_delete.addActionListener(ac);

        JButton jb_update = new JButton("UPDATE SV");
        jb_update.setBorder(new LineBorder(Color.GRAY));
        jb_update.setBounds(700,540,150,30);
        jb_update.addActionListener(ac);

        add(jb_update);
        add(jb_delete);
        add(jb_view);
        add(jl_msv);
        add(text_msv);
        add(jl_toa);
        add(toa);
        add(jl_Phong);
        add(phong);
        add(jb_search);
        add(jScrollPane2);
        //add(JsText);
    }
    public void HienThi() throws SQLException{
        Dao.ThongTinSVDao.msv = this.text_msv.getText();
        vData = ThongTinSVDao.getSV();
        vTitle = new Vector<>();
        vTitle.add("MSV");
        vTitle.add("Name");
        vTitle.add("Sex");
        vTitle.add("Phone");
        vTitle.add("Address");
        vTitle.add( "Date");
        vTitle.add("CCCD");
        vTitle.add("Email");
        vTitle.add("Tình Trạng");
        vTitle.add("Mã Ngành ");
        vTitle.add("Chức Vụ ");
        vTitle.add("Lớp ");
        vTitle.add("Phòng");
        vTitle.add("Tòa");
        jTable1.setModel(new javax.swing.table.DefaultTableModel(vData, vTitle));
    }
    public void HienThiThongTin() throws SQLException{
        vData = ThongTinSVDao.getData();
        vTitle = new Vector<>();
        vTitle.add("MSV");
        vTitle.add("Name");
        vTitle.add("Sex");
        vTitle.add("Phone");
        vTitle.add("Address");
        vTitle.add( "Date");
        vTitle.add("CCCD");
        vTitle.add("Email");
        vTitle.add("Tình Trạng");
        vTitle.add("Mã Ngành ");
        vTitle.add("Chức Vụ ");
        vTitle.add("Lớp ");
        vTitle.add("Phòng");
        vTitle.add("Tòa");
        jTable1.setModel(new javax.swing.table.DefaultTableModel(vData, vTitle));
    }
    public void deleteSV(){
        Dao.ThongTinSVDao.msv = this.text_msv.getText();
        ThongTinSVDao.deleteSV();
    }

    public void updateSV(){
        ThongTinSVDao.msv = this.text_msv.getText();
        ThongTinSVDao.toa = this.toa.getItemAt(toa.getSelectedIndex());
        ThongTinSVDao.phong = this.phong.getItemAt(phong.getSelectedIndex());
        ThongTinSVDao.update();
    }
}