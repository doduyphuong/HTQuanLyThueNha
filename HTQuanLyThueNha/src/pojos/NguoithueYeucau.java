package pojos;
// Generated Sep 27, 2019 9:45:19 AM by Hibernate Tools 4.3.1

/**
 * NguoithueYeucau generated by hbm2java
 */
public class NguoithueYeucau implements java.io.Serializable {

    private int maNt;
    private int maLoaiNha;
    private Float nganSach;

    public NguoithueYeucau() {
    }

    public NguoithueYeucau(int maNt, int maLoaiNha, Float nganSach) {
        this.maNt = maNt;
        this.maLoaiNha = maLoaiNha;
        this.nganSach = nganSach;
    }

    public int getMaNt() {
        return maNt;
    }

    public void setMaNt(int maNt) {
        this.maNt = maNt;
    }

    public int getMaLoaiNha() {
        return maLoaiNha;
    }

    public void setMaLoaiNha(int maLoaiNha) {
        this.maLoaiNha = maLoaiNha;
    }


    public Float getNganSach() {
        return this.nganSach;
    }

    public void setNganSach(Float nganSach) {
        this.nganSach = nganSach;
    }

}
