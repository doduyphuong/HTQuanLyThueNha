package pojos;
// Generated Sep 27, 2019 9:45:19 AM by Hibernate Tools 4.3.1



/**
 * Nha generated by hbm2java
 */
public class Nha  implements java.io.Serializable {


     private Integer maNha;
     private String diaChi;
     private String quan;
     private String thanhPho;
     private String khuVuc;
     private Float tienThue1thang;
     private Integer loaiNha;
     private Integer chuNha;
     private Integer chiNhanhDangKy;

    public Nha() {
    }

	
    public Nha(String diaChi, String quan, String thanhPho, String khuVuc) {
        this.diaChi = diaChi;
        this.quan = quan;
        this.thanhPho = thanhPho;
        this.khuVuc = khuVuc;
    }
    public Nha(String diaChi, String quan, String thanhPho, String khuVuc, Float tienThue1thang, Integer loaiNha, Integer chuNha, Integer chiNhanhDangKy) {
       this.diaChi = diaChi;
       this.quan = quan;
       this.thanhPho = thanhPho;
       this.khuVuc = khuVuc;
       this.tienThue1thang = tienThue1thang;
       this.loaiNha = loaiNha;
       this.chuNha = chuNha;
       this.chiNhanhDangKy = chiNhanhDangKy;
    }
   
    public Integer getMaNha() {
        return this.maNha;
    }
    
    public void setMaNha(Integer maNha) {
        this.maNha = maNha;
    }
    public String getDiaChi() {
        return this.diaChi;
    }
    
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public String getQuan() {
        return this.quan;
    }
    
    public void setQuan(String quan) {
        this.quan = quan;
    }
    public String getThanhPho() {
        return this.thanhPho;
    }
    
    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }
    public String getKhuVuc() {
        return this.khuVuc;
    }
    
    public void setKhuVuc(String khuVuc) {
        this.khuVuc = khuVuc;
    }
    public Float getTienThue1thang() {
        return this.tienThue1thang;
    }
    
    public void setTienThue1thang(Float tienThue1thang) {
        this.tienThue1thang = tienThue1thang;
    }
    public Integer getLoaiNha() {
        return this.loaiNha;
    }
    
    public void setLoaiNha(Integer loaiNha) {
        this.loaiNha = loaiNha;
    }
    public Integer getChuNha() {
        return this.chuNha;
    }
    
    public void setChuNha(Integer chuNha) {
        this.chuNha = chuNha;
    }
    public Integer getChiNhanhDangKy() {
        return this.chiNhanhDangKy;
    }
    
    public void setChiNhanhDangKy(Integer chiNhanhDangKy) {
        this.chiNhanhDangKy = chiNhanhDangKy;
    }




}


