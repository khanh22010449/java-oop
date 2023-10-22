package GiaoDienCuaBanQuanLy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.sql.SQLException;

public class GiaoDienListener implements ActionListener {
    private GiaoDien GiaoDien;
    public GiaoDienListener(GiaoDienCuaBanQuanLy.GiaoDien GiaoDien){
        this.GiaoDien = GiaoDien;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("Thông Tin Cá Nhân")){
            if(this.GiaoDien.viewroom.isVisible()||this.GiaoDien.HD.isVisible()){
                this.GiaoDien.viewroom.setVisible(false);
                this.GiaoDien.HD.setVisible(false);
                this.GiaoDien.ThongtinBQL.setVisible(true);
            }
            try {
                this.GiaoDien.ThongTinBanQL();
                this.GiaoDien.ThongTinBanQL();
                this.GiaoDien.refresh();
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if(src.equals("Thông Tin Phòng")){
            if(this.GiaoDien.ThongtinBQL.isVisible()||this.GiaoDien.HD.isVisible()){
                this.GiaoDien.ThongtinBQL.setVisible(false);
                this.GiaoDien.HD.setVisible(false);
                this.GiaoDien.viewroom.setVisible(true);
            }
            else{
                this.GiaoDien.viewroom.setVisible(true);
                this.GiaoDien.ThongTinRooms();
            }
            this.GiaoDien.ThongTinRooms();
            this.GiaoDien.refresh();
        }
        else if(src.equals("Nhập Tiền Điện Nước")){
            if(this.GiaoDien.ThongtinBQL.isVisible()|| this.GiaoDien.viewroom.isVisible()){
                this.GiaoDien.ThongtinBQL.setVisible(false);
                this.GiaoDien.viewroom.setVisible(false);
                this.GiaoDien.HD.setVisible(true);
            }
            else{
                this.GiaoDien.HD.setVisible(true);
                this.GiaoDien.ThongTinRooms();
            }
            this.GiaoDien.DienHoaDon();
            this.GiaoDien.refresh();
        }
    }
}
