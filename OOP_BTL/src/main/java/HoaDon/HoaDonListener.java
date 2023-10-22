package HoaDon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HoaDonListener implements ActionListener {
    private HoaDonTungPhong hoaDonTungPhong;
    public void HoaDonListener(HoaDonTungPhong hoaDonTungPhong) {
        this.hoaDonTungPhong = hoaDonTungPhong;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
    }
}
