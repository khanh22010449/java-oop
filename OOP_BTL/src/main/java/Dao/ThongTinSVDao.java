package Dao;

import SinhVienDangKy.ThongTinDangKy;
import TaoSQL.MySQL;
import ThongTinSV.ThongTinSV;

import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import ThongTinSV.ThongTinSV;
public class ThongTinSVDao {
    private static Connection conn = MySQL.getConnect();
    public static String msv;
    public static String toa;
    public static int phong;
    public static ThongTinSV tTsv;
    public static Vector getData() {
        ArrayList<ThongTinDangKy> student = ThongTinSVDao.getListSV();
        Vector result = new Vector<>();
        for (ThongTinDangKy x: student) {
            Vector temp = new Vector<>();
            temp.add(x.getMSV());
            temp.add(x.getName());
            temp.add(x.getSex());
            temp.add(x.getDate());
            temp.add(x.getPhone());
            temp.add(x.getAddress());
            temp.add(x.getCCCD());
            temp.add(x.getEmail());
            temp.add(x.getTinhTrang());
            temp.add(x.getMaNganh());
            temp.add(x.getChucvu());
            temp.add(x.getLop());
            temp.add(x.getSoPhong());
            temp.add(x.getToa());

            result.add(temp);
        }
        return result;
    }
    public static ArrayList<ThongTinDangKy> getListSV(){
        ArrayList<ThongTinDangKy> listSV = new ArrayList<>();
        String sql = "SELECT * FROM DsSV";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ThongTinDangKy SV = new ThongTinDangKy();
                SV.setUser(rs.getString("User"));
                SV.setPassWord(rs.getString("Password"));
                SV.setMSV(rs.getString("MSV"));
                SV.setName(rs.getString("Name"));
                SV.setSex(rs.getString("SEX"));
                SV.setPhone(rs.getString("Phone"));
                SV.setAddress(rs.getString("Address"));
                SV.setDate(rs.getString("date"));
                SV.setCCCD(rs.getString("CCCD"));
                SV.setEmail(rs.getString("Email"));
                SV.setTinhTrang(rs.getString("TinhTrang"));
                SV.setMaNganh(rs.getString("MaNganh"));
                SV.setLop(rs.getString("Lop"));
                SV.setChucvu(rs.getString("Chucvu"));
                SV.setSoPhong(rs.getInt("sophong"));
                SV.setToa(rs.getString("Toa"));
                listSV.add(SV);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return listSV;
    }
    public static ArrayList<ThongTinDangKy> SearchSV(){
        ArrayList<ThongTinDangKy> listSV = new ArrayList<>();
        String sql = "SELECT * FROM DsSV where MSV like '"+ msv +"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ThongTinDangKy SV = new ThongTinDangKy();
                SV.setUser(rs.getString("User"));
                SV.setPassWord(rs.getString("Password"));
                SV.setMSV(rs.getString("MSV"));
                SV.setName(rs.getString("Name"));
                SV.setSex(rs.getString("SEX"));
                SV.setPhone(rs.getString("Phone"));
                SV.setAddress(rs.getString("Address"));
                SV.setDate(rs.getString("date"));
                SV.setCCCD(rs.getString("CCCD"));
                SV.setEmail(rs.getString("Email"));
                SV.setTinhTrang(rs.getString("TinhTrang"));
                SV.setMaNganh(rs.getString("MaNganh"));
                SV.setLop(rs.getString("Lop"));
                SV.setChucvu(rs.getString("Chucvu"));
                SV.setSoPhong(rs.getInt("sophong"));
                SV.setToa(rs.getString("Toa"));
                listSV.add(SV);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return listSV;
    }
    public static Vector getSV() {
        ArrayList<ThongTinDangKy> student = ThongTinSVDao.SearchSV();
        Vector result = new Vector<>();
        for (ThongTinDangKy x: student) {
            Vector temp = new Vector<>();
            temp.add(x.getMSV());
            temp.add(x.getName());
            temp.add(x.getSex());
            temp.add(x.getDate());
            temp.add(x.getPhone());
            temp.add(x.getAddress());
            temp.add(x.getCCCD());
            temp.add(x.getEmail());
            temp.add(x.getChucvu());
            temp.add(x.getTinhTrang());
            temp.add(x.getMaNganh());
            temp.add(x.getLop());
            temp.add(x.getSoPhong());
            temp.add(x.getToa());

            result.add(temp);
        }
        return result;
    }
    public static boolean addSV(ThongTinDangKy TTdk){

        String sql = "Insert into DsSV(User,Password,MSV,Name,SEX,Phone,Address,date,CCCD,Email,TinhTrang,MaNganh,Lop,Chucvu,sophong,matoa) " +
                "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        try{
            PreparedStatement ps =conn.prepareStatement(sql);
            ps.setString(1,TTdk.getUser());
            ps.setString(2,TTdk.getPassword());
            ps.setString(3,TTdk.getMSV());
            ps.setString(4,TTdk.getName());
            ps.setString(5,TTdk.getSex());
            ps.setString(6,TTdk.getPhone());
            ps.setString(7,TTdk.getAddress());
            ps.setString(8,TTdk.getDate());
            ps.setString(9,TTdk.getCCCD());
            ps.setString(10,TTdk.getEmail());
            ps.setString(11,TTdk.getTinhTrang());
            ps.setString(12,TTdk.getMaNganh());
            ps.setString(13,TTdk.getLop());
            ps.setString(14,TTdk.getChucvu());
            ps.setInt(15,TTdk.getSoPhong());
            ps.setString(16,TTdk.getToa());
            return ps.executeUpdate() > 0 ;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    public static boolean deleteSV(){
        String sql = "DELETE FROM DsSV WHERE msv=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, msv);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean update(){
        String sql = "UPDATE DsSV set sophong =?, toa= ? where msv like ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, phong);
            ps.setString(2,toa);
            ps.setString(3,msv);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
