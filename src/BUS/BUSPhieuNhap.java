/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.*;
import DTO.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
/**
 *
 * @author Hieu PC
 */
public class BUSPhieuNhap {
    DAOPhieuNhap DAO = new DAOPhieuNhap();
    public ArrayList<DTOPhieuNhap> getlist() throws SQLException, ParseException{
        return DAO.getlist();
    }
    public int addphieunhap(DTOPhieuNhap i) throws SQLException{
        return DAO.addphieunhap(i);
    }
    public int updatePhieuNhap(DTOPhieuNhap i) throws SQLException{
        return DAO.updatephieunhap(i);
    }
<<<<<<< Updated upstream
=======
    public DTOPhieuNhap getpn(int mapn) throws SQLException, ParseException{
        return DAO.getpn(mapn);
    }
    public double updatetongtienpn(DTOPhieuNhap i) throws SQLException{
        return DAO.updatephieunhaptongtien(i);
    }
    public double gettong(ArrayList<DTOCTPhieuNhap> i){
        double tong = 0;
        for(DTOCTPhieuNhap a: i){
            tong += a.getDonGia();
        }
        return tong;
    }
    public double gettonghd(ArrayList<DTOCTPhieuNhap> i,int mapn){
        double tong = 0;
        for(DTOCTPhieuNhap a: i){
            if(a.getMaPhieuNhap() == mapn){
                tong += a.getDonGia();
            }
        }
        return tong;
    }
    public void jtimport(JTable jt,ArrayList<DTOPhieuNhap> list) throws SQLException{
        
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Mã phiếu nhập");
        model.addColumn("Tên nhà cung cấp");
        model.addColumn("Nhân viên tạo phiếu nhập");
        model.addColumn("Ngày nhập");
        model.addColumn("Tổng tiền");
        model.addColumn("Ghi chú");
        
        for(DTOPhieuNhap i: list){
            DTONhaCungCap ncc = new DTONhaCungCap();
            ncc.setMaNhaCungCap(i.getMaNhaCungCap());
            ncc = DAOncc.getncc(ncc);
            DTONhanVien nv = new DTONhanVien();
            nv.setMaNhanVien(i.getMaNhanVien());
            nv = DAOnv.getnv(nv);
            model.addRow(new Object[]{i.getMaPhieuNhap(),ncc.getTenNhaCungCap(),nv.getTenNhanVien(),i.getNgayNhap(),i.getTongTien(),i.getGhiChu()});
        }
        jt.setModel(model);
    }
    public ArrayList<DTOPhieuNhap> jtexport(JTable jt) throws SQLException{
        ArrayList<DTOPhieuNhap> list = new ArrayList<>();
        int size = jt.getRowCount();
        for(int i = 0; i < size; i++){
            DTOPhieuNhap a = new DTOPhieuNhap();
            a.setMaPhieuNhap(Integer.parseInt(jt.getValueAt(i, 0).toString()));
            try {
                a = DAO.getpn(a.getMaPhieuNhap());
                list.add(a);
            } catch (ParseException ex) {
                Logger.getLogger(BUSPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    public void cbnccimport(JComboBox jcb,ArrayList<DTONhaCungCap> ncc){
        jcb.removeAllItems();
        jcb.addItem("Nhà cung cấp");
        for(DTONhaCungCap i: ncc){
            jcb.addItem(i.getTenNhaCungCap());
        }
    }
    public Date convertStringToDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // Trả về null nếu có lỗi chuyển đổi
        }
    }
    public ArrayList<DTOPhieuNhap> searchghichu(ArrayList<DTOPhieuNhap> list,String ghichu){
        ArrayList<DTOPhieuNhap> result = new ArrayList<>();
        for(DTOPhieuNhap i: list){
            if(i.getGhiChu() != null && i.getGhiChu().contains(ghichu)){
                result.add(i);
            }
        }
        return result;
    }
    public ArrayList<DTOPhieuNhap> searchtenncc(ArrayList<DTOPhieuNhap> list,String tenncc) throws SQLException{
        ArrayList<DTOPhieuNhap> result = new ArrayList<>();
        for(DTOPhieuNhap i: list){
            DTONhaCungCap ncc = new DTONhaCungCap();
            ncc.setMaNhaCungCap(i.getMaNhaCungCap());
            ncc = DAOncc.getncc(ncc);
            if(ncc.getTenNhaCungCap().contains(tenncc)){
                result.add(i);
            }
        }
        return result;
    }
    public ArrayList<DTOPhieuNhap> searchtennv(ArrayList<DTOPhieuNhap> list,String tennv) throws SQLException{
        ArrayList<DTOPhieuNhap> result = new ArrayList<>();
        for(DTOPhieuNhap i: list){
            DTONhanVien nv = new DTONhanVien();
            nv.setMaNhanVien(i.getMaNhanVien());
            nv = DAOnv.getnv(nv);
            if(nv.getTenNhanVien().equals(tennv)){
                result.add(i);
            }
        }
        return result;
    }
    public ArrayList<DTOPhieuNhap> searchdate(ArrayList<DTOPhieuNhap> list,Date day1,Date day2){
        ArrayList<DTOPhieuNhap> result = new ArrayList<>();
        for(DTOPhieuNhap i: list){
            if(i.getNgayNhap().after(day1) && i.getNgayNhap().before(day2)){
                result.add(i);
            }
        }
        return result;
    }
    public ArrayList<DTOPhieuNhap> searchmoney(ArrayList<DTOPhieuNhap> list,double var1,double var2){
        ArrayList<DTOPhieuNhap> result = new ArrayList<>();
        for(DTOPhieuNhap i: list){
            if(i.getTongTien() >= var1 && i.getTongTien() <= var2){
                result.add(i);
            }
        }
        return result;
    }
    public boolean checkpn(DTOPhieuNhap i) throws SQLException, ParseException{
        return DAO.checkpn(i);
    }
>>>>>>> Stashed changes
}
